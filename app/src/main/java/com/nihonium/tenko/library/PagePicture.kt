package com.nihonium.tenko.library

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.japanese.JapaneseTextRecognizerOptions
import java.io.File

class PagePicture {
    var picture: Bitmap? = null
    var text: String = ""

    fun importPicture(f: File){
        picture = BitmapFactory.decodeFile(f.absolutePath)
    }

    fun extractJapaneseTextFromImage(callback:(String) -> Unit) {
        val image = picture?.let { InputImage.fromBitmap(it, 0) }
        val recognizer = TextRecognition.getClient(JapaneseTextRecognizerOptions.Builder().build())

        image?.let {
            recognizer.process(it)
                .addOnSuccessListener { visionText ->
                    // 💬 Here's your Japanese text!
                    text = visionText.text
                    callback(text)
                }
                .addOnFailureListener { e ->
                    text = "Failed to recognize"
                }
        } ?: run{
            callback("No image")
        }
    }
}