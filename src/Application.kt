package tribuneApp

import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.locations.*
import io.ktor.sessions.*
import io.ktor.features.*
import io.ktor.auth.*
import io.ktor.gson.*
import tribuneApp.auth.MySession
import tribuneApp.routes.exceptions
import tribuneApp.routes.opinions

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalLocationsAPI
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Locations) {
    }

    install(Sessions) {
        cookie<MySession>("MY_SESSION") {
            cookie.extensions["SameSite"] = "lax"
        }
    }

    install(Authentication) {
    }

    install(ContentNegotiation) {
        gson {
        }
    }

    routing {
        opinions()

        install(StatusPages) {
            exceptions()
        }
    }
}



