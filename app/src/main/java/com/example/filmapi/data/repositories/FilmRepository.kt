package com.example.filmapi.data.repositories

import com.example.filmapi.base.BaseRepository
import com.example.filmapi.data.remote.apiservices.FilmApiService
import javax.inject.Inject

class FilmRepository @Inject constructor(private val service: FilmApiService) : BaseRepository() {

    fun fetchFilms() = doRequest {
        service.fetchFilms()
    }
}