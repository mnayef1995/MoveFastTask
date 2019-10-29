package com.movefast.core.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Project: MoveFast
 * Created: Oct 28, 2019
 *
 * @author Mohamed Hamdan
 */
abstract class BaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

    abstract fun bind(position: Int)
}
