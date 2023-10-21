package id.novian.feature.home.adapter

import id.novian.common.base.recyclerview.BaseItemCallback
import id.novian.common.domain.model.Movie

class MovieCallback : BaseItemCallback<Movie>() {
    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }
}