package com.srb.clout.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srb.clout.data.CloutRepository
import com.srb.libimgur.models.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {

    private val repo : CloutRepository by lazy{ CloutRepository() }

    private val _feed = MutableLiveData<List<Image>>()
    val feed : LiveData<List<Image>> = _feed

    fun updateFeed(feedType : String) = viewModelScope.launch(Dispatchers.IO) {
        when(feedType){
            "hot" -> _feed.postValue(repo.getHotFeed())
            "top" -> _feed.postValue(repo.getTopFeed())
            else -> Log.e("uni","check the hot or top")
        }
        Log.i("uni",_feed.value.toString())
        Log.i("uni",feed.toString())

    }


}