package com.example.wikipedia.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import cn.pedant.SweetAlert.SweetAlertDialog
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.wikipedia.R
import com.example.wikipedia.databinding.ActivityWriterBinding

@Suppress("DEPRECATION")
class writer_activity : AppCompatActivity() {
    lateinit var binding: ActivityWriterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityWriterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        //here is for back in before page with home icon
        setSupportActionBar(binding.toolbarAsliWriter)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.toolbarAsliWriter.setTitleTextColor(ContextCompat.getColor(this, R.color.white))

        binding.collapsingMainWriter.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )



        binding.chipGroupWriter.setOnCheckedChangeListener { chipGroup, checkedChipId ->
            when (checkedChipId) {
                R.id.chip_technologhy -> {

                    binding.txtTitleWriter.text = "Technology"

                    glide(R.drawable.img_tech, binding.imgWriterCenter)
                }

                R.id.chip_economy -> {

                    binding.txtTitleWriter.text = "Economy"

                    glide(R.drawable.img_economy, binding.imgWriterCenter)
                }

                R.id.chip_nature -> {

                    binding.txtTitleWriter.text = "Nature"

                    glide(R.drawable.img_nature, binding.imgWriterCenter)
                }

                R.id.chip_political -> {

                    binding.txtTitleWriter.text = "Political"

                    glide(R.drawable.img_political, binding.imgWriterCenter)
                }

                R.id.chip_scientific -> {

                    binding.txtTitleWriter.text = "Scientific"

                    glide(R.drawable.img_scientific, binding.imgWriterCenter)

                }
            }
        }

        binding.btnSaveWriter.setOnClickListener {
            //go to main activity


            //show alert to user

            val alert = SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
            alert.cancelText = "Edit"
            alert.confirmText = "Save"
            alert.titleText = "SuccessFull!"
            alert.contentText = "if you save , it will be save in your writeds!"
            alert.setCancelClickListener {
                alert.dismiss()
            }
            alert.setConfirmClickListener {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            alert.show()


        }

    }

    //this function is for home icon back
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    fun glide(Pic: Int, into: ImageView) {

        Glide
            .with(binding.root)
            .load(Pic)
            .transform(RoundedCorners(32))
            .into(into)
    }

}