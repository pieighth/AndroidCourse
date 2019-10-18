package com.andersonk.androidcourse.models


data class QuestionList(
    val items: List<Question> = mutableListOf(),
    val has_more: Boolean? = null,
    val quota_max: Int? = null,
    val quota_remaining: Int? = null
)
