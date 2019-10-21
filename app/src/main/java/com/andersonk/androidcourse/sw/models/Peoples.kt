package com.andersonk.androidcourse.sw.models


import com.fasterxml.jackson.annotation.JsonProperty

data class Peoples(
    @JsonProperty("count")
    val count: Int? = null,
    @JsonProperty("next")
    val next: String? = null,
    @JsonProperty("previous")
    val previous: String? = null,
    @JsonProperty("results")
    val results: List<People?>? = null
)