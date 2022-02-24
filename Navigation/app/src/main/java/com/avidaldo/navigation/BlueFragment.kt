package com.avidaldo.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.avidaldo.navigation.databinding.FragmentBlueBinding


class BlueFragment : Fragment() {

    private var _binding: FragmentBlueBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlueBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /** Para recuperar el navController desde dentro de un Fragment: */

        //val navController = Navigation.findNavController(view)
        //val navController = view.findNavController()
        val navController = findNavController()


        binding.button.setOnClickListener {
            //Toast.makeText(activity, "click en azul", Toast.LENGTH_SHORT).show()

            /* El navControler nos permite utilizar las acciones de navegación definidas en el nav_graph */
            //navController.navigate(BlueFragmentDirections.actionBlueFragmentToRedFragment())

            val numero = binding.editTextNumber.text.toString().toInt()
            //binding.editTextNumber.text.toString().toIntOrNull()?.let { action.argumentToRed = it }


            /** Para pasar datos utilizando safe-args (requiere dependencia en build.gradle)
             * https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args */
            // Recogemos la acción que queremos de las especificadas en el nav_graph
            val action = BlueFragmentDirections.actionBlueFragmentToRedFragment(numero)
            // Le añadimos el argumento definido para el fragment de destino

            // Navegamos siguiendo esa acción con ese argumento
            navController.navigate(action)

        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}