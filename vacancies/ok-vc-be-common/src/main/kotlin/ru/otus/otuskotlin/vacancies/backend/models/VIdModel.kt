package ru.otus.otuskotlin.marketplace.common.backend.models

import ru.otus.otuskotlin.vacancies.backend.models.IVcIdModel

@JvmInline
value class VIdModel(
    override val id: String
): IVcIdModel {
    companion object {
        val NONE = VIdModel("")
    }
}
