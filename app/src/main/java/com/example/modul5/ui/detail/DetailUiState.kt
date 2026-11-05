package com.example.modul5.ui.detail

import com.example.modul5.data.model.Student

data class DetailUiState(
    val student: Student? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
//sealed interface DetailUiState {
//    object Loading : DetailUiState
//    data class Success(val student: Student) : DetailUiState
//    data class Error(val message: String) : DetailUiState
//}

