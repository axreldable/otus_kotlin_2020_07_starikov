package ru.otus.otuskotlin.vacancies.transport.kmp.models.update

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.vacancies.transport.kmp.models.IVcDebug
import ru.otus.otuskotlin.vacancies.transport.kmp.models.IVcResponse
import ru.otus.otuskotlin.vacancies.transport.kmp.models.VMessage
import ru.otus.otuskotlin.vacancies.transport.kmp.models.VacancyDto
import ru.otus.otuskotlin.vacancies.transport.kmp.models.common.ErrorDto
import ru.otus.otuskotlin.vacancies.transport.kmp.models.common.ResponseStatusDto
import ru.otus.otuskotlin.vacancies.transport.kmp.models.common.WorkModeDto

@Serializable
@SerialName("VResponseUpdate")
data class VResponseUpdate(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    override val endTime: String? = null,
    override val debug: Debug? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    val vacancy: VacancyDto? = null,
) : VMessage(), IVcResponse {

    @Serializable
    data class Debug(
        override val mode: WorkModeDto?
    ) : IVcDebug
}
