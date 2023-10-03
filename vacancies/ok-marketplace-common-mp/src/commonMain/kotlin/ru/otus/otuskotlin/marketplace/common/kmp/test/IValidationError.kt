package ru.otus.otuskotlin.marketplace.common.kmp.test

interface IValidationError {
    val message: String
}

interface IValidationFieldError : IValidationError {
    val field: String
}

data class ValidationDefaultError(
    override val message: String
) : IValidationError

data class ValidationFieldError(
    override val message: String,
    override val field: String
) : IValidationFieldError
