package ru.otus.otuskotlin.comments.models

data class CommentModel(
    var id: String = "",

    /**
     * Body of the comment
     */
    var comment: String = ""
) {
    val importantComment: String
        get() = "! - $comment"


    companion object {
        val NONE = CommentModel()
    }
}
