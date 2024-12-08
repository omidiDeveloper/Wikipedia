package com.example.wikipedia.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.wikipedia.R
import com.example.wikipedia.activity.MainActivity
import com.example.wikipedia.databinding.FragmentTranslatorBinding

@Suppress("UNREACHABLE_CODE")
class translatorFragment:Fragment() {
    lateinit var binding: FragmentTranslatorBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTranslatorBinding.inflate(layoutInflater, container , false)

        binding.btnTranslator.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

        Glide
            .with(requireContext())
            .load(R.drawable.img_translator)
            .transform(RoundedCorners(32))
            .into(binding.imgTranslator)

        return binding.root
    }


}