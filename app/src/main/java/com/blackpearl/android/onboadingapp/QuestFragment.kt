package com.blackpearl.android.onboadingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.blackpearl.android.onboadingapp.databinding.FragmentQuestBinding

class QuestFragment : Fragment() {

    private var _binding: FragmentQuestBinding? = null
    private val binding
        get() = checkNotNull(_binding) { "FragmentGridBinding is null" }

    private lateinit var scenario: Scenario

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestBinding.inflate(inflater, container, false)

        val repo = ScenarioRepository(requireContext(), ::updateUI)

        scenario = repo.getScenario(1)

        updateUI(0)

        return binding.root
    }

    private fun updateUI(actIndex: Int) {

        if (scenario.size()-1 < actIndex) {
            // This is over
            return
        }

        val act = scenario.getAct(actIndex)

        binding.linearLayout.removeAllViews()

        act.getViews().forEach {
            binding.linearLayout.addView(it)
        }

    }
}