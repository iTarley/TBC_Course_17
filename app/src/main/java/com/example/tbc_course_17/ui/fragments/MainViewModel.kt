package com.example.tbc_course_17.ui.fragments

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tbc_course_17.models.InfoModel
import com.example.tbc_course_17.models.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _apiResponse = MutableSharedFlow<InfoModel>()
    val apiResponse:SharedFlow<InfoModel> get() = _apiResponse

    fun getLastInformation(){

        viewModelScope.launch {
            val response = RetrofitClient.getInformation().getInfo()
            if (response.isSuccessful){
                val body:InfoModel? = response.body()
                Log.d("response", "$body")
                _apiResponse.emit(body!!)
            }else{
                val error = response.errorBody()
                Log.d("errorResponse", "$error")
            }
        }

    }



}