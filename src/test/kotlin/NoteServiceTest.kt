import org.junit.Test
import org.junit.Assert.*

internal class NoteServiceTest {
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

    val newNote3 =  Note(noteId = 2, ownerId = userOne.userId, //Идентификатор владельца заметки
        title = "Заголовок 2", //Заголовок заметки
        text = "Написанный текст заметки", //Текст заметки
        date = 1111, // Дата создания заметки в формате Unixtime
        deletionId = true) //Идентификатор удаления заметки

    val userTwo = User((1..1000000).shuffled().last())

    @Test
    //Заметка добавлена
    fun add() {
        service.add(newNote1)
        assertFalse(service.noteStorage.isEmpty())
        service.noteStorage.removeAt(0)
    }

    @Test
    //Добавление нового комментарий
    fun createComment() {
        service.add(newNote1)
        service.createComment(newNote1, userOne)
        assertFalse(service.noteStorage[0].comment.isEmpty())
        service.noteStorage.removeAt(0)
    }

    @Test(expected = NoteNotFoundException::class)
    //Ошибка добавления теста
    fun not_CreateComment() {
        service.add(newNote1)
        service.createComment(newNote3, userOne)
    }

    //Возвращает список заметок, созданных пользователем.
    @Test
    fun get() {
        service.add(newNote1)
        assertFalse(service.get(userOne).isEmpty())
        service.noteStorage.removeAt(0)
    }

    //Возвращает пустой список заметок созданных пользователем
    @Test(expected = NoteNotFoundException::class)
    fun not_Get() {
        service.add(newNote1)
        service.get(userTwo)
    }

    //Удаление заметки пользователя
    @Test
    fun delete() {
        service.add(newNote1)
        service.delete(userOne)
        assertFalse(service.noteStorage[0].note.deletionId)
        service.noteStorage.removeAt(0)
    }

    //Удаление комментария к заметке
    @Test
    fun deleteComment() {
        service.add(newNote1)
        service.createComment(newNote1, userOne)
        service.deleteComment(newNote1.noteId, service.noteStorage[newNote1.noteId].comment[0].commentId)
        assertFalse(service.noteStorage[newNote1.noteId].comment[0].deletionId)
        service.noteStorage.removeAt(0)
    }

    //Не удалось удалить комментарий
    @Test(expected = NoteNotFoundException::class)
    fun not_deleteComment() {
        service.add(newNote1)
        service.createComment(newNote1, userOne)
        service.deleteComment(newNote1.noteId, userOne.userId)
    }

    //Редактирует заметку текущего пользователя
    @Test
    fun edit() {
        service.add(newNote1)
        service.edit(userOne)
        var notes = service.get(userOne)
        notes.forEachIndexed { index, note ->
            notes[index].note.title = "Изменили заголовок"
            assertEquals("Изменили заголовок", notes[index].note.title)
        }
        service.noteStorage.removeAt(0)
    }

    //Редактирует указанный комментарий у заметки.
    @Test
    fun editComment() {
        service.add(newNote1)
        service.createComment(newNote1, userOne)
        service.editComment(newNote1.noteId, service.noteStorage[newNote1.noteId].comment[0].commentId)
        assertEquals("Текст комментария отредактирован", service.noteStorage[newNote1.noteId].comment[0].text)
        service.noteStorage.removeAt(0)
    }

    //ТАкого комментария не существует
    @Test(expected = NoteNotFoundException::class)
    fun not_editComment() {
        service.add(newNote1)
        service.createComment(newNote1, userOne)
        service.editComment(newNote1.noteId, 9)
    }

    //Возвращает заметку по её id.
    @Test
    fun getById() {
        service.add(newNote1)
        val x = service.getById(newNote1.noteId)
        assertNotNull(x)
        service.noteStorage.removeAt(0)
    }

    //Такой заметки нет вернуть невозможно
    @Test(expected = NoteNotFoundException::class)
    fun not_getById() {
        service.add(newNote1)
        service.getById(99)
    }


    //Получаем список комментариев к заметке
    @Test
    fun getComments() {
        service.add(newNote1)
        val x = service.getComments(newNote1.noteId)
        assertNotNull(x)
        service.noteStorage.removeAt(0)
    }


    //Не получаем список комментариев к заметке
    @Test(expected = NoteNotFoundException::class)
    fun not_getComments() {
        service.add(newNote1)
        service.getComments(99)
    }

    //Восстановление удаленного комментария
    @Test
    fun restoreComment() {
        service.add(newNote1)
        service.createComment(newNote1, userOne)
        service.deleteComment(newNote1.noteId, service.noteStorage[newNote1.noteId].comment[0].commentId)
        service.restoreComment(newNote1.noteId, service.noteStorage[newNote1.noteId].comment[0].commentId)
        assertTrue(service.noteStorage[newNote1.noteId].comment[0].deletionId)
        service.noteStorage.removeAt(0)
    }

    //Восстановление комментария не удалось
    @Test(expected = NoteNotFoundException::class)
    fun not_restoreComment() {
        service.add(newNote1)
        service.createComment(newNote1, userOne)
        service.deleteComment(newNote1.noteId, 0)
        service.restoreComment(newNote1.noteId, 1)
    }
}