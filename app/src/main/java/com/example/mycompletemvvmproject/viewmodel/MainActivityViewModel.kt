package com.example.mycompletemvvmproject.viewmodel

import android.content.Context
import android.content.Intent
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycompletemvvmproject.UniversityListActivity

class MainActivityViewModel : ViewModel() {
    val title = MutableLiveData<String>()
    val clearText = MutableLiveData<String>()
    val incrementCount: MutableLiveData<String> = MutableLiveData()
    var count: Int = 0

    init {
        title.value = "Hi this new value"
        clearText.value = "Clear Text"
        incrementCount.value="count"
    }

    fun clearEditText() {
        title.value = ""
        incrementCount.value = ""
    }

    fun increment() {
        count++
        incrementCount.value = count.toString()
    }
}