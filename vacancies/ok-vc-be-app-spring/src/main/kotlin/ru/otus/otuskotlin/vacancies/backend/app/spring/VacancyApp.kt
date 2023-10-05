package ru.otus.otuskotlin.vacancies.backend.app.spring

import org.springframework.fu.kofu.webApplication
import org.springframework.fu.kofu.webmvc.webMvc
import ru.otus.otuskotlin.vacancies.backend.app.spring.controllers.VacancyController


val app = webApplication {
    beans {
        bean<VacancyController>()
    }
    webMvc {
        port = if (profiles.contains("test")) 8181 else 8080
        router {
            val vacancyService = ref<VacancyController>()
            POST("/vacancy/list", vacancyService::list)
            POST("/vacancy/search", vacancyService::search)
            POST("/vacancy/create", vacancyService::create)
            POST("/vacancy/read", vacancyService::read)
            POST("/vacancy/update", vacancyService::update)
            POST("/vacancy/delete", vacancyService::delete)
        }
        converters {
            string()
            kotlinSerialization()
        }
    }
}

fun main() {
    app.run()
}
