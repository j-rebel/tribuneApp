package tribuneApp.routes

import io.ktor.application.call
import io.ktor.features.StatusPages
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()

fun StatusPages.Configuration.exceptions () {
    exception<AuthenticationException> { cause ->
        call.respond(HttpStatusCode.Unauthorized)
    }
    exception<AuthorizationException> { cause ->
        call.respond(HttpStatusCode.Forbidden)
    }
}