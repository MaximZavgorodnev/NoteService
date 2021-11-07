import java.util.*

class Note(
    val noteId: Int, //Идентификатор заметки
    val ownerId: Int, //Идентификатор владельца заметки
    val title: String, //Заголовок заметки
    val text: String, //Текст заметки
    val date: Int, // Дата создания заметки в формате Unixtime
    val deletionId: Boolean, //Идентификатор удаления заметки
) {
}