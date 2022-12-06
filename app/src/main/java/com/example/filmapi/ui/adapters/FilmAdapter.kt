package com.example.filmapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.filmapi.base.BaseDiffUtilItemCallback
import com.example.filmapi.databinding.ItemFilmsBinding
import com.example.filmapi.models.film.FilmModel
import com.example.filmapi.ui.OnItemClickListener

class FilmAdapter(private val onItemClickListener: OnItemClickListener) : ListAdapter<FilmModel, FilmAdapter.FilmsViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FilmsViewHolder(
        ItemFilmsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    inner class FilmsViewHolder(private val binding: ItemFilmsBinding) : ViewHolder(binding.root) {
        fun onBind(model: FilmModel) {
            binding.tvFilmName.text = model.title
            binding.ivFilm.load(model.image)

            itemView.setOnClickListener {
                onItemClickListener.onItemClick(model)
            }
        }
    }
}