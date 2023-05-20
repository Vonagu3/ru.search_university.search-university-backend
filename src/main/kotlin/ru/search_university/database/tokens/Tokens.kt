package ru.search_university.database.tokens

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import ru.search_university.database.users.Users
import kotlin.math.log

object Tokens: Table() {
    private val id = Tokens.varchar("id", 50)
    private val login = Tokens.varchar("login", 25)
    private val token = Tokens.varchar("token", 50)

    fun insert(tokenDTO: TokenDTO) {
        transaction {
            Tokens.insert {
                it[id] = tokenDTO.rowId
                it[login] = tokenDTO.login
                it[token] = tokenDTO.token
            }
        }
    }

    fun fetchTokens(): List<TokenDTO> {
        return try {
            transaction {
                Tokens.selectAll().toList()
                    .map {
                        TokenDTO(
                            rowId = it[Tokens.id],
                            token = it[token],
                            login = it[login]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}