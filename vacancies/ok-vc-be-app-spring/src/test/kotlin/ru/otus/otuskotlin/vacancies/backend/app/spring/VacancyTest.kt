package ru.otus.otuskotlin.vacancies.backend.app.spring

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import ru.otus.otuskotlin.vacancies.transport.kmp.models.VResponseList
import ru.otus.otuskotlin.vacancies.transport.kmp.models.create.VCreateDto
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
import ru.otus.otuskotlin.vacancies.transport.kmp.models.update.VUpdateDto
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class VacancyTest {
    private val client = WebTestClient.bindToServer().baseUrl("http://localhost:8181").build()

    private lateinit var context: ConfigurableApplicationContext

    @BeforeAll
    fun beforeAll() {
        context = app.run(profiles = "test")
    }

    @AfterAll
    fun afterAll() {
        context.close()
    }

    @Test
    fun `Vacancy List`() {
        val res = client
            .post()
            .uri("/vacancy/list")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(VListRequest())
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(VResponseList::class.java)
            .returnResult()
            .responseBody

        assertEquals(6, res?.vacancies?.size)
    }

    @Test
    fun `Vacancy Search`() {
        val res = client
            .post()
            .uri("/vacancy/search")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(VSearchRequest())
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(VResponseList::class.java)
            .returnResult()
            .responseBody

        assertEquals(3, res?.vacancies?.size)
    }

    @Test
    fun `Vacancy Create`() {
        val res = client
            .post()
            .uri("/vacancy/create")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(
                VRequestCreate(
                    createData = VCreateDto(
                        title = "Vacancy title",
                        description = "Vacancy description"
                    )
                )
            )
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(VResponseCreate::class.java)
            .returnResult()
            .responseBody

        assertEquals("d-123", res?.vacancy?.id)
        assertEquals("Vacancy title", res?.vacancy?.title)
        assertEquals("Vacancy description", res?.vacancy?.description)
    }

    @Test
    fun `Vacancy Read`() {
        val res = client
            .post()
            .uri("/vacancy/read")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(
                VRequestRead(
                    vacancyId = "d-6547",
                )
            )
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(VResponseRead::class.java)
            .returnResult()
            .responseBody

        assertEquals("d-6547", res?.vacancy?.id)
        assertEquals("Vacancy d-6547", res?.vacancy?.title)
        assertEquals("Description of d-6547", res?.vacancy?.description)
    }

    @Test
    fun `Vacancy Update`() {
        val res = client
            .post()
            .uri("/vacancy/update")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(
                VRequestUpdate(
                    updateData = VUpdateDto(
                        id = "d-6543",
                        title = "Some Vacancy",
                        description = "V Description"
                    )
                )
            )
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(VResponseUpdate::class.java)
            .returnResult()
            .responseBody

        assertEquals("d-6543", res?.vacancy?.id)
        assertEquals("Some Vacancy", res?.vacancy?.title)
        assertEquals("V Description", res?.vacancy?.description)
    }

    @Test
    fun `Vacancy Delete`() {
        val res = client
            .post()
            .uri("/vacancy/delete")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(
                VRequestDelete(
                    id = "d-6543",
                )
            )
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(VResponseDelete::class.java)
            .returnResult()
            .responseBody

        assertEquals("d-6543", res?.vacancy?.id)
        assertTrue(res?.deleted!!)
    }
}
