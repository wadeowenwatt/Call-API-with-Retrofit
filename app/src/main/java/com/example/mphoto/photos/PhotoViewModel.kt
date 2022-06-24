package com.example.mphoto.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mphoto.network.MarsApi
import com.example.mphoto.network.MarsPhoto
import kotlinx.coroutines.launch
import java.lang.Exception

class PhotoViewModel : ViewModel() {

    private val _photos = MutableLiveData<List<MarsPhoto>>()
    val photos : LiveData<List<MarsPhoto>> = _photos

    init {
        getMarsPhoto()
    }

    private fun getMarsPhoto() {
        viewModelScope.launch {
            try{
                val listResult = MarsApi.retrofitService.getPhotos()
                _photos.value = listResult
            } catch (e:Exception) {

            }
        }
    }

}