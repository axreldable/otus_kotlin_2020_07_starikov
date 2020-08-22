package ru.otus.otuskotlin.comments

import ru.otus.otuskotlin.comments.models.CommentModel
import kotlin.test.Test
import kotlin.test.assertEquals


internal class CommentModelTest {
    @Test
    fun createDefaultCommentTest() {
        val comment = CommentModel()

        assertEquals("", comment.id)
        assertEquals("", comment.comment)
        assertEquals("! - ", comment.importantComment)
    }

    @Test
    fun createCommentTest() {
        val comment = CommentModel("123", "comment body")

        assertEquals("123", comment.id)
        assertEquals("comment body", comment.comment)
        assertEquals("! - comment body", comment.importantComment)
    }
}
