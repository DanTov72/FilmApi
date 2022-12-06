package com.example.filmapi.data.repositories

import com.example.filmapi.base.BaseRepository
import com.example.filmapi.data.remote.apiservices.FilmApiService
import javax.inject.Inject

class InDetailFilmRepository @Inject constructor(private val service: FilmApiService): BaseRepository() {

    fun fetchDetailFilm(id: String) = doRequest {
        service.fetchDetailFilm(id  )
    }
}