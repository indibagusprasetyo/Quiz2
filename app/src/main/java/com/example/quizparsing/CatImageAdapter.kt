package com.example.quizparsing

//Nama        : Indi Bagus Prasetyo ;
//NIM         : 10121902 ;
//Kelas       : IF9K ;
//Mata Kuliah : Pemrograman Android ;
//Dosen       : Rizki Adam Kurniawan, M.Kom. ;
//Selesai     : 31 Juli 2024. 23:50 ;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CatImageAdapter(private val catImages: List<CatImage>) :
    RecyclerView.Adapter<CatImageAdapter.CatImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cat_image, parent, false)
        return CatImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: CatImageViewHolder, position: Int) {
        val catImage = catImages[position]
        Glide.with(holder.itemView.context)
            .load(catImage.url)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int = catImages.size

    class CatImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}
