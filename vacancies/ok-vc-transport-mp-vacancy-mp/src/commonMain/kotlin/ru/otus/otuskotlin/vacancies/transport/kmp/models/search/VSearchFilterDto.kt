package ru.otus.otuskotlin.vacancies.transport.kmp.models.search

import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.vacancies.transport.kmp.models.IVcSearchFilter

@Serializable
data class VSearchFilterDto(
    override val text: String? = null,
) : IVcSearchFilter
