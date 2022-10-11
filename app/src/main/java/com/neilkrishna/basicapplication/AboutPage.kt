package com.neilkrishna.basicapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.neilkrishna.basicapplication.databinding.ActivityAboutPageBinding

class AboutPage : AppCompatActivity() {
    private lateinit var binding: ActivityAboutPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "About Page"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)

        launchAboutPage()
    }

    private fun launchAboutPage() {
        val fancyAboutPage = binding.fancyaboutpage
        //fancyAboutPage.setCoverTintColor(Color.BLUE);  //Optional
        //fancyAboutPage.setCoverTintColor(Color.BLUE);  //Optional
        fancyAboutPage.setCover(R.drawable.cover_page_edited) //Pass your cover image

        fancyAboutPage.setName("VIT, Pune")
        fancyAboutPage.setDescription("It is a technical organisation that strives to improve Vishwakarma Institute of Technology's coding culture..")
        fancyAboutPage.setAppIcon(R.drawable.logo) //Pass your app icon image

        fancyAboutPage.setAppName("Development App")
        fancyAboutPage.setVersionNameAsAppSubTitle("1.0")
        fancyAboutPage.setAppDescription(
            """
                Development App is an android app which follows Google's Material Design.
                
                It serves as an illustration of an Android application that is being developed as both an open source project and for Oktoberfest.
                
                It gives participants the chance to develop new skills and create gorgeous, interactive features that highlight the possibilities of the app.
                """.trimIndent()
        )
        fancyAboutPage.addEmailLink("mlscvitpune@gmail.com") //Add your email id
        fancyAboutPage.addFacebookLink("https://www.facebook.com/mlsc.vitpune.7") //Add your facebook address url
        fancyAboutPage.addTwitterLink("https://discord.gg/2VHDP3RXEj")
        fancyAboutPage.addLinkedinLink("https://in.linkedin.com/company/mlscvitpune")
        fancyAboutPage.addGitHubLink("https://github.com/mlscvitpune")
    }
}