package com.konyaco.fluent.example

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.konyaco.fluent.FluentTheme
import com.konyaco.fluent.LocalContentColor
import com.konyaco.fluent.background.Layer
import com.konyaco.fluent.background.Mica
import com.konyaco.fluent.component.*
import com.konyaco.fluent.darkColors
import com.konyaco.fluent.lightColors
import com.konyaco.fluent.icons.Icons
import com.konyaco.fluent.icons.regular.*

@Composable
fun App() {
    val systemDarkMode = isSystemInDarkTheme()
    var darkMode by remember(systemDarkMode) { mutableStateOf(systemDarkMode) }
    var displayDialog by remember { mutableStateOf(false) }

    FluentTheme(colors = if (darkMode) darkColors() else lightColors()) {
        Mica(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).horizontalScroll(rememberScrollState())) {
            val density = LocalDensity.current
            var scale by remember(density) { mutableStateOf(density.density) }

            Layer(
                modifier = Modifier.padding(start = 32.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                    .defaultMinSize(minWidth = 600.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, FluentTheme.colors.stroke.control.default),
                cornerRadius = 8.dp
            ) {
                Column(Modifier.padding(16.dp), Arrangement.spacedBy(8.dp)) {
                    Controller(scale, { scale = it }, darkMode, { darkMode = it })

                    CompositionLocalProvider(LocalDensity provides Density(scale)) {
                        Content()
                    }

                    AccentButton(onClick = {
                        displayDialog = true
                    }) { Text("Display Dialog") }
                    Box {
                        var expanded by remember { mutableStateOf(false) }

                        Button(onClick = {
                            expanded = true
                        }) {
                            Text("Show DropdownMenu")
                        }

                        fun close() {
                            expanded = false
                        }

                        DropdownMenu(expanded, ::close) {
                            DropdownMenuItem(::close) { Text("Option 1")}
                            DropdownMenuItem(::close) { Text("Option 2")}
                            DropdownMenuItem(::close) { Text("Option 3")}
                        }
                    }
                }
                Dialog(
                    title = "This is a example dialog",
                    visible = displayDialog,
                    cancelButtonText = "Cancel",
                    confirmButtonText = "Confirm",
                    onCancel = {
                        displayDialog = false
                    },
                    onConfirm = {
                        displayDialog = false
                    }
                )
            }
        }
    }
}

@Composable
private fun Controller(
    scale: Float,
    onScaleChange: (Float) -> Unit,
    darkMode: Boolean,
    onDarkModeChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Scale: %.2f".format(scale))
        val density = LocalDensity.current
        Button(onClick = { onScaleChange(density.density) }) { Text("Reset") }
        Switcher(darkMode, text = "Dark Mode", onCheckStateChange = { onDarkModeChange(it) })
    }
    Slider(
        modifier = Modifier.width(200.dp),
        value = scale,
        onValueChange = { onScaleChange(it) },
        valueRange = 1f..10f
    )
}

@Composable
private fun Content() {

    var sliderValue by remember { mutableStateOf(0.5f) }
    Slider(
        modifier = Modifier.width(200.dp),
        value = sliderValue,
        onValueChange = { sliderValue = it },
    )
    Buttons()

    Controls()

    Row {
        Layer(
            modifier = Modifier.size(32.dp),
            shape = RoundedCornerShape(4.dp),
            cornerRadius = 4.dp,
            color = FluentTheme.colors.fillAccent.default,
            border = BorderStroke(1.dp, FluentTheme.colors.stroke.control.default),
            content = {},
            outsideBorder = false
        )
        Layer(
            modifier = Modifier.size(32.dp),
            shape = RoundedCornerShape(4.dp),
            cornerRadius = 4.dp,
            color = FluentTheme.colors.fillAccent.default,
            border = BorderStroke(1.dp, FluentTheme.colors.stroke.control.default),
            content = {},
            outsideBorder = true
        )
    }

    var value by remember { mutableStateOf(TextFieldValue("Hello Fluent!")) }
    TextField(value, onValueChange = { value = it })
    TextField(
        value = value, onValueChange = { value = it }, enabled = false,
        header = { Text("With Header") }
    )

    // ProgressRings
    Row(
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProgressRing(size = ProgressRingSize.Medium)
        ProgressRing(progress = sliderValue)
        AccentButton(onClick = {}) {
            ProgressRing(size = ProgressRingSize.Small, color = LocalContentColor.current)
            Text("Small")
        }
    }

    ProgressBar(sliderValue)
    ProgressBar()

    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        for (imageVector in icons) {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = imageVector, contentDescription = null
            )
        }
    }
}

@Composable
private fun Controls() {
    var checked by remember { mutableStateOf(false) }
    Switcher(checked, text = null, onCheckStateChange = { checked = it })

    var checked2 by remember { mutableStateOf(true) }
    Switcher(checked2, text = "With Label", onCheckStateChange = { checked2 = it })

    var checked3 by remember { mutableStateOf(true) }
    Switcher(
        checked3,
        text = "Before Label",
        textBefore = true,
        onCheckStateChange = { checked3 = it }
    )

    var checked4 by remember { mutableStateOf(false) }
    CheckBox(checked4) { checked4 = it }

    var checked5 by remember { mutableStateOf(true) }
    CheckBox(checked5, label = "With Label") { checked5 = it }

    var selectedRadio by remember { mutableStateOf(0) }
    RadioButton(selectedRadio == 0, onClick = { selectedRadio = 0 })
    RadioButton(selectedRadio == 1, onClick = { selectedRadio = 1 }, label = "With Label")
}

@Composable
private fun Buttons() {
    var text by remember { mutableStateOf("Hello World") }
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        val onClick = { text = "Hello, Fluent Design!" }
        Button(onClick) { Text(text) }

        AccentButton(onClick) {
            Icon(Icons.Default.Checkmark, contentDescription = null)
            Text(text)
        }

        SubtleButton(onClick) {
            Text("Text Button")
        }
    }
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        AccentButton({}, iconOnly = true) {
            Icon(Icons.Default.Navigation, contentDescription = null)
        }
        Button({}, iconOnly = true) {
            Icon(Icons.Default.Navigation, contentDescription = null)
        }
        SubtleButton({}, iconOnly = true) {
            Icon(Icons.Default.Navigation, contentDescription = null)
        }
    }
}

private val icons = arrayOf(
    Icons.Default.Add,
    Icons.Default.Delete,
    Icons.Default.Dismiss,
    Icons.Default.ArrowLeft,
    Icons.Default.Navigation,
    Icons.Default.List
)