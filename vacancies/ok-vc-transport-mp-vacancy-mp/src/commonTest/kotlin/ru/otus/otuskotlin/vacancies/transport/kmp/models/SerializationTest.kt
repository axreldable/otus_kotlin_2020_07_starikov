package ru.otus.otuskotlin.vacancies.transport.kmp.models

import junit.framework.TestCase.assertEquals
import kotlinx.serialization.json.Json
import ru.otus.otuskotlin.vacancies.transport.kmp.models.common.WorkModeDto
import ru.otus.otuskotlin.vacancies.transport.kmp.models.search.VSearchFilterDto
import ru.otus.otuskotlin.vacancies.transport.kmp.models.search.VSearchRequest
import kotlin.test.Test
import kotlin.test.assertTrue

class SerializationTest {

    @Test
    fun serializeVSearchRequestTest() {
        val json = Json {
            prettyPrint = true
        }
        val dto = VSearchRequest(
            requestId = "search-id",
            onResponse = "response-id",
            startTime = "2021-02-13T12:00:00",
            debug = VSearchRequest.Debug(WorkModeDto.TEST),
            filterData = VSearchFilterDto(
                text = "Java dev"
            ),
        )

        val serializedString = json.encodeToString(VSearchRequest.serializer(), dto)
        assertTrue {
            serializedString == """
                {
                    "requestId": "search-id",
                    "onResponse": "response-id",
                    "startTime": "2021-02-13T12:00:00",
                    "debug": {
                        "mode": "TEST"
                    },
                    "filterData": {
                        "text": "Java dev"
                    }
                }
            """.trimIndent()

        }

        val deserializedDto = json.decodeFromString(VSearchRequest.serializer(), serializedString)
        assertEquals(dto, deserializedDto)
    }
}
