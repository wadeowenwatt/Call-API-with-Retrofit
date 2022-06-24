package com.example.mphoto.photos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import androidx.fragment.app.activityViewModels
import com.example.mphoto.databinding.FragmentPhotoBinding
import com.example.mphoto.databinding.ItemGridLayoutBinding

class PhotoFragment : Fragment() {

    private var _binding : FragmentPhotoBinding? = null
    private val binding get() = _binding!!

    private val viewModel : PhotoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhotoBinding.inflate(inflater)
        binding.photosGrid.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.photos.observe(viewLifecycleOwner) {
            binding.photosGrid.adapter = PhotoGridAdapter(viewModel.photos.value!!)
        }
    }

}