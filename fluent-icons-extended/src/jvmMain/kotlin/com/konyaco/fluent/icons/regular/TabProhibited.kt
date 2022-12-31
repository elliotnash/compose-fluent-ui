

package com.konyaco.fluent.icons.regular

import androidx.compose.ui.graphics.vector.ImageVector
import com.konyaco.fluent.icons.Icons
import com.konyaco.fluent.icons.fluentIcon
import com.konyaco.fluent.icons.fluentPath

public val Icons.Regular.TabProhibited: ImageVector
    get() {
        if (_tabProhibited != null) {
            return _tabProhibited!!
        }
        _tabProhibited = fluentIcon(name = "Regular.TabProhibited") {
            fluentPath {
                moveTo(3.0f, 5.75f)
                arcTo(2.75f, 2.75f, 0.0f, false, true, 5.75f, 3.0f)
                horizontalLineToRelative(12.5f)
                arcTo(2.75f, 2.75f, 0.0f, false, true, 21.0f, 5.75f)
                verticalLineToRelative(6.27f)
                curveToRelative(-0.46f, -0.3f, -0.97f, -0.53f, -1.5f, -0.7f)
                lineTo(19.5f, 5.74f)
                curveToRelative(0.0f, -0.69f, -0.56f, -1.25f, -1.25f, -1.25f)
                lineTo(5.75f, 4.49f)
                curveToRelative(-0.69f, 0.0f, -1.25f, 0.56f, -1.25f, 1.25f)
                verticalLineToRelative(12.5f)
                curveToRelative(0.0f, 0.69f, 0.56f, 1.25f, 1.25f, 1.25f)
                horizontalLineToRelative(5.56f)
                curveToRelative(0.18f, 0.53f, 0.42f, 1.04f, 0.71f, 1.5f)
                lineTo(5.75f, 20.99f)
                arcTo(2.75f, 2.75f, 0.0f, false, true, 3.0f, 18.25f)
                lineTo(3.0f, 5.75f)
                close()
                moveTo(23.0f, 17.5f)
                arcToRelative(5.5f, 5.5f, 0.0f, true, true, -11.0f, 0.0f)
                arcToRelative(5.5f, 5.5f, 0.0f, false, true, 11.0f, 0.0f)
                close()
                moveTo(13.5f, 17.5f)
                curveToRelative(0.0f, 0.83f, 0.26f, 1.6f, 0.7f, 2.25f)
                lineToRelative(5.55f, -5.56f)
                arcToRelative(4.0f, 4.0f, 0.0f, false, false, -6.25f, 3.3f)
                close()
                moveTo(17.5f, 21.5f)
                arcToRelative(4.0f, 4.0f, 0.0f, false, false, 3.3f, -6.25f)
                lineToRelative(-5.55f, 5.56f)
                curveToRelative(0.64f, 0.44f, 1.42f, 0.69f, 2.25f, 0.69f)
                close()
            }
        }
        return _tabProhibited!!
    }

private var _tabProhibited: ImageVector? = null
