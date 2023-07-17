package com.example.manager_incomeexpense

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.manager_incomeexpense.databinding.FragmentHomeFragmentBinding

class Home_fragment : Fragment() {

    lateinit var binding : FragmentHomeFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {

        binding = FragmentHomeFragmentBinding.inflate(layoutInflater)

        return binding.root
    }


}