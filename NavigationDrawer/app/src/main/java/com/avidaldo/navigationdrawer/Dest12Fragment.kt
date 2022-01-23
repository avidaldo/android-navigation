package com.avidaldo.navigationdrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.avidaldo.navigationdrawer.databinding.FragmentDest12Binding

class Dest12Fragment : Fragment() {
    private var _binding: FragmentDest12Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDest12Binding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        binding.btnToDest13.setOnClickListener {
            navController.navigate(R.id.action_nav_dest12_to_nav_dest13)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}