package com.example.swapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

interface MainActivityViewModelCallback {
    fun updateFilms(filmList : List<Film>)
}

class MainActivityViewModel : ViewModel(), MainActivityViewModelCallback {

    private val _filmsList : MutableLiveData<List<Film>> by lazy { MutableLiveData<List<Film>>() }
    val filmList : LiveData<List<Film>> get() = _filmsList

    fun loadFilms(){
        viewModelScope.launch {
            GetAllFilms.send(this@MainActivityViewModel)
        }
    }

    override fun updateFilms(filmList: List<Film>) {
        GlobalScope.launch(Dispatchers.Main) {
            _filmsList.value = filmList
        }
    }

}