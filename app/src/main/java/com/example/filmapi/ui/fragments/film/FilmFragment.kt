package com.example.filmapi.ui.fragments.film

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.filmapi.R
import com.example.filmapi.base.BaseFragment
import com.example.filmapi.databinding.FragmentFilmsBinding
import com.example.filmapi.models.film.FilmModel
import com.example.filmapi.ui.OnItemClickListener
import com.example.filmapi.ui.adapters.FilmAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmFragment : BaseFragment<FragmentFilmsBinding, FilmViewModel>(R.layout.fragment_films),
    OnItemClickListener {

    override val binding by viewBinding(FragmentFilmsBinding::bind)
    override val viewModel: FilmViewModel by viewModels()
    private val filmsAdapter = FilmAdapter(this)

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        viewModel.fetchFilms().subscribe(
            onSuccess = {
                filmsAdapter.submitList(it)
            },
            onError = {
                Log.e("film", it )
            }
        )
    }

    private fun setupRecyclerView() {
        binding.rvFilms.adapter = filmsAdapter
    }

    override fun onItemClick(model: FilmModel) {
        findNavController().navigate(
            FilmFragmentDirections.actionFilmsFragmentToDetailFilmFragment().setId(model.id)
        )
    }
}
