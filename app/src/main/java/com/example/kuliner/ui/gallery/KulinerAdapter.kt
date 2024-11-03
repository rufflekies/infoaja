package com.example.kuliner.ui.gallery

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kuliner.R

class KulinerAdapter(private val kulinerList: List<Kuliner>) : RecyclerView.Adapter<KulinerAdapter.KulinerViewHolder>() {

    // ViewHolder untuk item kuliner
    inner class KulinerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image_kuliner)
        val textView: TextView = view.findViewById(R.id.text_kuliner_name)
        val textViewAddress: TextView = view.findViewById(R.id.text_kuliner_address)
        val ratingBar: RatingBar = view.findViewById(R.id.rating_kuliner)
        val ratingTextView: TextView = view.findViewById(R.id.text_rating_value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KulinerViewHolder {
        // Inflate layout item_kuliner.xml
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_kuliner, parent, false)
        return KulinerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KulinerViewHolder, position: Int) {
        // Ambil objek kuliner berdasarkan posisi
        val kuliner = kulinerList[position]

        // Mengisi data ke view holder
        holder.textView.text = kuliner.name
        holder.textViewAddress.text = kuliner.address
        holder.ratingBar.rating = kuliner.rating

        // Memuat gambar menggunakan Glide
        Glide.with(holder.itemView.context)
            .load(kuliner.imageUrl)
            .into(holder.imageView)

        // Menampilkan rating sebagai teks
        holder.ratingTextView.text = "${kuliner.rating} / 5"

        // Set click listener untuk setiap item
        holder.itemView.setOnClickListener {
            // Navigasi ke halaman detail
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply {
                putExtra("KULINER_NAME", kuliner.name)
                putExtra("KULINER_ADDRESS", kuliner.address)
                putExtra("KULINER_IMAGE_URL", kuliner.imageUrl)
                putExtra("KULINER_RATING", kuliner.rating)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return kulinerList.size
    }
}