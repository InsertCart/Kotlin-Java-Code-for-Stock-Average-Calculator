package com.insertcart.adavancecal.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.insertcart.adavancecal.R;

public class StockavgActivity extends AppCompatActivity {

    private EditText[] quantityArray;
    private EditText[] priceArray;
    private TextView resultText;
    private TextView totalcostText;
    private TextView totalshareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stockavg);

        EditText quantity1 = findViewById(R.id.quantity1);
        EditText quantity2 = findViewById(R.id.quantity2);
        EditText quantity3 = findViewById(R.id.quantity3);
        EditText quantity4 = findViewById(R.id.quantity4);
        EditText quantity5 = findViewById(R.id.quantity5);
        EditText quantity6 = findViewById(R.id.quantity6);
        EditText quantity7 = findViewById(R.id.quantity7);
        EditText quantity8 = findViewById(R.id.quantity8);
        EditText quantity9 = findViewById(R.id.quantity9);
        EditText quantity10 = findViewById(R.id.quantity10);

        EditText price1 = findViewById(R.id.price1);
        EditText price2 = findViewById(R.id.price2);
        EditText price3 = findViewById(R.id.price3);
        EditText price4 = findViewById(R.id.price4);
        EditText price5 = findViewById(R.id.price5);
        EditText price6 = findViewById(R.id.price6);
        EditText price7 = findViewById(R.id.price7);
        EditText price8 = findViewById(R.id.price8);
        EditText price9 = findViewById(R.id.price9);
        EditText price10 = findViewById(R.id.price10);

        quantityArray = new EditText[]{quantity1, quantity2, quantity3, quantity4, quantity5, quantity6, quantity7, quantity8, quantity9, quantity10};
        priceArray = new EditText[]{price1, price2, price3, price4, price5, price6, price7, price8, price9, price10};
        resultText = findViewById(R.id.resultText);
        totalcostText = findViewById(R.id.totalcostText);
        totalshareText = findViewById(R.id.totalshareText);

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(view -> {

            EditText[] quantityArray = new EditText[]{quantity1, quantity2, quantity3, quantity4, quantity5, quantity6, quantity7, quantity8, quantity9, quantity10};
            EditText[] priceArray = new EditText[]{price1, price2, price3, price4, price5, price6, price7, price8, price9, price10};

            double totalValue = 0.0;
            int totalQuantity = 0;
            for (int i = 0; i < quantityArray.length; i++) {
                int quantity = Integer.parseInt(quantityArray[i].getText().toString());
                double price = Double.parseDouble(priceArray[i].getText().toString());
                totalValue += quantity * price;
                totalQuantity += quantity;
            }

            double averagePrice;
if (totalQuantity == 0) {
    averagePrice = 0.0;
} else {
    averagePrice = totalValue / totalQuantity;
}

resultText.setText(getString(R.string.average_price, averagePrice));
totalcostText.setText(String.valueOf(totalValue));
totalshareText.setText(String.valueOf(totalQuantity));
}
}
}
