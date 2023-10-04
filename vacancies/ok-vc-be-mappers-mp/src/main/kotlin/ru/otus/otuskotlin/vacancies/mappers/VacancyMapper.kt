package ru.otus.otuskotlin.vacancies.mappers

import ru.otus.otuskotlin.marketplace.common.backend.models.VIdModel
import ru.otus.otuskotlin.marketplace.common.backend.models.VacancyModel
import ru.otus.otuskotlin.vacancies.backend.models.VExperience
import ru.otus.otuskotlin.vacancies.transport.kmp.models.VacancyDto

fun VacancyDto.toInternal(): VacancyModel = VacancyModel(
    id = id?.let { VIdModel(it) } ?: VIdModel.NONE,
    title = title ?: "",
    description = description ?: "",
    city = city ?: "",
    experience = VExperience.entries.find { it.name == experience } ?: VExperience.NONE,
    skillIds = skillIds?.toMutableSet() ?: mutableSetOf(),
)

fun VacancyModel.toDto(): VacancyDto = VacancyDto(
    id = id.id.takeIf { it.isNotBlank() },
    title = title.takeIf { it.isNotBlank() },
    description = description.takeIf { it.isNotBlank() },
    city = city.takeIf { it.isNotBlank() },
    experience = experience.name,
    skillIds = skillIds,
)
