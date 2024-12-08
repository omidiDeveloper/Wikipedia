package com.example.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ExploreItemBinding

class ExploreAdapter(private var data: List<ItemPost>, val itemEvent: itemEvent):RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
    lateinit var binding: ExploreItemBinding

    inner class ExploreViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){

        fun viewBindings(itemPost: ItemPost){

            binding.txtExploreTitle.text = itemPost.txt_title
            binding.txtExploreSubtitle.text = itemPost.txt_subTitle
            binding.txtExploreDetail.text = itemPost.txt_detail
            binding.txtTrendInsight.text = itemPost.insight

            Glide
                .with(itemView.context)
                .load(itemPost.img_url)
                .into(binding.imgExploreMain)


            itemView.setOnClickListener {
                itemEvent.onItemClicked(itemPost)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ExploreItemBinding.inflate(LayoutInflater.from(parent.context), parent , false)

        return ExploreViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.viewBindings(data[position])
    }

}