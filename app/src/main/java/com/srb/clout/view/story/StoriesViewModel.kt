package com.srb.clout.view.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srb.clout.data.CloutRepository
import com.srb.libimgur.models.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoriesViewModel : ViewModel() {

    private val repo = CloutRepository()


    private val _images = MutableLiveData<List<Image>>()
    val images: LiveData<List<Image>> = _images

    fun fetchTagGallery(tagName: String) = viewModelScope.launch(Dispatchers.IO) {
        _images.postValue(repo.getTagGallery(tagName))
    }
}