package ru.otus.otuskotlin.vacancies.transport.kmp.models.common

import kotlinx.serialization.Serializable

@Serializable
data class ErrorDto(
    val code: String? = null,
    val group: String? = null,
    val field: String? = null,
    val level: Level? = null,
    val message: String? = null,
) {
    @Serializable
    enum class Level {
        SUCCESS,
        INFO,
        WARNING,
        ERROR,
    }
}
