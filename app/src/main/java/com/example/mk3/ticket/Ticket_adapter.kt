package com.example.mk3.ticket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mk3.R
import kotlinx.android.synthetic.main.ticket_item.view.*


class Ticket_adapter(
    private val exampleList: List<Ticket_item>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<Ticket_adapter.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.ticket_item,
            parent, false)
        return ExampleViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.nome.text = currentItem.nome
        holder.livello.text = currentItem.livello
        holder.tipo_corso.text = currentItem.tipo
        holder.pacchetto.text = currentItem.pacchetto

    }
    override fun getItemCount() = exampleList.size
    inner class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val imageView: ImageView = itemView.image_view
        val nome: TextView = itemView.nome_tv
        val livello: TextView = itemView.livello_tv
        val tipo_corso: TextView = itemView.tipo_tv
        val pacchetto: TextView = itemView.pacchetto_tv
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}