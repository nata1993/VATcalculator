package com.peeduli.vatcaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
            
        }
        catch (IllegalArgumentException ex){
            Toast.makeText( this, "", Toast.LENGTH_SHORT).show();
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