package com.example.android_pemula_traditional_dance.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TraditionalDance(
    val name : String?,
    val placeOfOrigin : String?,
    val description : String?,
    val image : Int?,
    val images : List<Int>?
) : Parcelable