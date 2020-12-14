package com.example.praktikum.catatan

import androidx.room.Entity
import androidx.room.PrimaryKey

//pembuatan tabel database
@Entity(tableName = "note_table")
data class Note(
    var title: String?,
    var description: String?,
    var priority: Int ) {

    @PrimaryKey(autoGenerate = true) var id: Int = 0
}