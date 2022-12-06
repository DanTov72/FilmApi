package com.example.filmapi.ui

import com.example.filmapi.models.film.FilmModel

interface OnItemClickListener {

    fun onItemClick(model: FilmModel)
}