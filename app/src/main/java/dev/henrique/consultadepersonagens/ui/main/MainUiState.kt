package dev.henrique.consultadepersonagens.ui.main

import dev.henrique.consultadepersonagens.data.model.Character

sealed interface MainUiState {
    object Loading : MainUiState
    data class Success(val characters: List<Character>) : MainUiState
    data class Error(val message: String) : MainUiState
}