package com.andersonk.androidcourse.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Question(
    var answer_count: Int? = null,
    var creation_date: Int? = null,
    var is_answered: Boolean? = null,
    var last_activity_date: Int? = null,
    var link: String? = null,
    var owner: Owner? = null,
    var question_id: Int? = null,
    var score: Int? = null,
    var tags: List<String>? = null,
    var title: String? = null,
    var view_count: Int? = null
)