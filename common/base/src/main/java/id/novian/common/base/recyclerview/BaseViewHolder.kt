package id.novian.common.base.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<R>(
    itemView: View
) : RecyclerView.ViewHolder(itemView), BindRecyclerViewHolder<R> {
    override fun onBind(data: R) {}
}