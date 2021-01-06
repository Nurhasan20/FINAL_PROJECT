package com.example.praktikum

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_note.*

//Untuk membuat variabel dan inisialisai
class AddEditNoteActivity : AppCompatActivity() {
    companion object { 
        const val EXTRA_ID = "com.piusanggoro.notesapp.EXTRA_ID"
        const val EXTRA_JUDUL = "com.piusanggoro.notesapp.EXTRA_JUDUL"
        const val EXTRA_DESKRIPSI = "com.piusanggoro.notesapp.EXTRA_DESKRIPSI"
        const val EXTRA_PRIORITAS = "com.piusanggoro.notesapp.EXTRA_PRIORITAS"
        const val EXTRA_WAKTU = "com.piusanggoro.notesapp.EXTRA_WAKTU"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        number_picker_priority.minValue = 1
        number_picker_priority.maxValue = 1000
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_clear_black_24dp)

        if (intent.hasExtra(EXTRA_ID)) {
            title = "Edit Catatan"
            edit_nama.setText(intent.getStringExtra(EXTRA_JUDUL))
            edit_tanggal.setText(intent.getStringExtra(EXTRA_DESKRIPSI))
            number_picker_priority.value = intent.getIntExtra(EXTRA_PRIORITAS, 1)
            edit_waktu.setText(intent.getStringExtra(EXTRA_WAKTU))
        } else {
            title = "Tambah Catatan"
        }
    }

    //Untuk melakukan algortima penyimpanan
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_note_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            R.id.save_note -> {
                saveNote()
                true
            }
            else -> super.onOptionsItemSelected(item!!)
        }
    }
    private fun saveNote() {
        if (edit_nama.text.toString().trim().isBlank() || edit_tanggal.text.toString().trim().isBlank()
            || edit_waktu.text.toString().trim().isBlank() )  {
            Toast.makeText(this, "Catatan kosong!", Toast.LENGTH_SHORT).show()
            return
        }

        val data = Intent().apply {
            putExtra(EXTRA_JUDUL, edit_nama.text.toString())
            putExtra(EXTRA_DESKRIPSI, edit_tanggal.text.toString())
            putExtra(EXTRA_PRIORITAS, number_picker_priority.value)
            putExtra(EXTRA_WAKTU, edit_waktu.text.toString())
            if (intent.getIntExtra(EXTRA_ID, -1) != -1) {
                putExtra(EXTRA_ID, intent.getIntExtra(EXTRA_ID, -1))
            }
        }
        setResult(Activity.RESULT_OK, data)
        finish()
    }
}