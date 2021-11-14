import java.util.*

data class Comment(
    val commentId: Int, //Идентификатор комментария
    val noteId: Int, //Идентификатор заметки
    val userId: Int, //Идентификатор пользователя написавший комментарий
    val ownerId: Int, //Идентификатор владельца заметки
    var text: String, //Текст комментария
    val date: Int, // Дата создания заметки в формате Unixtime
    var deletionId: Boolean, //Идентификатор удаления заметки
) {
    override fun toString(): String {
        if (deletionId) {
            return "\n Пользователь: $userId. Написал комментарий к заметке: $commentId. Текст комментария: $text"
        }
        return "Комментарий удален"
    }
}