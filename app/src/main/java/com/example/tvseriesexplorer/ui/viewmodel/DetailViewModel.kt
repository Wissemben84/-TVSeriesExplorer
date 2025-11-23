package com.example.tvseriesexplorer.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvseriesexplorer.data.TvSeriesRepository
import com.example.tvseriesexplorer.data.TvShowDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface DetailUiState {
    object Loading : DetailUiState
    data class Success(val tvShow: TvShowDetail) : DetailUiState
    object Error : DetailUiState
}

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: TvSeriesRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    private val tvShowId: String = checkNotNull(savedStateHandle["tvShowId"])

    init {
        getTvShowDetails()
    }

    private fun getTvShowDetails() {
        viewModelScope.launch {
            _uiState.value = DetailUiState.Loading
            try {
                val response = repository.getTvShowDetails(tvShowId)
                _uiState.value = DetailUiState.Success(response.tvShow)
            } catch (e: Exception) {
                _uiState.value = DetailUiState.Error
            }
        }
    }
}
