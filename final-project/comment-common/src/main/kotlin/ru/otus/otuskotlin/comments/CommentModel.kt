package ru.otus.otuskotlin.comments

data class CommentModel(
    var id: String = "",

    /**
     * Body of the comment
     */
    var comment: String = ""
) {
    val importantComment: String
        get() = "! - $comment"
}

