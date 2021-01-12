package com.example.praktikum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praktikum.catatan.Note
import kotlinx.android.synthetic.main.not_item.view.*

class NoteAdapter : ListAdapter<Note, NoteAdapter.NoteHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Note>() {
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.title == newItem.title && oldItem.description == newItem.description
                        && oldItem.priority == newItem.priority && oldItem.waktu == newItem.waktu
            }
        }
    }
    //menampilkan data
    private var listener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.not_item, parent, false)
        return NoteHolder(itemView)
    }
    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote: Note = getItem(position)
        holder.textViewTitle.text = currentNote.title
        holder.textViewPriority.text = currentNote.priority.toString()
        holder.textViewDescription.text = currentNote.description
        holder.textViewWaktu.text = currentNote.waktu
    }
    fun getNoteAt(position: Int): Note {
        return getItem(position)
    }
    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(getItem(position))
                }
            }
        }
        var textViewTitle: TextView = itemView.Nama
        var textViewPriority: TextView = itemView.Jumlah
        var textViewDescription: TextView = itemView.Tanggal
        var textViewWaktu: TextView = itemView.Waktu
    }
    interface OnItemClickListener {
        fun onItemClick(note: Note)
    }
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}