package model

import io.ktor.auth.Principal
import java.io.Serializable

data class User(
    val userId: Int,
    val displayName: String,
    val avatar: String?,
    val badge: BadgeType?,
    val email: String,
    val passwordHash: String,
    val readOnlyMode: Boolean = false
) : Serializable, Principal

enum class BadgeType {
    PROMOTER, HATER
}