package com.example.uhhhh

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.colors.R

class CartActivity : AppCompatActivity() {

    private lateinit var listViewCartItems: ListView
    private lateinit var buttonCheckout: Button

    private var cartItems = mutableListOf<Pizza>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        listViewCartItems = findViewById(R.id.listViewCartItems)
        buttonCheckout = findViewById(R.id.buttonCheckout)

        displayCartItems()

        buttonCheckout.setOnClickListener {
            processPayment()
        }
    }

    private fun displayCartItems() {
        val cartItemNames = cartItems.map { "${it.name} - ${it.price}₽" }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cartItemNames)
        listViewCartItems.adapter = adapter
    }

    private fun processPayment() {

        Toast.makeText(this, "Оплата проведена!", Toast.LENGTH_SHORT).show()
    }
}
