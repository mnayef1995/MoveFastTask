package com.movefast.gallery

import android.view.ViewGroup
import com.movefast.core.adapter.BaseAdapter
import com.movefast.core.adapter.BaseBindingViewHolder
import com.movefast.gallery.databinding.RowImageBinding

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
class GalleryAdapter(private val viewModel: GalleryViewModel) : BaseAdapter<GalleryAdapter.ViewHolder>() {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowImageBinding.inflate(inflater!!, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = viewModel.getPhotosCount()


    inner class ViewHolder(binding: RowImageBinding) : BaseBindingViewHolder(binding) {

        override fun bind(position: Int) {
            bind<RowImageBinding> { photo = viewModel.getPhotoBy(position) }
        }
    }
}
