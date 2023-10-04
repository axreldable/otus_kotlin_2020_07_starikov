package ru.otus.otuskotlin.vacancies.backend.models

interface IVcModel {
    val id: IVcIdModel
    val title: String?
    val description: String?
    val city: String?
    val experience: String?
    val skillIds: MutableSet<String>?
}
