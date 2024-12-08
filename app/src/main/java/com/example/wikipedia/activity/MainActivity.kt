package com.example.wikipedia.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.wikipedia.R
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragment.FragmentProfile
import com.example.wikipedia.fragments.FragmentExplore
import com.example.wikipedia.fragments.FragmentLikes
import com.example.wikipedia.fragments.FragmentPhotographer
import com.example.wikipedia.fragments.FragmentTrend
import com.example.wikipedia.fragments.translatorFragment
import com.google.android.material.snackbar.Snackbar

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceType", "CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        class MainActivity : AppCompatActivity() {
            @SuppressLint("MissingInflatedId")
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
                
            }
        }

        setSupportActionBar(binding.toolbarMain)


//        binding.collapsingMain.setContentScrimColor(
//            ContextCompat.getColor(this , R.color.blue)
//        )

        //here is for set the drawer option
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutMain,
            binding.toolbarMain,
            R.string.openDrawer,
            R.string.closeDrawer
        )


        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)

        //this code is for hamburger icon for drawer items
        actionBarDrawerToggle.syncState()

        //here is for navigation drawer show to user
        binding.navigationViewMain.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.writer_menu -> {

                    val intent = Intent(this, writer_activity::class.java)
                    startActivity(intent)

                    binding.drawerLayoutMain.closeDrawer(binding.navigationViewMain)
                }

                R.id.photographer_menu -> {

                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.fragment_container_view, FragmentPhotographer())
                    transaction.addToBackStack(null)
                    transaction.commit()

                    //item checkable is true

                    binding.navigationViewMain.menu.getItem(1).isChecked = true

                    binding.drawerLayoutMain.closeDrawer(binding.navigationViewMain)
                }

                R.id.video_menu -> {

                    //show a snakbar to user

                    Snackbar
                        .make(binding.root,"You clicked on video maker" , Snackbar.LENGTH_LONG)
                        .setAction("Ok"){
                            Toast.makeText(this, "You clicked ok of SnakBar ", Toast.LENGTH_SHORT).show()
                        }
                        .setActionTextColor(ContextCompat.getColor(this , R.color.white))
                        .setBackgroundTint(ContextCompat.getColor(this, R.color.blue))
                        .show()

                    binding.drawerLayoutMain.closeDrawer(binding.navigationViewMain)
                }

                R.id.translator_menu -> {

                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.fragment_container_view,translatorFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()


                    binding.drawerLayoutMain.closeDrawer(binding.navigationViewMain)
                }

                //---------------menu group

                R.id.wikipedia_menu -> {

                    val url = "https://en.wikipedia.org/wiki/Main_Page"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)

                    binding.drawerLayoutMain.closeDrawer(binding.navigationViewMain)
                }

                R.id.wikimedia_menu -> {

                    val url = "https://www.wikimedia.org/"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)


                    binding.drawerLayoutMain.closeDrawer(binding.navigationViewMain)
                }


            }



            true

        }

        //function for when user came for first time which fragment show it
        firstRun()

        //here is for clicked in fab icon writer

        binding.fabWrite.setOnClickListener {
            val intent = Intent(this, writer_activity::class.java)
            startActivity(intent)
        }

        //here is for times that user want to click in bottom navigation item

        binding.bottomNavigationMain.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.explore_menu -> {
                    replaceFragment(FragmentExplore())
                }

                R.id.trend_menu -> {
                    replaceFragment(FragmentTrend())
                }

                R.id.profile_menu -> {
                    replaceFragment(FragmentProfile())
                }

                R.id.likes_menu -> {
                    replaceFragment(FragmentLikes())
                }


            }
            binding.navigationViewMain.menu.getItem(1).isChecked = false
            true
        }

    }

    //this function is for set fragments in frame layout

    fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_view, fragment)
        transaction.commit()
    }

    //this function is for first time that app is runned

    fun firstRun() {
        replaceFragment(FragmentExplore())
        binding.bottomNavigationMain.selectedItemId = R.id.explore_menu
    }


    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()

        binding.navigationViewMain.menu.getItem(1).isChecked = false
    }


}