package ru.otus.otuskotlin.vacancies.common.kmp.validation

data class ValidationDefaultError(
    override val message: String,
) : IValidationError
