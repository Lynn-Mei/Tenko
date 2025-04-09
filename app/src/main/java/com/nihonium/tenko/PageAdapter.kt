package com.nihonium.tenko

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nihonium.tenko.library.Page

class PageAdapter(private val pages: List<Page>) : RecyclerView.Adapter<PageAdapter.PageViewHolder>(){
    class PageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pageName: TextView = view.findViewById(R.id.pagename)
        val position: TextView = view.findViewById(R.id.position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.book_page_layout, parent, false)
        return PageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        val page:Page = pages[position]
        holder.pageName.text = page!!.name
        holder.position.text = page!!.number.toString()
    }

    override fun getItemCount() = pages.size
}