package com.srb.clout.view.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srb.clout.data.CloutRepository
import com.srb.libimgur.models.Gallery
import com.srb.libimgur.models.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoriesViewModel : ViewModel() {

    private val repo = CloutRepository()
    private val _tags = MutableLiveData<List<Tag>>()
    val tags : LiveData<List<Tag>> = _tags


    fun fetchTags() = viewModelScope.launch(Dispatchers.IO) {
        _tags.postValue(repo.getTags())
    }
}