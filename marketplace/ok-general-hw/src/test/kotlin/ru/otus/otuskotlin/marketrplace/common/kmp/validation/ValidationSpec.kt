package ru.otus.otuskotlin.marketrplace.common.kmp.validation

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import ru.otus.otuskotlin.marketplace.common.kmp.test.ValidatorInRange
import ru.otus.otuskotlin.marketplace.common.kmp.test.ValidatorStringNonEmpty

class ValidationSpec : FunSpec({

    test("validate empty string") {
        val validator = ValidatorStringNonEmpty()
        val res = validator.validate("")
        res.isSuccess shouldBe false
        res.errors.first().message shouldContain "empty"
    }

    test("validate range") {
        val validator = ValidatorInRange("age", 2, 5)
        val res = validator.validate(8)
        res.isSuccess shouldBe false
        res.errors.first().message shouldContain "range"
    }

})
