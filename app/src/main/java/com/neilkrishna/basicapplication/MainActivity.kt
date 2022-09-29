package com.neilkrishna.basicapplication

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.neilkrishna.basicapplication.databinding.ActivityMainBinding
import com.neilkrishna.basicapplication.databinding.ContentMainBinding
import com.neilkrishna.basicapplication.ui.home.HomeFragment
import com.neilkrishna.basicapplication.ui.people.PeopleFragment
import com.neilkrishna.basicapplication.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.appBarMain.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.open()
        }
        setSupportActionBar(binding.appBarMain.toolbar)

        val bottomNavigation: BottomNavigationView =  binding.appBarMain.contentMain.bottomNavView
        val controller = findNavController(R.id.nav_host_fragment_container)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_people, R.id.navigation_profile
            )
        )

        setupActionBarWithNavController(controller, appBarConfiguration)
        bottomNavigation.setupWithNavController(controller)


        val toolbar = binding.appBarMain.toolbar
        toolbar.setOnMenuItemClickListener{
            when(it.itemId){
                // Implementation for about page
                R.id.about -> Toast.makeText(this, "To be implemented", Toast.LENGTH_SHORT).show()
            }
            true
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val sideNavView: NavigationView = binding.navView
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,  R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
//        toolbar.setNavigationOnClickListener{
//            drawerLayout.open()
//        }
        sideNavView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.nav_signIn -> {
                    // Implementation for Sign-In Click
                    Toast.makeText(this, "To be implemented", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_signOut -> {
                    // Implementation for Sign-out Click
                    Toast.makeText(this, "To be implemented", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_container)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}