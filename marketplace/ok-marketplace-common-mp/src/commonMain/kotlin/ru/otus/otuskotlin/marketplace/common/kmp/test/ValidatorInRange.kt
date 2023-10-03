package ru.otus.otuskotlin.marketplace.common.kmp.test

class ValidatorInRange<T : Comparable<T>>(val field: String, val min: T, val max: T) {
    infix fun validate(sample: T): ValidationResult = if (sample in min..max) {
        ValidationResult.SUCCESS
    } else {
        ValidationResult(
            errors = listOf(
                ValidationFieldError(
                    field = field,
                    message = "The `$sample` is out of range [$min, $max]"
                )
            )
        )
    }
}
