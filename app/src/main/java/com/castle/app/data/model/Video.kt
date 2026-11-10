package com.castle.app.data.model

data class Video(
    val id: String,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val duration: Int, // in seconds
    val videoUrl: String = "",
    val releaseYear: Int = 2024,
    val rating: Float = 0f,
    val genre: String = ""
)