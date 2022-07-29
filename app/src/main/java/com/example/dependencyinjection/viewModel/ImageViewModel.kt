package com.example.dependencyinjection.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection.model.ImageItem
import com.example.dependencyinjection.repository.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(private val repository: ImageRepository): ViewModel() {

    private val _response = MutableLiveData<List<ImageItem>>()
    val imageResponse: LiveData<List<ImageItem>>
        get() = _response


    init {
        getAllImage()
    }

    private fun getAllImage() = viewModelScope.launch {

        repository.getAllImage().let { response ->
            if (response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d("your_tag", "getAllImage: Error: ${response.errorBody() }")
            }
        }
    }
}