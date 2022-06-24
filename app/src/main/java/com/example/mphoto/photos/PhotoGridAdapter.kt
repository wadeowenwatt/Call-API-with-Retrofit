package com.example.mphoto.photos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mphoto.R
import com.example.mphoto.databinding.ItemGridLayoutBinding
import com.example.mphoto.network.MarsPhoto

class PhotoGridAdapter(private val listPhoto: List<MarsPhoto>)
    : RecyclerView.Adapter<PhotoGridAdapter.PhotoViewHolder>() {

    class PhotoViewHolder(private val itemBinding : com.example.mphoto.databinding.ItemGridLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(marsPhoto: MarsPhoto) {
            val imgUri = marsPhoto.imgSrcUrl.toUri().buildUpon().scheme("https").build()
            itemBinding.photo.load(imgUri)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val itemBinding = ItemGridLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false )
        return PhotoViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val eachPhoto : MarsPhoto = listPhoto[position]
        holder.bind(eachPhoto)
    }

    override fun getItemCount(): Int = listPhoto.size
}


