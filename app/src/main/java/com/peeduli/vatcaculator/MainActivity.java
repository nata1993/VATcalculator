package com.peeduli.vatcaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    // declaring variables
    private EditText prices, units;
    private TextView vat, exVat, inVat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initalize
        prices = findViewById(R.id.etPrice);
        units = findViewById(R.id.etNumUnits);
        vat = findViewById(R.id.txtVat);
        exVat = findViewById(R.id.txtExVat);
        inVat = findViewById(R.id.txtInVat);
    }

    public void onCalculate(View view) {
        try{
            double price = Double.parseDouble(prices.getText().toString());
            double unit = Double.parseDouble(units.getText().toString());

            if(price > 0 && unit > 0)
            {
                double exAmount = price * unit;
                double VAT = exAmount * 0.2;
                double inAmount = exAmount + VAT;

                if(((RadioButton) findViewById(R.id.rbtnIncvat)).isChecked())
                {
                    VAT = exAmount * 0.2;
                    inAmount = exAmount;
                    exAmount -= VAT;
                }

                vat.setText(NumberFormat.getInstance().format(VAT));
                exVat.setText(NumberFormat.getInstance().format(exAmount));
                inVat.setText(NumberFormat.getInstance().format(inAmount));
            }

        }
        catch (IllegalArgumentException ex){
            // toast and snackbar used to inform user with messages
            Toast.makeText( this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void onClear(View view) {
        // clear fields
        prices.setText("");
        units.setText("");
        vat.setText("");
        exVat.setText("");
        inVat.setText("");
        // focus on the first field
        prices.requestFocus();
    }
}