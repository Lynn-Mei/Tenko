package com.nihonium.tenko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nihonium.tenko.library.Book

class BookActivity : AppCompatActivity() {
    private var book: Book? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        this.book = intent.getSerializableExtra("Book") as? Book
        findViewById<TextView>(R.id.title).text = this.book!!.title
        findViewById<TextView>(R.id.author).text = this.book!!.author
        findViewById<ImageView>(R.id.bookCover).setImageResource(this.book!!.cover)

        val container = findViewById<RecyclerView>(R.id.pageslist)
        container.layoutManager = LinearLayoutManager(this)
        val adapter = PageAdapter(book!!.pages)
        container.adapter = adapter
    }
}