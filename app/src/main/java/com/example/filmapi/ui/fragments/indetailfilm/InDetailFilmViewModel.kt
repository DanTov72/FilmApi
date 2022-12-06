package com.example.filmapi.ui.fragments.indetailfilm

import com.example.filmapi.base.BaseViewModel
import com.example.filmapi.data.repositories.InDetailFilmRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InDetailFilmViewModel @Inject constructor(private val repository: InDetailFilmRepository) :
    BaseViewModel() {

    fun fetchDetailFilm(id: String) = repository.fetchDetailFilm(id)
}