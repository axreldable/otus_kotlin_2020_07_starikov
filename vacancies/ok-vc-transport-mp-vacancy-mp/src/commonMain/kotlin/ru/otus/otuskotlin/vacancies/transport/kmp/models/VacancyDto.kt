package ru.otus.otuskotlin.vacancies.transport.kmp.models

import kotlinx.serialization.Serializable

@Serializable
data class VacancyDto(
    override val id: String? = null,
    override val title: String? = null,
    override val description: String? = null,
    override val city: String? = null,
    override val experience: String? = null,
    override val skillIds: Set<String>? = null,
    override val permissions: Set<VPermission>? = null,
) : IVcDto
