package com.raywenderlich.testrecycleview.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.add
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.testrecycleview.FragmentPopeDetails
import com.raywenderlich.testrecycleview.FragmentPopeDetailsViewModel
import com.raywenderlich.testrecycleview.MainActivity
import com.raywenderlich.testrecycleview.R
import com.raywenderlich.testrecycleview.databinding.FragmentMainBinding
import com.raywenderlich.testrecycleview.databinding.KafelekBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var popeAdapter: PapiezAdapter

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: FragmentPopeDetailsViewModel
    val function :(PapiezModel) -> Unit = { papiez ->
        val transaction = parentFragmentManager.beginTransaction()
        transaction.addToBackStack(FragmentPopeDetails.TAG)
        val popeFragment = FragmentPopeDetails.newInstance(papiez)
        transaction.add(R.id.container, popeFragment).commit()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.apply {
            popeRecycler.layoutManager = LinearLayoutManager(requireContext())
            popeAdapter = PapiezAdapter(function)
            popeRecycler.adapter = popeAdapter
            addButton.setOnClickListener {
                addDialog()
            }
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[FragmentPopeDetailsViewModel::class.java]
    }


    private fun addDialog() {
        val builder = AlertDialog.Builder(binding.root.context)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.edit_text_layout, null)
        val popeNewName = dialogLayout.findViewById<EditText>(R.id.edit_name)
        val popeNewImageUrl = dialogLayout.findViewById<EditText>(R.id.edit_url)

        with(builder) {
            setTitle(R.string.create_new_pope)
            setPositiveButton("OK") { _, _ ->
                val newPope: PapiezModel = PapiezModel(
                    popeNewName.text.toString(),
                    popeNewImageUrl.text.toString()
                )
                popeAdapter.addItem(newPope)


            }
            setNegativeButton("Cancel") { _, _ ->
                Log.d("Main", "negative button clicked")
            }
            setView(dialogLayout)
            show()
        }
    }
}
