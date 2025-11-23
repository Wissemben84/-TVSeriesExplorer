package com.example.tvseriesexplorer.data

import javax.inject.Inject

class TvSeriesRepository @Inject constructor(
    private val api: TvSeriesApi
) {
    suspend fun getMostPopular(page: Int) = api.getMostPopular(page)

    suspend fun searchTvShows(query: String, page: Int) = api.searchTvShows(query, page)

    suspend fun getTvShowDetails(tvShowId: String) = api.getTvShowDetails(tvShowId)
}
