package ru.search_university.features.register

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.search_university.cache.InMemoryCache
import ru.search_university.cache.TokenCache
import ru.search_university.features.login.LoginReceiveRemote
import ru.search_university.features.login.LoginResponseRemote
import ru.search_university.utils.isValidEmail
import java.util.*

fun Application.configureRegisterRouting() {
    routing {
        post("/register") {
            val registerController = RegisterController(call)
            registerController.registerNewUser()
        }
    }
}