package com.blackpearl.android.onboadingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.blackpearl.android.onboadingapp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {
    private lateinit var nameView: TextView
    private lateinit var dayView: TextView
    private lateinit var progressHorizontalBarTextView: TextView
    private lateinit var progressBarCircular: ProgressBar
    private lateinit var progressBarHorizontal: ProgressBar
    private val daysAmount = 7
    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        progressBarCircular = view.findViewById(R.id.progressBarCircular)
        progressBarHorizontal = view.findViewById(R.id.progressBarHorizontal)

        dayView = view.findViewById(R.id.txtProgress)
        nameView = view.findViewById(R.id.textView)
        progressHorizontalBarTextView = view.findViewById(R.id.progress_horizontal_text)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUI()
    }

    private fun updateName() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainActivityViewModel.uiState.collect { state ->
                    nameView.text = state.name
                }
            }
        }
    }

    private fun updateDays() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainActivityViewModel.uiState.collect { state ->
                    if (state.day < daysAmount) {
                        dayView.text = "${state.day}/$daysAmount"
                    } else {
                        dayView.text = "${state.day} days"
                    }
                    progressBarCircular.progress = 100 / daysAmount * state.day
                }
            }
        }
    }

    private fun updateProgressHorizontalBar() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mainActivityViewModel.uiState.collect { state ->
                    progressHorizontalBarTextView.text = "${state.points}/${state.points / 100 * 100 + 100}"
                    progressBarHorizontal.progress = state.points % 100
                }
            }
        }
    }

    private fun updateUI() {
        updateDays()
        updateName()
        updateProgressHorizontalBar()
    }

}