package id.novian.feature.home.adapter.discover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import id.novian.common.base.Constants
import id.novian.common.base.recyclerview.BaseAdapter
import id.novian.common.base.recyclerview.BaseViewHolder
import id.novian.common.domain.model.Movie
import id.novian.feature.home.R
import id.novian.feature.home.adapter.MovieCallback
import id.novian.feature.home.databinding.ItemDiscoverBinding

class DiscoverAdapter(
    private val onClick: (Int) -> Unit
) : BaseAdapter<Movie>(MovieCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Movie> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_discover, parent, false)

        return DiscoverViewHolder(view)
    }

    inner class DiscoverViewHolder(
        itemView: View
    ) : BaseViewHolder<Movie>(itemView) {
        override fun onBind(data: Movie) {
            val binding: ItemDiscoverBinding = ItemDiscoverBinding.bind(itemView)

            val imgUrl = "${Constants.IMG_BASE_URL}${data.backdropPath}"

            Glide.with(itemView.context)
                .load(imgUrl)
                .into(binding.ivDiscover)

            binding.ivDiscover.setOnClickListener {
                onClick.invoke(data.id)
            }
        }
    }
}