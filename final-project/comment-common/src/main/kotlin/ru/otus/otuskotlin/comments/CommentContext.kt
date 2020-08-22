package ru.otus.otuskotlin.comments

import ru.otus.otuskotlin.comments.models.CommentModel

data class CommentContext(
        var queryUserId: String = "",
        var responseUser: CommentModel = CommentModel.NONE
)
