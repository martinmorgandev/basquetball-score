package com.example.myapplication

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
     private var _localScore: MutableLiveData<Int> = MutableLiveData()
     private var _visitScore: MutableLiveData<Int> = MutableLiveData()

    val localScoreLiveData: LiveData<Int>
        get() = _localScore

    val visitScoreLiveData: LiveData<Int>
        get() = _visitScore

    init {
        reload()
    }

    fun reload(){
        _visitScore.value = 0
        _localScore.value = 0
    }

    fun localMinus() {
        if (_localScore.value!! > 0) {
            _localScore.value = _localScore.value!! - 1
        }
    }

    fun localPlus() {
        _localScore.value = _localScore.value!! + 1
    }

    fun localPlus2() {
        _localScore.value = _localScore.value?.plus(2)
    }


     fun visitMinus() {
        if (_visitScore.value!! > 0) {
            _visitScore.value = _visitScore.value!! - 1
       }
    }

     fun visitPlus() {
        _visitScore.value = _visitScore.value!! + 1
    }

     fun visitPlus2() {
        _visitScore.value = _visitScore.value?.plus(2)
    }

}