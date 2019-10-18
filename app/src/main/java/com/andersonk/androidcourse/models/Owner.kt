package com.andersonk.androidcourse.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
data class Owner(
    var display_name: String? = null,
    var link: String? = null,
    var profile_image: String? = null,
    var reputation: Int? = null,
    var user_id: Int? = null,
    var user_type: String? = null
)