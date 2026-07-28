package dev.henrique.consultadepersonagens.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.henrique.consultadepersonagens.data.remote.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Loading)
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            _uiState.value = MainUiState.Loading
            try {
                val response = RetrofitClient.instance.getCharacters()
                _uiState.value = MainUiState.Success(response.results)
            } catch (e: Exception) {
                _uiState.value = MainUiState.Error("Erro ao carregar: ${e.localizedMessage}")
            }
        }
    }
}