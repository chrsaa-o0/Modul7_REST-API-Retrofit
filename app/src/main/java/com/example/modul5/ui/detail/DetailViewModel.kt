package com.example.modul5.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.modul5.data.repository.StudentRepository

class DetailViewModel(
    private val repository: StudentRepository
) : ViewModel() {

    var uiState by mutableStateOf(DetailUiState())
        private set

    fun loadStudent(id: Int) {
        uiState = uiState.copy(isLoading = true, errorMessage = null)
        repository.getStudent(id) { result ->
            uiState = result.fold(
                onSuccess = { data -> DetailUiState(student = data) },
                onFailure = { error -> DetailUiState(errorMessage = error.message ?: "Data tidak tersedia") }
            )
        }
    }

    companion object {
        fun factory(repository: StudentRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return DetailViewModel(repository) as T
                }
            }
    }
}