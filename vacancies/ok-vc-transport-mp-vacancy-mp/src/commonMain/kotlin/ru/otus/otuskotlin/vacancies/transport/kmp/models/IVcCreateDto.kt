package ru.otus.otuskotlin.vacancies.transport.kmp.models

interface IVcCreateDto {
    val title: String?
    val description: String?
    val city: String?
    val experience: String?
    val skillIds: Set<String>?
}
