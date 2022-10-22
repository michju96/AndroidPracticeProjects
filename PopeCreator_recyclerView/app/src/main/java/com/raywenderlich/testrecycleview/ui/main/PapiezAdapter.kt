package com.raywenderlich.testrecycleview.ui.main

import android.app.Activity
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.os.Build.VERSION_CODES.P
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.raywenderlich.testrecycleview.MainActivity
import com.raywenderlich.testrecycleview.R
import com.raywenderlich.testrecycleview.databinding.ActivityMainBinding
import com.raywenderlich.testrecycleview.databinding.KafelekBinding
import kotlinx.coroutines.NonDisposableHandle.parent

class PapiezAdapter(val onClick: (PapiezModel) -> Unit) : RecyclerView.Adapter<PopeViewHolder>() {


    val popeList = mutableListOf(
        PapiezModel(
            "Pope1",
            "https://t2.genius.com/unsafe/327x327/https%3A%2F%2Fimages.genius.com%2Fc62725074ed6d8b738cfa4263d28e3fb.900x900x1.jpg",
            R.raw.co
        ),
        PapiezModel(
            "Pope2",
            "https://ocdn.eu/pulscms-transforms/1/UwXk9kuTURBXy8wNWIxM2Q5NS1kNWU1LTQ1MGUtYmNkYS1lMDYyNzc2ZjQ3YzMuanBlZ5GVAs0DBwDDw4GhMAE",
            R.raw.co_mam_robic
        ),
        PapiezModel(
            "Pope3",
            "https://cdn.galleries.smcloud.net/t/galleries/gf-9w7A-ryj1-69R9_milczenie-i-modlitwa-papiez-franciszek-pozdrowil-polakow-664x442-nocrop.png",
            R.raw.pijanie_bekasa
        ),
        PapiezModel(
            "Pope4",
            "https://s-trojmiasto.pl/zdj/c/n/9/1259/750x0/1259562-Blisko-dziewiec-lat-po-smierci-papiez-Jan-Pawel-II-w-niedziele-zostanie-swietym.jpg",
            R.raw.nooo
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopeViewHolder {
        val binding = KafelekBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PopeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopeViewHolder, position: Int) {
        holder.binding.textViewSample.text = popeList[position].tekst
        holder.binding.imageViewSample.load(popeList[position].zdjecie) {

            transformations(CircleCropTransformation())
            error(R.drawable.unknownpope).transformations(CircleCropTransformation())
        }
        holder.binding.deleteButton.setOnClickListener {
            removeItem(position)
        }
        holder.binding.imageViewSample.setOnClickListener {
            val spinAnimation =
                AnimationUtils.loadAnimation(holder.binding.root.context, R.anim.spin)
            it.startAnimation(spinAnimation)
            val mediaPlayer =
                MediaPlayer.create(holder.binding.root.context, popeList[position].sound)
            mediaPlayer.start()
        }
        holder.binding.root.setOnClickListener {
            onClick(popeList[position])
        }

    }

    override fun getItemCount(): Int {
        return popeList.size
    }

    fun addItem(newPope: PapiezModel) {
        popeList.add(newPope)
        notifyItemInserted(popeList.size)

    }

    private fun removeItem(position: Int) {
        popeList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, popeList.size)

    }


}