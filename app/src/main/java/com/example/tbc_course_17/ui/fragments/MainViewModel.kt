package com.example.tbc_course_17.ui.fragments

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tbc_course_17.models.InfoModel
import com.example.tbc_course_17.models.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    fun getLastInformation(){

        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.getInformation().getInfo()
            if (response.isSuccessful){
                val body:InfoModel? = response.body()
                Log.d("response", "$body")
            }else{
                val error = response.errorBody()
                Log.d("errorResponse", "$error")
            }
        }
    }
}