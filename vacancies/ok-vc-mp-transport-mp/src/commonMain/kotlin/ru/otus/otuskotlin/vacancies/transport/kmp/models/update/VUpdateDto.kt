package ru.otus.otuskotlin.vacancies.transport.kmp.models.update

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.vacancies.transport.kmp.models.IVcUpdateDto

@Serializable
data class VUpdateDto(
    override val title: String? = null,
    override val description: String? = null,
    override val city: String? = null,
    override val experience: String? = null,
    override val skillIds: Set<String>? = null,
    override val id: String? = null,
) : IVcUpdateDto
