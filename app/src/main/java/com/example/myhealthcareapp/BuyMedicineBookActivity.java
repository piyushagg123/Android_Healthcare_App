package com.example.myhealthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class BuyMedicineBookActivity extends AppCompatActivity {

    EditText edname,edpincode,edaddress,edcontact;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        edname = findViewById(R.id.editTextBMBFullName);
        edpincode = findViewById(R.id.editTextBMBPincode);
        edaddress = findViewById(R.id.editTextBMBAddress);
        edcontact = findViewById(R.id.editTextBMBContact);
        btnBooking = findViewById(R.id.buttonBMBBooking);
    }
}