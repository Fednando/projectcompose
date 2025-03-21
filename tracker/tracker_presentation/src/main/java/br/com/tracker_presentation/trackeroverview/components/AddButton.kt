package br.com.tracker_presentation.trackeroverview.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.core.LocalSpacing


@Composable
fun AddButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    color: Color = MaterialTheme.colorScheme.primary
){
    val spacing = LocalSpacing.current


    Row(
        modifier = modifier
            .clip(RoundedCornerShape(100f))
            .clickable { onClick() }
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(100f)
            )
            .padding(spacing.spaceMedium),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            tint = if(isEnabled) color else Color.Gray
        )

        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = if(isEnabled) color else Color.Gray
        )
    }

}

@Composable
@Preview
fun AddButtonPreview(){
    AddButton(text = "Added", onClick = { /*TODO*/ })
}


















