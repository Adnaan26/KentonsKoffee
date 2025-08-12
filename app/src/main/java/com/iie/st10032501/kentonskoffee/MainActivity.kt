package com.iie.st10032501.kentonskoffee


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val youtubeIntent by lazy {
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://youtube.com/shorts/8-bhd5BtquQ?si=9jeChSEtYVkqnc5T")
        ).apply {
            setPackage("com.google.android.youtube")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onMyButtonClick(view: View) {
        Toast.makeText(this, "And its Lews Hamilton 8th time CHAMPION OF THE WORLD!", Toast.LENGTH_SHORT).show()
    }

    fun onYouTubeButtonClick(view: View) {
        try {
            startActivity(youtubeIntent)
        } catch (e: Exception) {
            Toast.makeText(this, "YouTube app not found", Toast.LENGTH_LONG).show()
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://youtube.com/shorts/8-bhd5BtquQ?si=9jeChSEtYVkqnc5T")
                )
            )
        }
    }
}
