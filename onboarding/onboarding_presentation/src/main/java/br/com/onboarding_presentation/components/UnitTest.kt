package br.com.onboarding_presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import br.com.core.LocalSpacing


@Composable
fun UnitTest(
    text: String,
    modifier: Modifier,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(
        color = MaterialTheme.colorScheme.primaryContainer,
        fontSize = 70.sp
    )
) {

    val spacing = LocalSpacing.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceMedium)
    ) {
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            textStyle = textStyle,
            singleLine = true,
            modifier = modifier
        )
    }

    Text(
        text = text,
        modifier = modifier,
    )
}