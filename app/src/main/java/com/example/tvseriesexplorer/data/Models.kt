package com.example.tvseriesexplorer.data

import com.google.gson.annotations.SerializedName

// --- LISTE ---
data class TvShowListResponse(
    val total: String,
    val page: Int,
    val pages: Int,
    @SerializedName("tv_shows") val tvShows: List<TvShowItem>
)

data class TvShowItem(
    val id: Int,
    val name: String,
    val permalink: String,
    @SerializedName("image_thumbnail_path") val imageThumbnailPath: String,
    val network: String?,
    val status: String?
)

// --- DÉTAILS ---
data class TvShowDetailResponse(
    @SerializedName("tvShow") val tvShow: TvShowDetail
)

data class TvShowDetail(
    val id: Int,
    val name: String,
    @SerializedName("image_path") val imagePath: String,
    val description: String,
    val rating: String, // C'est souvent un String ou un Double ("8.9")
    @SerializedName("episodes") val episodes: List<Episode>
)

data class Episode(
    val season: Int,
    val episode: Int,
    val name: String,
    @SerializedName("air_date") val airDate: String?
)
