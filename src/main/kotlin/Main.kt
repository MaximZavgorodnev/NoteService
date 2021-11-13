import java.lang.RuntimeException

class NoteNotFoundException(message : String) : RuntimeException(message)

fun main(){
    val user = User((1..1000000).shuffled().last())

    val newNote =  Note(noteId = 0,
        ownerId = user.userId, //Идентификатор владельца заметки
        title = "Заголовок", //Заголовок заметки
        text = "Текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки

}