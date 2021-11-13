
object NoteService {
    private var lastID = 0
    var noteStorage: MutableList<GenericNote> = mutableListOf()
    var id = 0
    val mutableIterator = noteStorage.listIterator()

    //Добавление заметки
    fun add(newNote: Note) {
        val gNote = GenericNote(note = newNote,  comment = mutableListOf())
        noteStorage.add(newNote.noteId,gNote)
    }

    //Добавляет новый комментарий к заметке
    fun createComment(gNote: GenericNote, user: User) {
        val userComment = Comment(commentId = id, //Идентификатор комментария
        noteId = gNote.note.noteId, //Идентификатор заметки
        userId = user.userId, //Идентификатор пользователя написавший комментарий
        ownerId = user.userId, //Идентификатор владельца заметки
        text = "$id Текст комментария", //Текст комментария
        date = 1000, // Дата создания заметки в формате Unixtime
        deletionId = true, //Идентификатор удаления заметки
        )
        id++
        gNote.comment.add(userComment)

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
        TODO()
    }

    //Редактирует заметку текущего пользователя
    fun edit(){
        TODO()
    }

    //Редактирует указанный комментарий у заметки.
    fun editComment(){
        TODO()
    }

    //Возвращает список заметок, созданных пользователем.
    fun get(){
        TODO()

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
    fun getComments(){
        TODO()
    }

    //Восстанавливает удалённый комментарий.
    fun restoreComment(){
        TODO()
    }

}