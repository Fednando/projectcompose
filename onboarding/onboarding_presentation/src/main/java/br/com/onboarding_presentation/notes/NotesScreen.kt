package br.com.onboarding_presentation.notes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.core.util.UiEvent

@Composable
fun NotesScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: NotesViewModel = hiltViewModel()
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Notes",
                color = MaterialTheme.colorScheme.primaryContainer,
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = viewModel.note,
                onValueChange = viewModel::addNote,
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(text = "Enter a note")
                },
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = "asdf",
                onValueChange = {

                },
                placeholder = {
                    Text(text = "Enter a note")
                },
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = viewModel::onSaveNote,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Save",
                    color = MaterialTheme.colorScheme.primaryContainer,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun NotesScreenPreview() {
    NotesScreen(onNavigate = {})
}