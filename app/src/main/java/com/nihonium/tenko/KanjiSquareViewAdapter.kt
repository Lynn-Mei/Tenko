package com.nihonium.tenko

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nihonium.tenko.library.Kanji

class KanjiSquareViewAdapter(
    private val kanjiList: List<Kanji>,
    private val onItemClick:(Kanji)->Unit) : RecyclerView.Adapter<KanjiSquareViewAdapter.KanjiViewHolder>(){

    class KanjiViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val kanjiChar: TextView = view.findViewById(R.id.square_view_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KanjiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.kanji_square_select_layout, parent, false)

        return KanjiViewHolder(view)
    }

    override fun onBindViewHolder(holder: KanjiViewHolder, position: Int) {
        val kanji = kanjiList[position]
        holder.kanjiChar.text = kanji.kanji
        holder.itemView.setOnClickListener { onItemClick(kanji) }
    }

    override fun getItemCount() = kanjiList.size
}