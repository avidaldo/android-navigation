package com.avidaldo.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.avidaldo.navigation.databinding.FragmentRedBinding


class RedFragment : Fragment() {

    private var _binding: FragmentRedBinding? = null
    private val binding get() = _binding!!

    /** Delegando la propiedad args para recuperar los argumentos */
    private val args: RedFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRedBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        /** Al utilizar delegación, ya no tenemos que acceder así a los argumentos: */
        /* val argumentoRecibido = RedFragmentArgs.fromBundle(requireArguments()).argumentToRed
        Toast.makeText(activity, "$argumentoRecibido", Toast.LENGTH_SHORT).show() */

        Toast.makeText(activity, "${args.argumentToRed}", Toast.LENGTH_SHORT).show()

        binding.button.setOnClickListener {
            navController.navigate(RedFragmentDirections.actionRedFragmentToBlueFragment())
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}