package ru.search_university.features.login

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import ru.search_university.database.tokens.TokenDTO
import ru.search_university.database.tokens.Tokens
import ru.search_university.database.users.Users
import java.util.*

class LoginController(private val call: ApplicationCall) {

    suspend fun performLogin() {
        val receive = call.receive(LoginReceiveRemote::class)

        Users.fetchUser(receive.login)?.let {
            if (it.password == receive.password) {
                val token = UUID.randomUUID().toString()
                Tokens.insert(
                    TokenDTO(
                        rowId = UUID.randomUUID().toString(),
                        login = receive.login,
                        token = token
                    )
                )
                call.respond(LoginResponseRemote(token = token))
            } else {
                call.respond(HttpStatusCode.BadRequest, "Invalid password")
            }
        } ?: call.respond(HttpStatusCode.BadRequest, "User not found")

    }
}