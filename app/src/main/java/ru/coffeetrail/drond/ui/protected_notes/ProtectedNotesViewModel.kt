package ru.coffeetrail.grou.ui.protected_notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProtectedNotesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Protected Notes Fragment"
    }
    val text: LiveData<String> = _text
}