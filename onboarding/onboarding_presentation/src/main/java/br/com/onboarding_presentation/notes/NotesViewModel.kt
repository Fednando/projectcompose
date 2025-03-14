package br.com.onboarding_presentation.notes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor() : ViewModel() {

    private val notes = mutableListOf<String>()

    var note by mutableStateOf("")
        private set

    fun addNote(note: String) {
        this.note = note
    }

    fun onSaveNote() {
        notes.add(note)
    }
}