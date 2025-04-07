package com.nihonium.tenko

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.nihonium.tenko.library.Book

class BookshelfActivity : AppCompatActivity() {
    private var books: List<Book> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookshelf)

        this.books = listOf(
            Book("ISBN978-4-10-125332-9", "西の魔女が死んだ"),
            Book("ISBN978-4-10-125332-9", "西の魔女が死んだ"),
            Book("ISBN978-4-10-125332-9", "西の魔女が死んだ")
        )

        val container = findViewById<LinearLayout>(R.id.bookshelfLayout)
        books.chunked(2).forEach{ bookPair ->
            val row = LinearLayout(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                orientation = LinearLayout.HORIZONTAL
            }
            bookPair.forEach { book ->
                val bookItem = LayoutInflater.from(this)
                    .inflate(R.layout.bookshelf_book_layout, row, false)
                val uri = Uri.parse("https://m.media-amazon.com/images/I/510ln1bHRhL.jpg")
                bookItem.findViewById<ImageView>(R.id.bookCover).setImageURI(uri)
                bookItem.findViewById<TextView>(R.id.bookTitle).text = book.title

                bookItem.setOnClickListener{
                    val intent = Intent(this, BookActivity::class.java).apply{
                        putExtra("ISBN", book.isbn)
                    }
                    startActivity(intent)
                }
                row.addView(bookItem)
            }
            container.addView(row)
        }
    }
}