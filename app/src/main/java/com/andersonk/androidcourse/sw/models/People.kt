package com.andersonk.androidcourse.sw.models


import com.fasterxml.jackson.annotation.JsonProperty

data class People(
    @JsonProperty("birth_year")
    val birthYear: String? = null,
    @JsonProperty("created")
    val created: String? = null,
    @JsonProperty("edited")
    val edited: String? = null,
    @JsonProperty("eye_color")
    val eyeColor: String? = null,
    @JsonProperty("films")
    val films: List<String?>? = null,
    @JsonProperty("gender")
    val gender: String? = null,
    @JsonProperty("hair_color")
    val hairColor: String? = null,
    @JsonProperty("height")
    val height: String? = null,
    @JsonProperty("homeworld")
    val homeworld: String? = null,
    @JsonProperty("mass")
    val mass: String? = null,
    @JsonProperty("name")
    val name: String? = null,
    @JsonProperty("skin_color")
    val skinColor: String? = null,
    @JsonProperty("species")
    val species: List<String?>? = null,
    @JsonProperty("starships")
    val starships: List<String?>? = null,
    @JsonProperty("url")
    val url: String? = null,
    @JsonProperty("vehicles")
    val vehicles: List<String?>? = null
)