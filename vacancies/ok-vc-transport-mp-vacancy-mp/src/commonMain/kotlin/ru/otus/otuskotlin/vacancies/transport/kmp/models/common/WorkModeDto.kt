package ru.otus.otuskotlin.vacancies.transport.kmp.models.common

import kotlinx.serialization.Serializable

@Serializable
enum class WorkModeDto {
    PROD,
    TEST,
}
