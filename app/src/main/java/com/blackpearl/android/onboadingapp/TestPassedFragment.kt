package com.blackpearl.android.onboadingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.blackpearl.android.onboadingapp.databinding.FragmentTestPassedBinding

class TestPassedFragment: Fragment() {
    private var _binding: FragmentTestPassedBinding? = null
    private val binding
        get() = checkNotNull(_binding) { "Fragment test passed binding is null." }

    private val args: TestPassedFragmentArgs by navArgs()
    private val testPassedViewModel: TestPassedViewModel by viewModels() {
        TestPassedViewModelFactory(
            testId = args.testId,
            testResult = args.testResult,
            rightAnswers = args.rightAnswers,
            questionAmount = args.questionAmount
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTestPassedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arguments = testPassedViewModel.getArguments()
        val text = getString(R.string.test_result_message, arguments[0], arguments[1], arguments[2])
        binding.testResultTextView.text = text

        binding.retryTestButton.setOnClickListener { view: View ->
            findNavController().navigate(
                TestPassedFragmentDirections.actionTestPassedFragmentToQuizFragment(
                    testPassedViewModel.getTestId()
                )
            )
        }

        binding.exitButton.setOnClickListener { view: View ->
            findNavController().apply {
                popBackStack()
                popBackStack()
            }

        }
    }

}

