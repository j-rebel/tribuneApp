package tribuneApp.model

data class Reaction (
    val userId: Long,
    val opinionId: Long,
    val reactionType: ReactionType
) {
    val uID: String = "$userId:$opinionId"
}

enum class ReactionType {
    LIKE, DISLIKE
}