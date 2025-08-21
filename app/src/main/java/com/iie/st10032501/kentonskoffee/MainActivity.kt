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
import com.iie.st10032501.kentonskoffee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var order = Order()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgSb1.setOnClickListener(this)
        binding.imgSb2.setOnClickListener(this)
        binding.imgSb3.setOnClickListener(this)
        binding.imgSb4.setOnClickListener(this)
        binding.imgSb5.setOnClickListener(this)
        binding.imgSb6.setOnClickListener(this)
    }
    override fun onClick(view: View) {
        when (view.id) {
            R.id.img_sb1 -> order.productName = "Espresso" // Example of setting product name
            R.id.img_sb2 -> order.productName = "Chai Latte"
            R.id.img_sb3 -> order.productName = "Cappaccino"
            R.id.img_sb4 -> order.productName = "Caramal Latte"
            R.id.img_sb5 -> order.productName = "Spanish Iced Latte"
            R.id.img_sb6 -> order.productName = "Chocochinno"
        }
        Toast.makeText(this@MainActivity, "MMM" + order.productName, Toast.LENGTH_SHORT).show()
        openIntent(applicationContext, order.productName, OrderDetailsActivity::class.java)
    }

    /*fun onNewPageButtonClick(view: View) {
        startActivity(Intent(this, OrderDetailsActivity::class.java))
    }*/ //the old method of starting a new activity
/*
    private val youtubeIntent by lazy {
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://youtube.com/shorts/8-bhd5BtquQ?si=9jeChSEtYVkqnc5T")
        ).apply {
            setPackage("com.google.android.youtube")
        }
    }*/

/*
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

 */
}
