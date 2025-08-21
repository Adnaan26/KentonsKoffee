package com.iie.st10032501.kentonskoffee

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.iie.st10032501.kentonskoffee.databinding.ActivityMainBinding
import com.iie.st10032501.kentonskoffee.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {
    val order = Order()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        order.productName = intent.getStringExtra("order"). toString()

        binding.tvPlacedOrder.text = order.productName

        when(order.productName){
            "Espresso" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb1)
            "Chai Latte" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb2)
            "Cappaccino" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb3)
            "Caramal Latte" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb4)
            "Spanish Iced Latte" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb5)
            "Chocochinno" -> binding.imgOrderedBeverage.setImageResource(R.drawable.sb6)
        }

        binding.fabOrder.setOnClickListener(){
            shareIntent(applicationContext, order.productName)
        }
    }
}