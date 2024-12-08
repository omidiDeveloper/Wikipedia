package com.example.wikipedia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.wikipedia.R
import com.example.wikipedia.databinding.FragmentPhotographerBinding

@Suppress("UNREACHABLE_CODE")
class FragmentPhotographer:Fragment() {
    lateinit var binding: FragmentPhotographerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPhotographerBinding.inflate(layoutInflater, container , false)




        Glide
            .with(requireContext())
            .load(R.drawable.img_card)
            .transform(RoundedCorners(32))
            .into(binding.imgPhotographer)

        return binding.root
    }


}