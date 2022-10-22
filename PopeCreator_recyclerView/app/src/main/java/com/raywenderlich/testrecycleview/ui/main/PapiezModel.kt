package com.raywenderlich.testrecycleview.ui.main

import android.os.Parcelable
import androidx.annotation.RawRes
import com.raywenderlich.testrecycleview.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class PapiezModel(val tekst: String, val zdjecie:String, @RawRes val sound: Int = R.raw.co_mam_robic):Parcelable

