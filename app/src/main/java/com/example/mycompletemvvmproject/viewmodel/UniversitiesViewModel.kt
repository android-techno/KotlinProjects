package com.example.mycompletemvvmproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycompletemvvmproject.UniversityListActivity
import com.example.mycompletemvvmproject.model.CountryUniversitiesModel
import com.example.mycompletemvvmproject.retrofit.RetrofitInstance
import com.example.mycompletemvvmproject.retrofit.ServiceInterface
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UniversitiesViewModel :ViewModel() {
    private var countryUniversitiesListActivity: UniversityListActivity? = null
    var liveDataList: MutableLiveData<List<CountryUniversitiesModel>> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<List<CountryUniversitiesModel>> {
        countryUniversitiesListActivity = UniversityListActivity()
        return liveDataList
    }

    fun makeApiCall() {
        val serviceInterface: ServiceInterface =
            (RetrofitInstance.retrofitInstance?.create(ServiceInterface::class.java) ?: null)!!
        val call: Call<List<CountryUniversitiesModel>> = serviceInterface.getCountryUniversitiesList()

        call.enqueue(object : Callback<List<CountryUniversitiesModel>> {
            override fun onResponse(
                call: Call<List<CountryUniversitiesModel>>,
                response: Response<List<CountryUniversitiesModel>>
            ) {
                GlobalScope.launch {
                    if (response.isSuccessful) {
                        liveDataList.postValue(response.body())
                    }
                }
            }

            override fun onFailure(call: Call<List<CountryUniversitiesModel>>, t: Throwable) {
                liveDataList.postValue(null)
            }
        })

    }
}