import java.util.*

data class Note(
    val noteId: Int, //Идентификатор заметки
    val ownerId: Int, //Идентификатор владельца заметки
    var title: String, //Заголовок заметки
    var text: String, //Текст заметки
    val date: Int, // Дата создания заметки в формате Unixtime
    var deletionId: Boolean, //Идентификатор удаления заметки
) {
    override fun toString(): String {
        if(deletionId) {
           return "\n Пользователь: $ownerId. написал заметку: $title. Текст заметки: $text"
        }
        return "Заметка удалена"
    }

}