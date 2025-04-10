package br.com.design_system.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

object CvpButtons {

    @Composable
    fun Primary(
        text: String,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        colors: ButtonColors = CvpButtonsColors.primary(),
        sizes: ButtonSizes = CvpButtonSizes.medium(),
        borders: ButtonBorders = CvpButtonBorders.none(),
        onClick: () -> Unit
    ) = CvpButtonImpl(
        text = text,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        sizes = sizes,
        borders = borders,
        onClick = onClick
    )

    enum class IconSide { LEFT, RIGHT }

    private val ButtonIconPadding = 8.dp

    @Composable
    internal fun CvpButtonImpl(
        text: String,
        enabled: Boolean,
        colors: ButtonColors,
        sizes: ButtonSizes,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        icon: Painter? = null,
        iconSide: IconSide? = null,
        borders: ButtonBorders = CvpButtonBorders.none(),
        elevation: ButtonElevation? = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )
    ) {
        val iconButton: @Composable ((Color) -> Unit) = {color->
            icon?.let {
                val spacerModifier = Modifier.width(ButtonIconPadding)
                if (iconSide == IconSide.RIGHT) Spacer(spacerModifier)
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(sizes.iconSize),
                    tint = color
                )
                if (iconSide == IconSide.LEFT) Spacer(spacerModifier)
            }
        }

        val interactionSource = remember { MutableInteractionSource() }
        val contentColor = if (enabled) {
            colors.contentColor
        } else {
            colors.disabledContentColor
        }

        Button(
            enabled = enabled,
            modifier = modifier
                .widthIn(min = sizes.minWidth)
                .height(sizes.height),
            colors = colors,
            border = if (enabled) borders.stroke else borders.disabled,
            contentPadding = sizes.contentPadding,
            elevation = elevation,
            interactionSource = interactionSource,
            onClick = onClick
        ) {
            if (iconSide == IconSide.LEFT) iconButton(contentColor)
            Text(
                modifier = Modifier.weight(1f, fill = false),
                text = text,
                style = sizes.textStyle,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            if (iconSide == IconSide.RIGHT) iconButton(contentColor)
        }
    }

}