package com.blackpearl.android.onboadingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.blackpearl.android.onboadingapp.databinding.ActivityMainBinding



class ProfileFragment : Fragment() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

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
        val nameView: TextView = view.findViewById(R.id.textView)
        val progressBarCircular: ProgressBar = view.findViewById(R.id.progressBarCircular)
        val progressBarHorizontal: ProgressBar = view.findViewById(R.id.progressBarHorizontal)
        val daysAmount = 7 // если надо можно считать с DataStore, но пока отсутсвует в хранилище

        progressBarCircular.progress = 100 / daysAmount * dayNumber
        txtProgress.text = "$dayNumber/$daysAmount\nday"
        progressBarHorizontal.progress = 50 // будет передаваться из home
        // END OF TEST CODE

        return view
    }

}