package com.neilkrishna.basicapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.neilkrishna.basicapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    lateinit var textViewName :TextView
    lateinit var textViewEmail : TextView
    lateinit var imgview : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

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


        val hView = sideNavView.getHeaderView(0)
        textViewName = hView.findViewById(R.id.name) as TextView
        textViewEmail = hView.findViewById(R.id.email) as TextView
        imgview = hView.findViewById(R.id.imageView) as ImageView


        sideNavView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.nav_signIn -> {
                    // Implementation for Sign-In Click
                    val account = GoogleSignIn.getLastSignedInAccount(this)
                    if (account!=null)
                    {
                        Toast.makeText(this, "Already Signed in", Toast.LENGTH_SHORT).show()

                    }else{
                        val signInIntent = mGoogleSignInClient.signInIntent
                        resultLauncher.launch(signInIntent)

                    }


                }
                R.id.nav_signOut -> {
                    // Implementation for Sign-out Click
                    mGoogleSignInClient.signOut()
                        .addOnCompleteListener(this) {
                            textViewName.setText("Android Studio")
                            textViewEmail.setText("android.studio@android.com")
                            imgview.setImageResource(R.mipmap.ic_launcher_round)
                            Toast.makeText(this, "Sign out Successful", Toast.LENGTH_SHORT).show()
                        }
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

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }


    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {

        val account = completedTask.getResult(ApiException::class.java)

        // Signed in successfully
        textViewName.setText(account.displayName)
        textViewEmail.setText(account.email)
        //Picasso.get().load(account.photoUrl).into(imgview)
        Glide.with(this).load(account.photoUrl).into(imgview)


    }

    override fun onStart() {
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account != null) {
            textViewName.setText(account.displayName)
        }
        if (account != null) {
            textViewEmail.setText(account.email)
        }
        if (account != null) {
            //Picasso.get().load(account.photoUrl).into(imgview)
            Glide.with(this).load(account.photoUrl).into(imgview)
        }


    }

}




