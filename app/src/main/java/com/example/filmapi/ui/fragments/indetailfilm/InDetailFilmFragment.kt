package com.example.filmapi.ui.fragments.indetailfilm

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.filmapi.R
import com.example.filmapi.base.BaseFragment
import com.example.filmapi.databinding.FragmentDetailFilmBinding
import com.example.filmapi.models.film.FilmModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InDetailFilmFragment : BaseFragment<FragmentDetailFilmBinding, InDetailFilmViewModel>(R.layout.fragment_detail_film) {
    override val binding by viewBinding(FragmentDetailFilmBinding::bind)
    override val viewModel: InDetailFilmViewModel by viewModels()
    private val saveArgs: InDetailFilmFragmentArgs by navArgs<InDetailFilmFragmentArgs>()

    override fun initialize() {
    }

    override fun setupSubscribe() {
        viewModel.fetchDetailFilm(saveArgs.id).subscribe(
            onSuccess = {
                addDateInView(it)
            },
            onError = {
                Log.e("film", it )
            }
        )
    }

    private fun addDateInView(model: FilmModel) {
        binding.ivDetailFilm.load(model.image)
        binding.tvDetailTitle.text = model.title
        binding.tvReleaseDate.text = model.releaseDate
        binding.tvDirection.text = model.description
        binding.tvProducer.text = model.producer
        binding.tvFilmDuration.text = model.runningTime
        binding.tvDirector.text = model.director
        binding.tvReleaseDate.text =model.releaseDate
    }
}