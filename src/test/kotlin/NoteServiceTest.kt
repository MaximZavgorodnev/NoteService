import org.junit.Test
import org.junit.Assert.*

internal class NoteServiceTest {
    var noteStorage: MutableList<GenericNote> = mutableListOf()
    var idCom = 0
    var lastID = 0
    val service = NoteService
    //Первый пользователь и его заметки
    val userOne = User((1..1000000).shuffled().last())

    val newNote1 =  Note(noteId = 0, ownerId = userOne.userId, //Идентификатор владельца заметки
        title = "Заголовок 0", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки

    val newNote2 =  Note(noteId = 1, ownerId = userOne.userId, //Идентификатор владельца заметки
        title = "Заголовок 1", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки

    val newNote3 =  Note(noteId = 2, ownerId = userOne.userId, //Идентификатор владельца заметки
        title = "Заголовок 2", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки

    val newNote4 =  Note(noteId = 3, ownerId = userOne.userId, //Идентификатор владельца заметки
        title = "Заголовок 3", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки


    val userTwo = User((1..1000000).shuffled().last())

    val newNote5 =  Note(noteId = 4, ownerId = userTwo.userId, //Идентификатор владельца заметки
        title = "Заголовок 4", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки

    val newNote6 =  Note(noteId = 5, ownerId = userTwo.userId, //Идентификатор владельца заметки
        title = "Заголовок 5", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки

    val newNote7 =  Note(noteId = 6, ownerId = userTwo.userId, //Идентификатор владельца заметки
        title = "Заголовок 6", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки

    val newNote8 =  Note(noteId = 7, ownerId = userTwo.userId, //Идентификатор владельца заметки
        title = "Заголовок 7", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки

    @Test
    fun getNoteStorage() {
    }

    @Test
    fun setNoteStorage() {
    }

    @Test
    fun getIdCom() {
    }

    @Test
    fun setIdCom() {
    }

    @Test
    fun add() {
    }

    @Test
    fun createComment() {
    }

    @Test
    fun get() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun deleteComment() {
    }

    @Test
    fun edit() {
    }

    @Test
    fun editComment() {
    }

    @Test
    fun getById() {
    }

    @Test
    fun getComments() {
    }

    @Test
    fun restoreComment() {
    }
}