package ru.otus.otuskotlin.marketplace.common.kmp.test

class ValidationResult(
    val errors: List<IValidationError>
) {
    val isSuccess: Boolean
        get() = errors.isEmpty()

    companion object {
        val SUCCESS = ValidationResult(emptyList())
    }
}
