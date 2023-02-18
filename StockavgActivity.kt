package com.insertcart.adavancecal.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.insertcart.adavancecal.R
import com.insertcart.adavancecal.databinding.ActivityStockavgBinding

class StockavgActivity : AppCompatActivity() {

    private lateinit var quantityArray: Array<EditText>
    private lateinit var priceArray: Array<EditText>
    private lateinit var resultText: TextView
    private lateinit var totalcostText: TextView
    private lateinit var totalshareText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stockavg)

        val quantity1 = findViewById<EditText>(R.id.quantity1)
        val quantity2 = findViewById<EditText>(R.id.quantity2)
        val quantity3 = findViewById<EditText>(R.id.quantity3)
        val quantity4 = findViewById<EditText>(R.id.quantity4)
        val quantity5 = findViewById<EditText>(R.id.quantity5)
        val quantity6 = findViewById<EditText>(R.id.quantity6)
        val quantity7 = findViewById<EditText>(R.id.quantity7)
        val quantity8 = findViewById<EditText>(R.id.quantity8)
        val quantity9 = findViewById<EditText>(R.id.quantity9)
        val quantity10 = findViewById<EditText>(R.id.quantity10)

        val price1 = findViewById<EditText>(R.id.price1)
        val price2 = findViewById<EditText>(R.id.price2)
        val price3 = findViewById<EditText>(R.id.price3)
        val price4 = findViewById<EditText>(R.id.price4)
        val price5 = findViewById<EditText>(R.id.price5)
        val price6 = findViewById<EditText>(R.id.price6)
        val price7 = findViewById<EditText>(R.id.price7)
        val price8 = findViewById<EditText>(R.id.price8)
        val price9 = findViewById<EditText>(R.id.price9)
        val price10 = findViewById<EditText>(R.id.price10)

        quantityArray = arrayOf(quantity1, quantity2, quantity3, quantity4, quantity5, quantity6, quantity7, quantity8, quantity9, quantity10)
        priceArray = arrayOf(price1, price2, price3, price4, price5, price6, price7, price8, price9, price10)
        resultText = findViewById(R.id.resultText)
        totalcostText = findViewById(R.id.totalcostText)
        totalshareText = findViewById(R.id.totalshareText)

        val calculateButton: Button = findViewById(R.id.calculateButton)
        calculateButton.setOnClickListener {
            val quantityArray = arrayOf(quantity1, quantity2, quantity3, quantity4, quantity5, quantity6, quantity7, quantity8, quantity9, quantity10)
            val priceArray = arrayOf(price1, price2, price3, price4, price5, price6, price7, price8, price9, price10)

            var totalValue = 0.0
            var totalQuantity = 0
            for (i in 0 until quantityArray.size) {
                val quantity = quantityArray[i].text.toString().toIntOrNull() ?: 0
                val price = priceArray[i].text.toString().toDoubleOrNull() ?: 0.0
                totalValue += quantity * price
                totalQuantity += quantity
            }

            val averagePrice = if (totalQuantity == 0) {
                0.0
            } else {
                totalValue / totalQuantity
            }

            resultText.text = getString(R.string.average_price, averagePrice)
            totalcostText.text = totalValue.toString()
            totalshareText.text = totalQuantity.toString()
        }
    }
}
