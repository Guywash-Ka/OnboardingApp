package com.blackpearl.android.onboadingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.blackpearl.android.onboadingapp.databinding.FragmentHomeBinding
import com.blackpearl.android.onboadingapp.databinding.FragmentQuestBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = checkNotNull(_binding) { "FragmentHomeBinding is null" }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            day1.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.startQuest(1)
                )
            }

            day2.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.startQuest(2)
                )
            }

        }
    }

}