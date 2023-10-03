package ru.otus.otuskotlin.vacancies.common.kmp.validation

interface IValidationFieldError : IValidationError {
    val field: String
}
