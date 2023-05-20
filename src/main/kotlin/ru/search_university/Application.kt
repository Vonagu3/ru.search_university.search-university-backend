package ru.search_university

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import org.jetbrains.exposed.sql.Database
import ru.search_university.features.games.configureGamesRouting
import ru.search_university.features.login.configureLoginRouting
import ru.search_university.features.register.configureRegisterRouting
import ru.search_university.plugins.*

fun main() {

    Database.connect("jdbc:postgresql://localhost:5432/postgres", driver = "org.postgresql.Driver",
    user = "postgres", password = "Irtuganov21021991")

    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
    configureLoginRouting()
    configureRegisterRouting()
    configureGamesRouting()
    configureSerialization()
}
