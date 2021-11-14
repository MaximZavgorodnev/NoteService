data class GenericNote(
    val note: Note, var comment: MutableList<Comment>) { override fun toString(): String = "$note \n $comment"}
