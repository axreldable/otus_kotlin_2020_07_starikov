package ru.otus.otuskotlin.vacancies.transport.kmp.models

interface IVcDto : IVcUpdateDto {
    val permissions: Set<VPermission>?
}
