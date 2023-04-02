package com.blackpearl.android.onboadingapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.blackpearl.android.onboadingapp.databinding.ActivityMainBinding
import com.blackpearl.android.onboadingapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
        get() = checkNotNull(_binding) { "FragmentProfileBinding is null" }

    private val mainViewModel: MainViewModel by viewModels()

    private val daysAmount = 7
    private val points = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        updateUI()
        return binding.root
    }

    private fun updateName() {
        binding.apply {
            mainViewModel.getName.observe(viewLifecycleOwner){ nameValue ->
//                Log.d("NAME_TAG", name)
                setName(nameValue)
            }
        }
    }

    private fun updateDays() {
        binding.apply {
            mainViewModel.getDay.observe(viewLifecycleOwner) { dayValue ->
                setDay(dayValue)
            }
        }
    }

    private fun updateProgressHorizontalBar() {
        binding.apply {
            mainViewModel.getPoints.observe(viewLifecycleOwner) { points ->
                setProgressHorizontalBar(points)
            }
        }
    }

    private fun setName(text: String) {
        binding.textView.text = text
    }

    private fun setDay(day: Int) {
        binding.txtProgress.text = if (day <= daysAmount){
            "${day}/$daysAmount\ndays"
            } else {
                "$day\ndays"
        }
        binding.progressBarCircular.progress = 100 / daysAmount * day

    }

    private fun setProgressHorizontalBar(progress: Int) {
        binding.progressHorizontalText.text = "$progress/${progress / 100 * 100 + 100}"
        binding.progressBarHorizontal.progress = progress % 100
        binding.lvlText.text = "Lvl. ${progress/100}"

    }

    private fun updateUI() {
        updateName()
        updateDays()
        updateProgressHorizontalBar()
        updateProgressHorizontalBar()
    }

}