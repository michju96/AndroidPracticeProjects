package com.raywenderlich.testrecycleview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.CircleCropTransformation
import com.raywenderlich.testrecycleview.databinding.FragmentPopeDetailsBinding
import com.raywenderlich.testrecycleview.ui.main.PapiezModel


class FragmentPopeDetails() : Fragment() {

    private lateinit var binding: FragmentPopeDetailsBinding


    companion object {
        fun newInstance(papiez: PapiezModel) = FragmentPopeDetails().apply {
            val bundle = Bundle()

            bundle.putParcelable(PopeKey, papiez)
            arguments = bundle
        }

        const val TAG: String = "PopeDetails"
        const val PopeKey = "PopeKey"
    }

    private lateinit var viewModel: FragmentPopeDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopeDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val papiez: PapiezModel? = arguments?.getParcelable(PopeKey)
        papiez?.let {
            binding.detailsText.text = papiez.tekst
            binding.detailsImage.load(papiez.zdjecie){
                error(R.drawable.unknownpope).transformations(CircleCropTransformation())
            }
        }

    }
}



