package ru.otus.otuskotlin.vacancies.mappers

import ru.otus.otuskotlin.marketplace.common.backend.models.VIdModel
import ru.otus.otuskotlin.marketplace.common.backend.models.VacancyModel
import ru.otus.otuskotlin.vacancies.backend.models.VExperience
import ru.otus.otuskotlin.vacancies.transport.kmp.models.VacancyDto
import kotlin.test.Test
import kotlin.test.assertEquals

class VacancyMapperTest {
    private val dto = VacancyDto(
        id = "1",
        title = "title",
        description = "description",
        city = "city",
        experience = "MORE_THAN_SIX",
        skillIds = setOf("1", "2", "3"),
    )

    private val model = VacancyModel(
        id = VIdModel("1"),
        title = "title",
        description = "description",
        city = "city",
        experience = VExperience.MORE_THAN_SIX,
        skillIds = mutableSetOf("1", "2", "3"),
    )

    @Test
    fun mapToInternal() {
        assertEquals(model, dto.toInternal())
    }

    @Test
    fun mapToDto() {
        assertEquals(dto, model.toDto())
    }
}
