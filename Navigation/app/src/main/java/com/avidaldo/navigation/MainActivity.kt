package com.avidaldo.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.avidaldo.navigation.databinding.ActivityMainBinding


/**
 * https://developer.android.com/guide/navigation/navigation-getting-started
 * https://developer.android.com/codelabs/android-navigation
 * https://www.youtube.com/watch?v=Enwgwh5ZGy4
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        /* Para recuperar el navControler de un NavHostFragment(FragmentContainerView) desde la activity que lo contiene: */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController


        binding.btnChangeFromActivity.setOnClickListener {
            when (navController.currentDestination?.id) {
                R.id.blueFragment1 -> navController.navigate(R.id.action_blueFragment_to_redFragment)
                R.id.redFragment2 -> navController.navigate(R.id.action_redFragment_to_blueFragment)
                else -> throw Exception("No hay acción definida desde el fragment actual")
            }
        }

    }

}