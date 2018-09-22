package com.aranirahan.yogyawisata.presentation.ui.main.adapter

import android.content.Context
import com.aranirahan.yogyawisata.R
import com.aranirahan.yogyawisata.presentation.model.Wisata
import com.aranirahan.yogyawisata.presentation.base.adapter.BaseListAdapter
import com.aranirahan.yogyawisata.presentation.base.adapter.BaseViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adapter_wisata.view.*
import javax.inject.Inject

class WisataAdapter @Inject constructor() : BaseListAdapter<Wisata>() {

    override fun getListItemView(context: Context): BaseViewHolder<Wisata> = ViewHolder(context)

    inner class ViewHolder(context: Context?) : BaseViewHolder<Wisata>(context) {

        override fun layoutResId(): Int = R.layout.adapter_wisata

        override fun bind(item: Wisata, position: Int) {

            Glide.with(this).load(item.gambarPariwisata).into(ivWisata)
            tvCircle.text = item.namaPariwisata?.substring(0, 1)?.capitalize()
            tvTitle.text = item.namaPariwisata
            tvDesc.text = item.detailPariwisata
            tvAddress.text = item.alamatPariwisata

            cvWisata.setOnClickListener {
            }
        }
    }
}