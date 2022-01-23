package com.avidaldo.navigationdrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.avidaldo.navigationdrawer.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        //return inflater.inflate(R.layout.fragment_dest12, container, false)
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Obtenemos el navControler que permite utilizar las acciones de navegación definidas en el nav_graph */
        val navController = findNavController()

        binding.btnMainToDest1.setOnClickListener { navController.navigate(R.id.action_nav_main_to_nav_dest1) }
        binding.btnMainToDest2.setOnClickListener { navController.navigate(R.id.action_nav_main_to_nav_dest2) }
        binding.btnMainToDest3.setOnClickListener { navController.navigate(R.id.action_nav_main_to_nav_dest3) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}