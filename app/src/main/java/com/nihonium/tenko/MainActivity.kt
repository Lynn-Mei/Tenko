package com.nihonium.tenko

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.nihonium.tenko.databinding.ActivityMainBinding
import com.nihonium.tenko.library.Book

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val books = listOf(
            Book("ISBN978-4-10-125332-9", "西の魔女が死んだ", "梨木香歩"),
            Book("ISBN978-4-10-125332-9", "西の魔女が死んだ","梨木香歩"),
            Book("ISBN978-4-10-125332-9", "西の魔女が死んだ","梨木香歩")
        )
        fillBookshelf(books)

        binding.buttontest.setOnClickListener { view ->
            val intent = Intent(this, BookshelfActivity::class.java).apply{}
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun fillBookshelf(books: List<Book>){
        val container = findViewById<LinearLayout>(R.id.main_bookshelf)
        books.forEach{ book ->
            val bookItem = LayoutInflater.from(this)
                .inflate(R.layout.bookshelf_book_layout, container, false)
            bookItem.findViewById<ImageView>(R.id.bookCover).setImageResource(book.cover)
            bookItem.findViewById<TextView>(R.id.bookTitle).text = book.title

            bookItem.setOnClickListener{
                val intent = Intent(this, BookActivity::class.java).apply{
                    putExtra("Book", book)
                }
                startActivity(intent)
            }
            container.addView(bookItem)
        }

    }
}