package id.novian.feature.home.adapter.popular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.bumptech.glide.Glide
import id.novian.common.base.Constants
import id.novian.common.base.recyclerview.BaseViewHolder
import id.novian.common.domain.model.Movie
import id.novian.feature.home.R
import id.novian.feature.home.adapter.MovieCallback
import id.novian.feature.home.databinding.ItemPopularBinding

class PopularAdapter(
    private val onClick: (Int) -> Unit
) : PagingDataAdapter<Movie, PopularAdapter.PopularViewHolder>(MovieCallback()) {

    inner class PopularViewHolder(
        itemView: View
    ) : BaseViewHolder<Movie>(itemView) {
        private val binding = ItemPopularBinding.bind(itemView)

        override fun onBind(data: Movie) {
            with(binding) {

                tvTitleMovie.text = data.title
                // Will Edit
                tvReleaseDate.text = data.releaseDate

                val imgUrl = "${Constants.IMG_BASE_URL}${data.backdropPath}"

                Glide.with(itemView.context)
                    .load(imgUrl)
                    .into(ivPosterMovie)

                binding.container.setOnClickListener {
                    onClick.invoke(data.id)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular, parent, false)
        return PopularViewHolder(view)
    }
}