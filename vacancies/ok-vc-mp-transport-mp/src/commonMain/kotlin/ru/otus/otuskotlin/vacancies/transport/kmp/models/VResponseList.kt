package ru.otus.otuskotlin.vacancies.transport.kmp.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.vacancies.transport.kmp.models.common.ErrorDto
import ru.otus.otuskotlin.vacancies.transport.kmp.models.common.ResponseStatusDto
import ru.otus.otuskotlin.vacancies.transport.kmp.models.common.WorkModeDto

@Serializable
@SerialName("VResponseList")
data class VResponseList(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    override val endTime: String? = null,
    override val errors: List<ErrorDto>? = null,
    override val status: ResponseStatusDto? = null,
    override val debug: Debug? = null,
    val vacancies: List<VacancyDto>? = null,
) : VMessage(), IVcResponse {

    @Serializable
    data class Debug(
        override val mode: WorkModeDto?
    ) : IVcDebug
}
