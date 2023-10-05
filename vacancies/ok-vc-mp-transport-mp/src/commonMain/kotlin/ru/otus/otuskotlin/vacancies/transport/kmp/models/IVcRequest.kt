package ru.otus.otuskotlin.vacancies.transport.kmp.models

interface IVcRequest{
    val requestId: String?
    val onResponse: String?
    val startTime: String?
    val debug: IVcDebug?
}
