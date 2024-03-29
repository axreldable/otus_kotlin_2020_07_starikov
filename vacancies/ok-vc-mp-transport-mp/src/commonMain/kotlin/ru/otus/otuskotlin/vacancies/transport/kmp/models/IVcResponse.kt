package ru.otus.otuskotlin.vacancies.transport.kmp.models

import ru.otus.otuskotlin.vacancies.transport.kmp.models.common.ErrorDto
import ru.otus.otuskotlin.vacancies.transport.kmp.models.common.ResponseStatusDto

interface IVcResponse {
    val responseId: String?
    val onRequest: String?
    val endTime: String?
    val errors: List<ErrorDto>?
    val status: ResponseStatusDto?
    val debug: IVcDebug?
}
