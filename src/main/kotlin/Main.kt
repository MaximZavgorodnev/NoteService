import java.lang.RuntimeException

class NoteNotFoundException(message : String) : RuntimeException(message)

fun main(){
    var lastID = 0
    val service = NoteService
    //Первый пользователь и его заметки
    val userOne = User((1..1000000).shuffled().last())

    val newNote1 =  Note(noteId = lastID, ownerId = userOne.userId, //Идентификатор владельца заметки
        title = "Заголовок", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++
    val newNote2 =  Note(noteId = lastID, ownerId = userOne.userId, //Идентификатор владельца заметки
        title = "Заголовок", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++
    val newNote3 =  Note(noteId = lastID, ownerId = userOne.userId, //Идентификатор владельца заметки
        title = "Заголовок", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++
    val newNote4 =  Note(noteId = lastID, ownerId = userOne.userId, //Идентификатор владельца заметки
        title = "Заголовок", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++

    val userTwo = User((1..1000000).shuffled().last())

    val newNote5 =  Note(noteId = lastID, ownerId = userTwo.userId, //Идентификатор владельца заметки
        title = "Заголовок", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++
    val newNote6 =  Note(noteId = lastID, ownerId = userTwo.userId, //Идентификатор владельца заметки
        title = "Заголовок", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++
    val newNote7 =  Note(noteId = lastID, ownerId = userTwo.userId, //Идентификатор владельца заметки
        title = "Заголовок", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++
    val newNote8 =  Note(noteId = lastID, ownerId = userTwo.userId, //Идентификатор владельца заметки
        title = "Заголовок", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++

    //Добавление заметок
    service.add(newNote1)
    service.add(newNote2)
    service.add(newNote3)
    service.add(newNote4)
    service.add(newNote5)
    service.add(newNote6)
    service.add(newNote7)
    service.add(newNote8)

    service.createComment(newNote1, userOne)
    service.createComment(newNote3, userOne)
    service.createComment(newNote6, userTwo)
    service.createComment(newNote8, userTwo)

}