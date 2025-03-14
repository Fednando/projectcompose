package br.com.onboarding_presentation.layoutcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.core.util.UiEvent

@Composable
fun LayoutCompose(
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    var count by remember {
        mutableStateOf(0)
    }

    CountComponent(
        count = count,
        onIncreaseCount = { count++ },
        onDecreaseCount = { count-- }
    )
}

@Composable
fun CountComponent(
    count: Int,
    onIncreaseCount: () -> Unit,
    onDecreaseCount: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count.toString()
        )
        Button(onClick = onIncreaseCount) {
            Text(text = "Increase")
        }
        Button(onClick = onDecreaseCount) {
            Text(text = "Decrease")
        }
    }
}

