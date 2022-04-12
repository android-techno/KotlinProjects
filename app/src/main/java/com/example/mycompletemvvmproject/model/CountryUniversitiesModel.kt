package com.example.mycompletemvvmproject.model

data class CountryUniversitiesModel(
    var country: String? = null,
    var state_province: String? = null,
    var web_pages: List<String?>? = null,
    var alpha_two_code: String? = null,
    var name: String? = null,
    var domains: List<String?>? = null
)