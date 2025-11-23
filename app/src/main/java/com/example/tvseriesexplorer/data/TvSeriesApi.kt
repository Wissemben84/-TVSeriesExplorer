package com.example.tvseriesexplorer.data

import retrofit2.http.GET
import retrofit2.http.Query

interface TvSeriesApi {

    @GET("most-popular")
    suspend fun getMostPopular(
        @Query("page") page: Int
    ): TvShowListResponse

    @GET("search")
    suspend fun searchTvShows(
        @Query("q") query: String,
        @Query("page") page: Int = 1
    ): TvShowListResponse

    @GET("show-details")
    suspend fun getTvShowDetails(
        @Query("q") tvShowId: String // Episodate uses 'q' for ID as well in show-details
    ): TvShowDetailResponse
}
