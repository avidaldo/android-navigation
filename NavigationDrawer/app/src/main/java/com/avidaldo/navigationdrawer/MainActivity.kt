package com.avidaldo.navigationdrawer

import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.avidaldo.navigationdrawer.databinding.ActivityMainBinding


/* https://developer.android.com/guide/navigation
https://material.io/components/navigation-drawer
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar) // Indicamos que la toolbar será utilizada como actionBar (con su API)

        //val navController = findNavController(R.id.nav_host_fragment_content_main) // Funciona con fragment, no con FragmentContainerView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment

        // El NavController es un objeto que gestiona la navegación dentro del NavHost
        navController = navHostFragment.navController


        /** Conectamos el DrawerLayout con el gráfico de navigación pasándolos a AppBarConfiguration.
        * Este objeto permite gestionar el comportamiento del botón de navegación a la izquierda de
        * la AppBar. Este comportamiento puede cambiar en función de si se trata de un destino top-level */

        // Pasando cada uno de los id del menú
        appBarConfiguration = AppBarConfiguration(
            setOf(  // Los que pasamos son los que se consideran top-level (no se muestra el icono "atrás"
                R.id.nav_main, R.id.nav_dest1, R.id.nav_dest2, R.id.nav_dest3
            ), binding.drawerLayout
        )

        /* Pasando directamente el gráfico de navegación (solo sería top-level el indicado como startDestination) */
        // appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)

        /** Si no pasamos el drawerLayout, no se crea el icono que abre el drawer desde
        * la appbar. En su lugar, aparecerá el botón "up" cada vez que estemos en uno
        * de los destinos que no sea el de inicio del gráfico */
        //appBarConfiguration = AppBarConfiguration(navController.graph)

        setupActionBarWithNavController(navController, appBarConfiguration)

        // Configuramos el la NavigationView con el navController
        binding.navView.setupWithNavController(navController)
    }

    /* Gestión del icono de navegación de la toolbar (tres rayas o flecha a la izquierda de la
    * toolbar de arriba */
    override fun onSupportNavigateUp(): Boolean {
        //val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}