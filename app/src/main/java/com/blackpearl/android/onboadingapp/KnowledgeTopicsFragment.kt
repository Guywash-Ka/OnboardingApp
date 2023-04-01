package com.blackpearl.android.onboadingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.blackpearl.android.onboadingapp.databinding.FragmentKnowledgeBinding
import com.blackpearl.android.onboadingapp.databinding.FragmentKnowledgeTopicsBinding
import com.blackpearl.android.onboadingapp.knowledge.KnowledgeRepository
import com.blackpearl.android.onboadingapp.knowledge.TopicsAdapter

class KnowledgeTopicsFragment : Fragment() {

    private val args: KnowledgeTopicsFragmentArgs by navArgs()

    private var _binding: FragmentKnowledgeTopicsBinding? = null
    private val binding
        get() = checkNotNull(_binding) { "FragmentKnowledgeTopicsBinding is null" }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKnowledgeTopicsBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topics = KnowledgeRepository().getTopics(args.book)

        binding.recyclerView.adapter = TopicsAdapter(topics) { topic ->
            findNavController().navigate(
                KnowledgeTopicsFragmentDirections.showTheory(args.book, topic.id)
            )
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}