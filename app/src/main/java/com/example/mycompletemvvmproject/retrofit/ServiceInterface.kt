package com.example.mycompletemvvmproject.retrofit

import com.example.mycompletemvvmproject.model.CountryUniversitiesModel
import retrofit2.Call
import retrofit2.http.GET

interface ServiceInterface {
@GET("search?country=India")
fun  getCountryUniversitiesList() : Call<List<CountryUniversitiesModel>>
}