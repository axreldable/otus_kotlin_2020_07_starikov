package ru.otus.otuskotlin.marketplace.common.backend.models

import ru.otus.otuskotlin.vacancies.backend.models.IVcModel
import ru.otus.otuskotlin.vacancies.backend.models.VExperience

data class VacancyModel(
    override val id: VIdModel = VIdModel.NONE,
    override val title: String = "",
    override val description: String = "",
    override val city: String = "",
    override val experience: VExperience = VExperience.NONE,
    override val skillIds: MutableSet<String> = mutableSetOf(),
) : IVcModel {
    companion object {
        val NONE = VacancyModel()
    }
}
