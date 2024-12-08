package com.example.wikipedia.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemPost(
    val img_url: String?,
    val txt_title: String?,
    val txt_subTitle: String?,
    val txt_detail: String?,

    //for trend

    val trendable: Boolean,
    val insight: String?,

    //for fab icon clicked

    val fab_link : String?

):Parcelable