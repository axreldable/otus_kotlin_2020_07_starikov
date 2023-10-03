package ru.otus.otuskotlin.marketplace.common.kmp.test

class ValidatorStringNonEmpty {
    fun validate(sample: String?): ValidationResult = if (sample.isNullOrEmpty()) {
        ValidationResult(
            errors = listOf(
                ValidationDefaultError(
                    message = "String `${sample}` must not be empty or null!"
                )
            )
        )
    } else {
        ValidationResult.SUCCESS
    }
}

fun String.validate(validator: ValidatorStringNonEmpty) = validator.validate(this)
