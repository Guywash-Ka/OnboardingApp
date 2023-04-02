package com.blackpearl.android.onboadingapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.blackpearl.android.onboadingapp.databinding.FragmentQuestBinding
import com.blackpearl.android.onboadingapp.quest.Scenario

class QuestFragment : Fragment() {

    private var _binding: FragmentQuestBinding? = null
    private val binding
        get() = checkNotNull(_binding) { "FragmentQuestBinding is null" }

    private val args: QuestFragmentArgs by navArgs()

    private val questViewModel: QuestViewModel by viewModels()

    // Scenario must be regenerated for any new context
    private lateinit var scenario: Scenario

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestBinding.inflate(inflater, container, false)

        scenario = ScenarioRepository(requireContext(), ::updateUI).getScenario(args.day)

        // updateUI is called every time user pressed next button in Act
        updateUI(questViewModel.getActIndex())

        return binding.root
    }

    private fun updateUI(actIndex: Int) {

        questViewModel.updateIndex(actIndex)

        if (scenario.size()-1 < actIndex) {
            // This is over
            findNavController().popBackStack()
            return
        }

        val act = scenario.getAct(actIndex)

        val layout = act.getMotionLayout()


        act.getTestId()?.also { testId ->
            layout.findViewById<Button>(R.id.quest_next_button).setOnClickListener {

                questViewModel.updateIndex(actIndex+1)
                findNavController().navigate(
                    QuestFragmentDirections.actionQuestFragmentToQuizFragment(testId)
                )

                setFragmentResultListener(QuizFragment.REQUEST_KEY_POINTS) { _, res ->
                    // And only when you acquired it - go next
                    val points = res.getInt(QuizFragment.BUNDLE_KEY_POINTS)
                    Log.i("QuestFragment", "$points")
                }

            }
        }

        binding.root.removeAllViews()

        binding.root.addView(layout)

    }
}