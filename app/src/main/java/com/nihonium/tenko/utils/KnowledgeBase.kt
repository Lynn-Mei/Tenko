package com.nihonium.tenko.utils

import android.content.Context
import android.database.Cursor
import com.nihonium.tenko.library.Kanji

class KnowledgeBase(private val context: Context) {
    val dbHelper: DatabaseHelper by lazy{DatabaseHelper(context)}

    fun getKanjiData():List<Kanji>{
        val characters: MutableList<Kanji> = mutableListOf()
        val cursor: Cursor? = dbHelper.readableDatabase.query(
            "Kanji",
            arrayOf("Kanji", "Meanings"),
            null,
            null,
            null,
            null,
            null
        )
        cursor?.use {
            while (it.moveToNext()){
                val character = it.getString(it.getColumnIndexOrThrow("Kanji"))
                val ji: Kanji = Kanji(character)
                characters.add(ji)
            }
        }
        return characters.toList()
    }
}