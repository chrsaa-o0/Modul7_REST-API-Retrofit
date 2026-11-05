package com.example.modul5.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.modul5.data.model.Student
import com.example.modul5.data.repository.StudentRepository
data class HomeUiState(
    val students: List<Student> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
class HomeViewModel(
    private val repository: StudentRepository
) : ViewModel() {
    var uiState by mutableStateOf(HomeUiState())
        private set
    init {
        loadStudents()
    }
    fun loadStudents() {
        uiState = uiState.copy(isLoading = true, errorMessage = null)
        repository.getStudents { result ->
            uiState = result.fold(
                onSuccess = { data -> HomeUiState(students = data) },
                onFailure = { error -> HomeUiState(errorMessage = error.message ?: "Gagal mengambil data") }
            )
        }
    }
    fun searchStudents(query: String) {
        if (query.isBlank()) {
            loadStudents()
            return
        }
        uiState = uiState.copy(isLoading = true, errorMessage = null)
        repository.searchStudents(query) { result ->
            uiState = result.fold(
                onSuccess = { data -> HomeUiState(students = data) },
                onFailure = { error -> HomeUiState(errorMessage = error.message ?: "Pencarian gagal") }
            )
        }
    }
}