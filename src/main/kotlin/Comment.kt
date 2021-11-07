import java.util.*

class Comment(
    val commentId: Int, //Идентификатор комментария
    val noteId: Int, //Идентификатор заметки
    val userId: Int, //Идентификатор пользователя написавший комментарий
    val ownerId: Int, //Идентификатор владельца заметки
    val text: String, //Текст комментария
    val date: Int, // Дата создания заметки в формате Unixtime
    val deletionId: Boolean, //Идентификатор удаления заметки
) {

}