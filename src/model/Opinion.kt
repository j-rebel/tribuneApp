package tribuneApp.model

data class Opinion (
    val id: Long,
    val userId: Long,
    val date: Long,
    val text: String,
    val link: String?
)