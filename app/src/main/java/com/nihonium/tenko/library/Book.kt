package com.nihonium.tenko.library

import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import com.nihonium.tenko.R

class Book {
    var isbn: String = ""
    var title: String = ""
    var cover: Int = 0
    private var pages: MutableList<Page> = mutableListOf()

    constructor(id: String, title:String){
        this.isbn = id
        this.title = title
        this.cover = R.drawable.nishinomajou
    }
}