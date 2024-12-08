package com.example.wikipedia.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.wikipedia.R
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.ActivityMain2Binding
import com.example.wikipedia.fragments.SEND_DATA_TO_SECOUND_ACTIVITY

@Suppress("DEPRECATION")
class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarAsli)

        //this part code is for change the status bar color when it don't change in your project you can change with with this code
        window.statusBarColor = ContextCompat.getColor(this, R.color.blue)

        binding.collapsingMain.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )


        //its for change the fab icon color
        binding.fabDetailOpenWikipedia.setColorFilter(Color.WHITE)

        //here is for change the title of tool bar
        binding.toolbarAsli.setTitleTextColor(ContextCompat.getColor(this, R.color.white))

        //here is for back in before page with home icon
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        //open new activity for show to user at the times that item clicked don't empty
        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOUND_ACTIVITY)
        if (dataPost != null) {
            showData(dataPost)
        }


    }

    //this function is for home icon back
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    // get item from data class and show in new activity
    private fun showData(itemPost: ItemPost) {

        Glide
            .with(this)
            .load(itemPost.img_url)
            .into(binding.imgDetail)

        binding.txtDetailTitle.text = itemPost.txt_title
        binding.txtDetailSubtitle.text = itemPost.txt_subTitle
        binding.txtDetailText.text = itemPost.txt_detail


        binding.fabDetailOpenWikipedia.setOnClickListener {

            // open wikipedia
            val url = itemPost.fab_link
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }

    }

}