import java.lang.RuntimeException

class NoteNotFoundException(message : String) : RuntimeException(message)

fun main(){
    var lastID = 0
    val service = NoteService
    //Первый пользователь и его заметки
    val userOne = User((1..1000000).shuffled().last())

    val newNote1 =  Note(noteId = lastID, ownerId = userOne.userId, //Идентификатор владельца заметки
        title = "Заголовок $lastID", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++
    val newNote2 =  Note(noteId = lastID, ownerId = userOne.userId, //Идентификатор владельца заметки
        title = "Заголовок $lastID", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++
    val newNote3 =  Note(noteId = lastID, ownerId = userOne.userId, //Идентификатор владельца заметки
        title = "Заголовок $lastID", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++
    val newNote4 =  Note(noteId = lastID, ownerId = userOne.userId, //Идентификатор владельца заметки
        title = "Заголовок $lastID", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++

    val userTwo = User((1..1000000).shuffled().last())

    val newNote5 =  Note(noteId = lastID, ownerId = userTwo.userId, //Идентификатор владельца заметки
        title = "Заголовок $lastID", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++
    val newNote6 =  Note(noteId = lastID, ownerId = userTwo.userId, //Идентификатор владельца заметки
        title = "Заголовок $lastID", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++
    val newNote7 =  Note(noteId = lastID, ownerId = userTwo.userId, //Идентификатор владельца заметки
        title = "Заголовок $lastID", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки
    lastID++
    val newNote8 =  Note(noteId = lastID, ownerId = userTwo.userId, //Идентификатор владельца заметки
        title = "Заголовок $lastID", //Заголовок заметки
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

    //Добавили коменнтарии к заметкам
    service.createComment(newNote1, userOne)
    service.createComment(newNote1, userOne)
    service.createComment(newNote1, userOne)
    service.createComment(newNote6, userTwo)
    service.createComment(newNote6, userTwo)
    service.createComment(newNote8, userTwo)

    //Выводим список заметок с комментариями пользователя
    println(service.get(userOne))
    println()

    //Редактируем заметку
    service.edit(userTwo)
    println()
    //Редактируем комментарий указанной заметки
    service.editComment(newNote1.noteId ,1)
    println()

    //Возвращаем заметку по ее id
    println("Возвращаем заметку по ее id:")
    println(service.getById(6))
    println()

    //Возвращаем список комментариев к заметке
    println("Возвращаем список комментариев к заметке id:")
    println(service.getComments(7))
    println()

    //Удалить комментарий к заметке
    service.deleteComment(newNote1.noteId, 0)
    service.deleteComment(newNote6.noteId, 3)
    println()

    //Выводим список заметок с комментариями пользователя
    println(service.get(userOne))
    println()

    //Восстановление удаленного комментария
    service.restoreComment(newNote1.noteId, 0)
    println()

    //Выводим список заметок с комментариями пользователя
    println(service.get(userOne))
    println()

    //Удаление заметки
    service.delete(userTwo)
    println()

    //Выводим список заметок с комментариями пользователя
    println(service.get(userTwo))
    println()

}