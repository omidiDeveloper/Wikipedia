package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.TrendItemBinding

class TrendAdapter(val data: List<ItemPost> , val itemEvent: itemEvent) :
    RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {
    lateinit var binding: TrendItemBinding

    inner class TrendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(itemPost: ItemPost) {

            binding.txtTrendTitle.text = itemPost.txt_title

            binding.txtTrendSubtitle.text = itemPost.txt_subTitle

            binding.txtTrendInsight.text = itemPost.insight

            binding.txtTrendNumber.text = (adapterPosition + 1).toString()

            Glide
                .with(binding.root)
                .load( itemPost.img_url )
                .transform(RoundedCorners(32))
                .into( binding.imgTrendProfile )


            itemView.setOnClickListener {
                itemEvent.onItemClicked(itemPost)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        binding = TrendItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return TrendViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {

        holder.bindViews(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }


}