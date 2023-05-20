package ru.search_university.features.games

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.search_university.cache.InMemoryCache
import ru.search_university.cache.TokenCache
import java.util.*

fun Application.configureGamesRouting() {
    routing {
        post("/games/create") {
            GamesController(call).createGame()
        }

        post("/games/search") {
            GamesController(call).performSearch()
        }
    }
}