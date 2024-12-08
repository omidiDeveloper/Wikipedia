package com.example.wikipedia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wikipedia.databinding.FragmentLikesBinding

class FragmentLikes : Fragment() {
    lateinit var binding: FragmentLikesBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentLikesBinding.inflate(inflater, container, false)

       // alphaAnimation
//        val anim = AlphaAnimation( 0f , 1f)
//        anim.duration = 3000
//        anim.repeatCount = 3
//        binding.icHeartLikes.startAnimation(anim)

        return binding.root

    }



}
