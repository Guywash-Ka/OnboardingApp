package com.blackpearl.android.onboadingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.blackpearl.android.onboadingapp.databinding.FragmentKnowledgeBinding
import com.blackpearl.android.onboadingapp.knowledge.KnowledgeRepository
import com.blackpearl.android.onboadingapp.knowledge.LibraryAdapter

class KnowledgeFragment : Fragment() {

    private var _binding: FragmentKnowledgeBinding? = null
    private val binding
        get() = checkNotNull(_binding) { "FragmentKnowledgeBinding is null" }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKnowledgeBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = KnowledgeRepository()
        val books = repository.getBooks()

        binding.recyclerView.adapter = LibraryAdapter(books) { book ->
            findNavController().navigate(
                KnowledgeFragmentDirections.showTopics(book.id)
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}