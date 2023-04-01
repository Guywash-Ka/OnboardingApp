package com.blackpearl.android.onboadingapp.knowledge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blackpearl.android.onboadingapp.databinding.BookListItemBinding

class LibraryAdapter(
    private val books: List<Book>,
    private val onItemClicked: ((Book) -> Unit)? = null
) : RecyclerView.Adapter<BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BookListItemBinding.inflate(inflater, parent, false)
        return BookViewHolder(binding)
    }

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position], onItemClicked)
    }

}

class BookViewHolder(
    private val binding: BookListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(book: Book, onItemClicked: ((Book) -> Unit)?) {
        binding.title.text = book.name

        onItemClicked?.also { callback ->
            binding.root.setOnClickListener {
                callback(book)
            }
        }
    }
}