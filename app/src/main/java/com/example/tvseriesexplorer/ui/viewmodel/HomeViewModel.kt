package com.example.tvseriesexplorer.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tvseriesexplorer.data.TvSeriesRepository
import com.example.tvseriesexplorer.data.TvShowItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(val tvShows: List<TvShowItem>) : HomeUiState
    object Error : HomeUiState
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: TvSeriesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    init {
        getMostPopular()
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        if (query.isEmpty()) {
            getMostPopular()
        } else {
            searchTvShows(query)
        }
    }

    private fun getMostPopular() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            try {
                val response = repository.getMostPopular(1)
                _uiState.value = HomeUiState.Success(response.tvShows)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error
            }
        }
    }

    private fun searchTvShows(query: String) {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            try {
                val response = repository.searchTvShows(query, 1)
                _uiState.value = HomeUiState.Success(response.tvShows)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error
            }
        }
    }
}
