package com.blackpearl.android.onboadingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.blackpearl.android.onboadingapp.calendar.CalendarAdapter
import com.blackpearl.android.onboadingapp.calendar.CalendarRepository
import com.blackpearl.android.onboadingapp.databinding.FragmentCalendarBinding
import com.blackpearl.android.onboadingapp.databinding.FragmentQuestBinding

class CalendarFragment : Fragment() {

    private var _binding: FragmentCalendarBinding? = null
    private val binding
        get() = checkNotNull(_binding) { "FragmentCalendarBinding is null" }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = CalendarRepository()

        binding.recyclerView.adapter = CalendarAdapter(repository.getEvents()) {
            Toast.makeText(context, "Вы записаны на: ${it.name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}