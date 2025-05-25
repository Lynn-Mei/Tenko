package com.nihonium.tenko.utils
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "KnowledgeBase.db", null, 1){
    private val dbPath: String = context.getDatabasePath("KnowledgeBase.db").path
    var debugstring: String = ""

    init{
        if (!checkDatabaseExists()){
            copyDatabaseFromAssets(context)
        }
    }

    private fun checkDatabaseExists():Boolean
    {
        val dbFile = File(dbPath)
        return dbFile.exists() && dbFile.length() > 0
    }

    private fun copyDatabaseFromAssets(context: Context)
    {
        try{
            File(dbPath).parentFile?.mkdirs()
            context.assets.open("KnowledgeBase.db").use { inputStream ->
                FileOutputStream(dbPath).use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
        } catch (e:IOException){
            throw RuntimeException("Error initializing database from assets", e)
        }
    }

    override fun onCreate(db: SQLiteDatabase) {

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onCreate(db)
    }
}