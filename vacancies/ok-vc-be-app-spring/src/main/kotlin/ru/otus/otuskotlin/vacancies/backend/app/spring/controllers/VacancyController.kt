package ru.otus.otuskotlin.vacancies.backend.app.spring.controllers

import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.ServerResponse.ok
import ru.otus.otuskotlin.vacancies.transport.kmp.models.VResponseList
import ru.otus.otuskotlin.vacancies.transport.kmp.models.VacancyDto
import ru.otus.otuskotlin.vacancies.transport.kmp.models.common.ErrorDto
import ru.otus.otuskotlin.vacancies.transport.kmp.models.common.ResponseStatusDto
import ru.otus.otuskotlin.vacancies.transport.kmp.models.create.VRequestCreate
import ru.otus.otuskotlin.vacancies.transport.kmp.models.create.VResponseCreate
import ru.otus.otuskotlin.vacancies.transport.kmp.models.delete.VRequestDelete
import ru.otus.otuskotlin.vacancies.transport.kmp.models.delete.VResponseDelete
import ru.otus.otuskotlin.vacancies.transport.kmp.models.read.VRequestRead
import ru.otus.otuskotlin.vacancies.transport.kmp.models.read.VResponseRead
import ru.otus.otuskotlin.vacancies.transport.kmp.models.search.VListRequest
import ru.otus.otuskotlin.vacancies.transport.kmp.models.search.VSearchRequest
import ru.otus.otuskotlin.vacancies.transport.kmp.models.update.VRequestUpdate
import ru.otus.otuskotlin.vacancies.transport.kmp.models.update.VResponseUpdate
import java.time.Instant

class VacancyController {
    fun list(request: ServerRequest): ServerResponse {
        val query = request.body(VListRequest::class.java)
        val response = VResponseList(
            vacancies = listOf(
                mockRead("d-001"),
                mockRead("d-002"),
                mockRead("d-003"),
                mockRead("d-004"),
                mockRead("d-005"),
                mockRead("d-006"),
            )
        )
        return ok().body(response)
    }

    fun search(request: ServerRequest): ServerResponse {
        val query = request.body(VSearchRequest::class.java)
        val response = VResponseList(
            vacancies = listOf(
                mockRead("d-001"),
                mockRead("d-002"),
                mockRead("d-003"),
            )
        )
        return ok().body(response)
    }

    fun create(request: ServerRequest): ServerResponse {
        val query = request.body(VRequestCreate::class.java)
        val response = VResponseCreate(
            responseId = "123",
            onRequest = query.requestId,
            endTime = Instant.now().toString(),
            status = ResponseStatusDto.SUCCESS,
            vacancy = mockUpdate(
                id = "d-123",
                title = query.createData?.title,
                description = query.createData?.description,
                city = query.createData?.city,
                experience = query.createData?.experience,
            )
        )
        return ok().body(response)
    }

    fun read(request: ServerRequest): ServerResponse {
        val query = request.body(VRequestRead::class.java)
        val response = VResponseRead(
            responseId = "123",
            onRequest = query.requestId,
            endTime = Instant.now().toString(),
            status = ResponseStatusDto.SUCCESS,
            vacancy = mockRead(query.vacancyId ?: "")
        )
        return ok().body(response)
    }

    fun update(request: ServerRequest): ServerResponse {
        val query = request.body(VRequestUpdate::class.java)
        val id = query.updateData?.id
        val response = if (id != null)
            VResponseUpdate(
                responseId = "123",
                onRequest = query.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                vacancy = mockUpdate(
                    id = id,
                    title = query.updateData?.title,
                    description = query.updateData?.description,
                    city = query.updateData?.city,
                    experience = query.updateData?.experience,
                )
            )
        else
            VResponseUpdate(
                responseId = "123",
                onRequest = query.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                errors = listOf(
                    ErrorDto(
                        code = "wrong-id",
                        group = "validation",
                        field = "id",
                        level = ErrorDto.Level.ERROR,
                        message = "id of the vacancy to be updated cannot be empty"
                    )
                )
            )
        return ok().body(response)
    }

    fun delete(request: ServerRequest): ServerResponse {
        val query = request.body(VRequestDelete::class.java)
        return ok().body(
            VResponseDelete(
                responseId = "123",
                onRequest = query.requestId,
                endTime = Instant.now().toString(),
                status = ResponseStatusDto.SUCCESS,
                vacancy = mockRead(query.id ?: ""),
                deleted = true
            )
        )
    }

    companion object {
        fun mockUpdate(
            id: String,
            title: String?,
            description: String?,
            city: String?,
            experience: String?,
        ) = VacancyDto(
            id = id,
            title = title,
            description = description,
            city = city,
            experience = experience,
            skillIds = setOf("s-001", "s-002"),
        )

        fun mockRead(id: String) = mockUpdate(
            id = id,
            title = "Vacancy $id",
            description = "Description of $id",
            city = "City $id",
            experience = "Experience of $id",
        )
    }
}
