package tribuneApp.routes

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get

@KtorExperimentalLocationsAPI
@Location("/location/{name}")
class MyLocation(val name: String, val arg1: Int = 42, val arg2: String = "default")

@KtorExperimentalLocationsAPI
@Location("/type/{name}") data class Type(val name: String) {
    @Location("/edit")
    data class Edit(val type: Type)

    @Location("/list/{page}")
    data class List(val type: Type, val page: Int)
}

@KtorExperimentalLocationsAPI
fun Route.opinions () {
    get("/") {
        call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
    }

    get<MyLocation> {
        call.respondText("Location: name=${it.name}, arg1=${it.arg1}, arg2=${it.arg2}")
    }
    // Register nested routes
    get<Type.Edit> {
        call.respondText("Inside $it")
    }
    get<Type.List> {
        call.respondText("Inside $it")
    }

    get("/json/gson") {
        call.respond(mapOf("hello" to "world"))
    }
}