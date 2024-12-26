package com.example.uhhhh

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.colors.R

class MainActivity : AppCompatActivity() {

    private lateinit var listViewPizzas: ListView
    private lateinit var buttonGoToCart: Button

    private val pizzas = listOf(
        Pizza("Маргарита", 500.0),
        Pizza("Пепперони", 600.0),
        Pizza("Гавайская", 700.0)
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listViewPizzas = findViewById(R.id.listViewPizzas)
        buttonGoToCart = findViewById(R.id.buttonCheckout)

        val pizzaNames = pizzas.map { it.name }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, pizzaNames)
        listViewPizzas.adapter = adapter

        buttonGoToCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }
    }
}
