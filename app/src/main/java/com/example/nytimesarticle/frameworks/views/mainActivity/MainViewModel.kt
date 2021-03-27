package com.example.nytimesarticle.frameworks.views.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nytimesarticle.frameworks.utils.ToolbarType

class MainViewModel : ViewModel() {
    private val _toolbarType : MutableLiveData<ToolbarType> = MutableLiveData()
    val toolbarType : LiveData<ToolbarType> get() = _toolbarType

    private val _toolbarName : MutableLiveData<String> = MutableLiveData()
    val toolbarName : LiveData<String> get() = _toolbarName

    fun UpdateToolbarType(toolbarType: ToolbarType){
        _toolbarType.value = toolbarType
    }

    fun UpdateToolbarName(toolbarName: String){
        _toolbarName.value = toolbarName
    }
}