package ru.search_university.utils

import ru.search_university.database.tokens.Tokens

object TokenCheck {

    fun isTokenValid(token: String): Boolean = Tokens.fetchTokens().firstOrNull { it.token == token } != null

    fun isTokenAdmin(token: String): Boolean = token == "dc376c66-53cd-4c41-a00a-1306c0d68b06"
}