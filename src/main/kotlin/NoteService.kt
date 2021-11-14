
object NoteService {
    var noteStorage: MutableList<GenericNote> = mutableListOf()
    var idCom = 0
    var mutableIterator = noteStorage.listIterator()

    //Добавление заметки
    fun add(newNote: Note) {
        val gNote = GenericNote(note = newNote,  comment = mutableListOf())
        noteStorage.add(newNote.noteId,gNote)
    }

    //Добавляет новый комментарий к заметке
    fun createComment(newNote: Note,user: User) {
        val gNote = get(user) //Список всех заметок пользователя
        val mutableIterator = gNote.listIterator()
        while (mutableIterator.hasNext()) {
            if (newNote.noteId == mutableIterator.next().note.noteId ) {
                val userComment = Comment(commentId = idCom, //Идентификатор комментария
                    noteId = mutableIterator.next().note.noteId, //Идентификатор заметки
                    userId = user.userId, //Идентификатор пользователя написавший комментарий
                    ownerId = user.userId, //Идентификатор владельца заметки
                    text = "$idCom Текст комментария", //Текст комментария
                    date = 1000, // Дата создания заметки в формате Unixtime
                    deletionId = true, //Идентификатор удаления заметки
                )
                mutableIterator.next().comment.add(userComment)
                idCom++
            }
            throw NoteNotFoundException("Такой заметки не существует")
        }

    }

    //Удаляет заметку текущего пользователя
    fun delete(user: User) {
        while (mutableIterator.hasNext()) {
            if (user.userId == mutableIterator.next().note.ownerId){
                mutableIterator.remove()
            }
        }
    }

    //Удаляет комментарий к заметке
    fun deleteComment(gNote: GenericNote, idComment: Int){
        val mutableIterator = gNote.comment.listIterator()
        while (mutableIterator.hasNext()) {
            if (idComment == mutableIterator.next().commentId){
                mutableIterator.next().deletionId = false
            }
        }
        throw NoteNotFoundException("Такого комментария нет или он был удален")
    }

    //Редактирует заметку текущего пользователя
    fun edit(user: User){
        var notes = get(user)
        val mutableIterator = notes.listIterator()
        while (mutableIterator.hasNext()) {
            mutableIterator.next().note.title = "Изменили заголовок"
        }
    }

    //Редактирует указанный комментарий у заметки.
    fun editComment(noteId: Int ,idComment: Int){
        val mutableIterator = noteStorage[noteId].comment.listIterator()
        while (mutableIterator.hasNext()) {
            if ((idComment == mutableIterator.next().commentId)&&(mutableIterator.next().deletionId != false)){
                mutableIterator.next().text = "Текст комментария отредактирован"
            }
        }
        throw NoteNotFoundException("Такого комментария нет или он был удален")
    }

    //Возвращает список заметок, созданных пользователем.
    fun get(user: User): MutableList<GenericNote> {
        var notes: MutableList<GenericNote> = mutableListOf()
        while (mutableIterator.hasNext()) {
            if (user.userId == mutableIterator.next().note.ownerId){
                notes.add(mutableIterator.next())
                return notes
            }
        }
        throw NoteNotFoundException("Пользователь не создавал заметок")
    }

    //Возвращает заметку по её id.
    fun getById(noteId: Int): GenericNote {
        while (mutableIterator.hasNext()) {
             if (noteId == mutableIterator.next().note.noteId){
                return mutableIterator.next()
            }
        }
        throw NoteNotFoundException("Такой заметки не существует")
    }

    //Возвращает список комментариев к заметке.
    fun getComments(noteId: Int): MutableList<Comment>{
        while (mutableIterator.hasNext()) {
            if (noteId == mutableIterator.next().note.noteId){
                return mutableIterator.next().comment
            }
        }
        throw NoteNotFoundException("Такой заметки не существует")
    }

    //Восстанавливает удалённый комментарий.
    fun restoreComment(gNote: GenericNote, idComment: Int){
        val mutableIterator = gNote.comment.listIterator()
        while (mutableIterator.hasNext()) {
            if (idComment == mutableIterator.next().commentId){
                mutableIterator.next().deletionId = true
            }
        }
        throw NoteNotFoundException("Такого комментария никогда не было")
    }

}