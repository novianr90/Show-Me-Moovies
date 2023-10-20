package id.novian.common.base.recyclerview

interface BindRecyclerViewHolder<T> {
    fun onBind(data: T)
}