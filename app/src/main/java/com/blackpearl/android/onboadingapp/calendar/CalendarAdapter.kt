package com.blackpearl.android.onboadingapp.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackpearl.android.onboadingapp.databinding.EventListItemBinding

class CalendarAdapter(
    private val events: List<Event>,
    private val onItemClicked: ((Event) -> Unit)? = null
) : RecyclerView.Adapter<EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EventListItemBinding.inflate(inflater, parent, false)
        return EventViewHolder(binding)
    }

    override fun getItemCount() = events.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position], onItemClicked)
    }

}

class EventViewHolder(
    private val binding: EventListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(event: Event, onItemClicked: ((Event) -> Unit)?) {
        binding.title.text = event.name
        binding.date.text = event.date.toString()

        onItemClicked?.also { callback ->
            binding.root.setOnClickListener {
                callback(event)
            }
        }
    }
}