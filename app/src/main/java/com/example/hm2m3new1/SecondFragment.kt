package com.example.hm2m3new1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gallery.R
import com.example.gallery.databinding.FragmentFirstBinding
import com.example.gallery.databinding.FragmentSecondBinding
import com.example.hm2m3new1.model.model_G

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var adapterGallery: Adapter
    private var selectedList = arrayListOf<model_G>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()

    }

    private fun initialize() {
        selectedList= arguments?.getSerializable("key") as ArrayList<model_G>
        adapterGallery = Adapter(selectedList)
        binding.rvMain.adapter = adapterGallery


    }
}