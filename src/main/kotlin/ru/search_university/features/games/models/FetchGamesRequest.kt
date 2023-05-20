package ru.search_university.features.games

import kotlinx.serialization.Serializable

@Serializable
data class FetchGamesRequest(
    val searchQuery: String
)
