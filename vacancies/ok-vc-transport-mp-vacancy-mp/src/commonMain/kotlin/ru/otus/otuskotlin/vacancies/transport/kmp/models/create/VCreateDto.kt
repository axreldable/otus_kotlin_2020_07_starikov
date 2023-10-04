package ru.otus.otuskotlin.vacancies.transport.kmp.models.create

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.vacancies.transport.kmp.models.IVcCreateDto

@Serializable
data class VCreateDto(
    override val title: String? = null,
    override val description: String? = null,
    override val city: String? = null,
    override val experience: String? = null,
    override val skillIds: Set<String>? = null,
) : IVcCreateDto
