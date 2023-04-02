package com.blackpearl.android.onboadingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.blackpearl.android.onboadingapp.databinding.FragmentKnowledgeBinding
import com.blackpearl.android.onboadingapp.databinding.FragmentKnowledgeTheoryBinding
import com.blackpearl.android.onboadingapp.knowledge.KnowledgeRepository

class KnowledgeTheoryFragment : Fragment() {
    private val args: KnowledgeTheoryFragmentArgs by navArgs()

    private var _binding: FragmentKnowledgeTheoryBinding? = null
    private val binding
        get() = checkNotNull(_binding) { "FragmentKnowledgeTheoryBinding is null" }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKnowledgeTheoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val theory = KnowledgeRepository().getTheory(args.book, args.topic)
        binding.text.text = theory
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}