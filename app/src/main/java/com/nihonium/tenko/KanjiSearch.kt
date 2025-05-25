package com.nihonium.tenko

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nihonium.tenko.library.Kanji
import com.nihonium.tenko.utils.DatabaseHelper
import com.nihonium.tenko.utils.KnowledgeBase

class KanjiSearch : AppCompatActivity() {
    private lateinit var adapter: KanjiSquareViewAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kanji_search)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val KnowledgeBase = KnowledgeBase(applicationContext)
        var test: String = KnowledgeBase.dbHelper.debugstring
        val allKanji = KnowledgeBase.getKanjiData()
        allKanji.forEach{ kan->
            test= test + kan.kanji
        }

        recyclerView = findViewById(R.id.search_kan_result)

        setupRecyclerView(allKanji)
    }

    private fun setupRecyclerView(kanjiList: List<Kanji>){
        adapter = KanjiSquareViewAdapter(kanjiList) { kanji ->
            showKanjiDetails(kanji)
        }

        recyclerView.layoutManager = GridLayoutManager(this, 4)
        recyclerView.adapter = adapter
    }

    private fun showKanjiDetails(kanji: Kanji) {}
}