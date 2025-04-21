package com.nihonium.tenko

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nihonium.tenko.library.Book
import java.io.File

class BookActivity : AppCompatActivity() {
    private var book: Book? = null
    private val CAMERA_PERMISSION_CODE = 100

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

        val addbtn = findViewById<Button>(R.id.addbtn)
        addbtn.setOnClickListener {
            requestCameraPermission()
        }
    }

    private fun takePicture() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val photoFile = File(getExternalFilesDir(null), "photo_${System.currentTimeMillis()}.jpg")
        val photoUri = FileProvider.getUriForFile(this, "${packageName}.fileprovider", photoFile)

        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
        startActivityForResult(intent, 1)
    }

    private fun requestCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA),
                CAMERA_PERMISSION_CODE
            )
        } else {
            takePicture()
        }
    }

    // This gets called after user responds to permission request
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            takePicture()
        } else {
            Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show()
        }
    }
}