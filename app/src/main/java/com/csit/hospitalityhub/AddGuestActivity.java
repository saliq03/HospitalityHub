package com.csit.hospitalityhub;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import backend.DatabaseHelper;

public class AddGuestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_guest);

       DatabaseHelper dbHelper = new DatabaseHelper();

        // Find views
        EditText guestNameEditText = findViewById(R.id.addguest_name);
        EditText roomTypeEditText = findViewById(R.id.addguest_roomtype);
        EditText acTypeEditText = findViewById(R.id.addguest_ACtype);
        EditText roomAvailableEditText = findViewById(R.id.addguest_roomavailable);
        EditText roomRateEditText = findViewById(R.id.addguest_actual_roomrate);
        EditText mobileEditText = findViewById(R.id.addguest_mobile);
        EditText currentDateEditText = findViewById(R.id.addroom_date);
        EditText checkInDateEditText = findViewById(R.id.addroom_checkin_date);
        EditText checkOutDateEditText = findViewById(R.id.addroom_checkout_date);
         Button addButton = findViewById(R.id.add_button);

         addButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 dbHelper.addGuest(guestNameEditText.getText().toString(),roomTypeEditText.getText().toString(),
                         acTypeEditText.getText().toString(),Integer.parseInt(roomAvailableEditText.getText()),
                         Double.parseDouble(roomRateEditText.getText()),mobileEditText.getText().toString(),currentDateEditText.getText().toString());
                 finish();
             }
         });


    }
}