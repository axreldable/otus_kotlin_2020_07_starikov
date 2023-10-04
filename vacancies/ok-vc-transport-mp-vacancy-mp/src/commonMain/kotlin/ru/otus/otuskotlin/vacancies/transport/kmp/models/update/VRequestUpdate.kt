package ru.otus.otuskotlin.vacancies.transport.kmp.models.update

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.vacancies.transport.kmp.models.IVcDebug
import ru.otus.otuskotlin.vacancies.transport.kmp.models.IVcRequest
import ru.otus.otuskotlin.vacancies.transport.kmp.models.VMessage
import ru.otus.otuskotlin.vacancies.transport.kmp.models.common.WorkModeDto

@Serializable
@SerialName("VRequestUpdate")
data class VRequestUpdate(
    override val requestId: String? = null,
    override val debug: Debug? = null,
    override val onResponse: String? = null,
    override val startTime: String? = null,
    val updateData: VUpdateDto? = null,
) : VMessage(), IVcRequest {

    @Serializable
    data class Debug(
        override val mode: WorkModeDto?
    ) : IVcDebug
}
