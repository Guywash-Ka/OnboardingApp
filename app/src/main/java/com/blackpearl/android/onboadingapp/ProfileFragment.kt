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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.blackpearl.android.onboadingapp.databinding.ActivityMainBinding



class ProfileFragment : Fragment() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var name: String
    private lateinit var nameView: TextView
    private lateinit var dayView: TextView
    private lateinit var progressHorizontalBarTextView: TextView
    private lateinit var progressBarCircular: ProgressBar
    private lateinit var progressBarHorizontal: ProgressBar
    private val daysAmount = 7
    private val points = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // TEST CODE
        binding = ActivityMainBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val dayNumber = 2// будут передаваться из home
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val txtProgress: TextView = view.findViewById(R.id.txtProgress)
        nameView = view.findViewById(R.id.textView)
        progressBarCircular = view.findViewById(R.id.progressBarCircular)
        progressBarHorizontal = view.findViewById(R.id.progressBarHorizontal)

        dayView = view.findViewById(R.id.txtProgress)
        nameView = view.findViewById(R.id.textView)
        progressHorizontalBarTextView = view.findViewById(R.id.progress_horizontal_text)

        updateName()
        updateDays()
        updateProgressHorizontalBar()
        updateProgressHorizontalBar()

//        val daysAmount = 5 // если надо можно считать с DataStore, но пока отсутсвует в хранилище

//        progressBarCircular.progress = 100 / daysAmount * dayNumber
//        txtProgress.text = "$dayNumber/$daysAmount\nday"
//        progressBarHorizontal.progress = 50 // будет передаваться из home
//        name = "fuck"
//        getName()
//        nameView.text = name
        // END OF TEST CODE

        return view
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
        nameView.text = text
    }

    private fun setDay(day: Int) {
        dayView.text = day.toString()
        progressBarCircular.progress = 100 / daysAmount * day

    }

    private fun setProgressHorizontalBar(progress: Int) {
        progressHorizontalBarTextView.text = progress.toString()
        progressBarHorizontal.progress = progress % 100

    }

}