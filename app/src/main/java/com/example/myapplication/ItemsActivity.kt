package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        val linkToAuth: TextView = findViewById(R.id.button_basket)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, Basket::class.java)
            startActivity(intent)
        }

        items.add(Item(1, "sofa", "Диван", "Описание товара", "Ещё описание товара", 409 ))
        items.add(Item(2, "light", "Свет", "Описание товара", "Ещё описание товара", 39 ))
        items.add(Item(3, "kitchen", "Кухня", "Описание товара", "Ещё описание товара", 999 ))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}