package com.movefast.viewer

import android.view.ViewGroup
import com.movefast.core.adapter.BaseAdapter
import com.movefast.core.adapter.BaseBindingViewHolder
import com.movefast.viewer.databinding.RowImageViewerBinding

/**
 * Project: MoveFast
 * Created: Oct 29, 2019
 *
 * @author Mohamed Hamdan
 */
class ViewerAdapter(private val urls: Array<String?>?) : BaseAdapter<ViewerAdapter.ViewHolder>() {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowImageViewerBinding.inflate(inflater!!, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = urls?.size ?: 0

    inner class ViewHolder(binding: RowImageViewerBinding) : BaseBindingViewHolder(binding) {

        override fun bind(position: Int) {
            bind<RowImageViewerBinding> { url = urls?.get(position) }
        }
    }
}
