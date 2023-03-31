package com.blackpearl.android.onboadingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.blackpearl.android.onboadingapp.databinding.FragmentQuestBinding
import com.blackpearl.android.onboadingapp.quest.Scenario

class QuestFragment : Fragment() {

    private var _binding: FragmentQuestBinding? = null
    private val binding
        get() = checkNotNull(_binding) { "FragmentQuestBinding is null" }

    private lateinit var scenario: Scenario

    private val args: QuestFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestBinding.inflate(inflater, container, false)

        val repo = ScenarioRepository(requireContext(), ::updateUI)

        scenario = repo.getScenario(args.day)

        updateUI(0)

        return binding.root
    }

    private fun updateUI(actIndex: Int) {

        if (scenario.size()-1 < actIndex) {
            // This is over
            findNavController().popBackStack()
            return
        }

        val act = scenario.getAct(actIndex)

        binding.root.removeAllViews()

        binding.root.addView(act.getMotionLayout())

    }
}