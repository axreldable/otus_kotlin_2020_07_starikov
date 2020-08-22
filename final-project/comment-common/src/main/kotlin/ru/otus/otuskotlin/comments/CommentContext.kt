package ru.otus.otuskotlin.comments

import ru.otus.otuskotlin.comments.models.CommentModel

data class CommentContext(
        var queryUserId: String = "",
        var requestComment: CommentModel = CommentModel.NONE,
        var responseComment: CommentModel = CommentModel.NONE,
        var responseComments: List<CommentModel> = mutableListOf(),
        var status: CommentContextStatus = CommentContextStatus.NONE
)
