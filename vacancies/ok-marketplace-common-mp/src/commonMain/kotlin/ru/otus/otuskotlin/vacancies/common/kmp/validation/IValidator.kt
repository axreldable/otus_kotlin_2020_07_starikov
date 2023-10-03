package ru.otus.otuskotlin.vacancies.common.kmp.validation

interface IValidator<T> {
    infix fun validate(sample: T): ValidationResult
}
