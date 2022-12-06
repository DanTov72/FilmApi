package com.example.filmapi.ui.fragments.film

import com.example.filmapi.base.BaseViewModel
import com.example.filmapi.data.repositories.FilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(private val repository: FilmRepository) :
    BaseViewModel() {

    fun fetchFilms() = repository.fetchFilms()

}