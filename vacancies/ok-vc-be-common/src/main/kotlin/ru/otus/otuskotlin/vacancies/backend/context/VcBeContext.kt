package ru.otus.otuskotlin.marketplace.common.backend.context

import ru.otus.otuskotlin.marketplace.common.backend.models.VIdModel
import ru.otus.otuskotlin.marketplace.common.backend.models.VacancyModel

data class VcBeContext(
    var requestVacancyId: VIdModel = VIdModel.NONE,
    var requestVacancy: VacancyModel = VacancyModel.NONE,

    var responseVacancy: VacancyModel = VacancyModel.NONE,
)
