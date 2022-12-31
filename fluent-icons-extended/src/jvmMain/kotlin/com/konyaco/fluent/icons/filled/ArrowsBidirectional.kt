

package com.konyaco.fluent.icons.filled

import androidx.compose.ui.graphics.vector.ImageVector
import com.konyaco.fluent.icons.Icons
import com.konyaco.fluent.icons.fluentIcon
import com.konyaco.fluent.icons.fluentPath

public val Icons.Filled.ArrowsBidirectional: ImageVector
    get() {
        if (_arrowsBidirectional != null) {
            return _arrowsBidirectional!!
        }
        _arrowsBidirectional = fluentIcon(name = "Filled.ArrowsBidirectional") {
            fluentPath {
                moveTo(15.0f, 9.0f)
                horizontalLineTo(9.0f)
                verticalLineTo(6.75f)
                curveToRelative(0.0f, -0.66f, -0.78f, -1.0f, -1.26f, -0.54f)
                lineToRelative(-5.5f, 5.25f)
                arcToRelative(0.75f, 0.75f, 0.0f, false, false, 0.0f, 1.08f)
                lineToRelative(5.5f, 5.25f)
                lineToRelative(0.08f, 0.07f)
                arcToRelative(0.75f, 0.75f, 0.0f, false, false, 1.19f, -0.61f)
                verticalLineTo(15.0f)
                horizontalLineToRelative(6.0f)
                verticalLineToRelative(2.25f)
                curveToRelative(0.0f, 0.66f, 0.78f, 1.0f, 1.26f, 0.54f)
                lineToRelative(5.5f, -5.25f)
                curveToRelative(0.3f, -0.3f, 0.3f, -0.79f, 0.0f, -1.08f)
                lineToRelative(-5.5f, -5.25f)
                arcToRelative(0.75f, 0.75f, 0.0f, false, false, -1.27f, 0.54f)
                verticalLineTo(9.0f)
                close()
            }
        }
        return _arrowsBidirectional!!
    }

private var _arrowsBidirectional: ImageVector? = null
