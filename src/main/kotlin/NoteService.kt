

object NoteService {
    var noteStorage: MutableList<GenericNote> = mutableListOf()
    var idCom = 0

    //Добавление заметки
    fun add(newNote: Note) {
        val gNote = GenericNote(note = newNote,  comment = mutableListOf())
        noteStorage.add(newNote.noteId,gNote)
        println("Заметка добавлена")
    }

    //Добавляет новый комментарий к заметке
    fun createComment(newNote: Note,user: User) {
        val gNote = get(user) //Список всех заметок пользователя
        gNote.forEachIndexed { index, note ->
            if (newNote.noteId == gNote[index].note.noteId ) {
                val userComment = Comment(commentId = idCom, //Идентификатор комментария
                    noteId = gNote[index].note.noteId, //Идентификатор заметки
                    userId = user.userId, //Идентификатор пользователя написавший комментарий
                    ownerId = user.userId, //Идентификатор владельца заметки
                    text = "$idCom Текст комментария", //Текст комментария
                    date = 1000, // Дата создания заметки в формате Unixtime
                    deletionId = true, //Идентификатор удаления заметки
                )
                gNote[index].comment.add(userComment)
                idCom++
                println("Комментарий добавлен")
                return
            }
        }
        throw NoteNotFoundException("Такой заметки не существует")
    }

    //Возвращает список заметок, созданных пользователем.
    fun get(user: User): MutableList<GenericNote> {
        var notes: MutableList<GenericNote> = mutableListOf()
        noteStorage.forEachIndexed { index, note ->
            if (user.userId == noteStorage[index].note.ownerId) {
                notes.add(noteStorage[index])
            }
        }
        if (notes==null) {throw NoteNotFoundException("Пользователь не создавал заметок")} else {return notes}
    }

    //Удаляет заметку текущего пользователя
    fun delete(user: User) {
        noteStorage.forEachIndexed { index, note ->
            if (user.userId == noteStorage[index].note.ownerId) {
                noteStorage[index].note.deletionId = false
            }
        }
        println(get(user))
    }

    //Удаляет комментарий к заметке
    fun deleteComment(noteId: Int, idComment: Int){
        noteStorage[noteId].comment.forEachIndexed { index, note ->
            if (idComment == noteStorage[noteId].comment[index].commentId){
                noteStorage[noteId].comment[index].deletionId = false
                return
            }
        }
        throw NoteNotFoundException("Такого комментария нет или он был удален")
    }

    //Редактирует заметку текущего пользователя
    fun edit(user: User){
        var notes = get(user)
        notes.forEachIndexed { index, note ->
            notes[index].note.title = "Изменили заголовок"
        }

    }

    //Редактирует указанный комментарий у заметки.
    fun editComment(noteId: Int ,idComment: Int){
        noteStorage[noteId].comment.forEachIndexed { index, note ->
            if ((idComment == noteStorage[noteId].comment[index].commentId)&&(noteStorage[noteId].comment[index].deletionId != false)){
                noteStorage[noteId].comment[index].text = "Текст комментария отредактирован"
                return
            }
        }
        throw NoteNotFoundException("Такого комментария нет или он был удален")
    }



    //Возвращает заметку по её id.
    fun getById(noteId: Int): GenericNote {
        noteStorage.forEachIndexed { index, note ->
             if (noteId == noteStorage[index].note.noteId){
                return noteStorage[index]
            }
        }
        throw NoteNotFoundException("Такой заметки не существует")
    }

    //Возвращает список комментариев к заметке.
    fun getComments(noteId: Int): MutableList<Comment>{
        noteStorage.forEachIndexed { index, note ->
            if (noteId == noteStorage[index].note.noteId){
                return noteStorage[index].comment
            }
        }
        throw NoteNotFoundException("Такой заметки не существует")
    }

    //Восстанавливает удалённый комментарий.
    fun restoreComment(noteId: Int, idComment: Int){
        noteStorage[noteId].comment.forEachIndexed { index, note ->
            if (idComment == noteStorage[noteId].comment[index].commentId){
                noteStorage[noteId].comment[index].deletionId = true
                return
            }
        }
        throw NoteNotFoundException("Такого комментария никогда не было")
    }

}