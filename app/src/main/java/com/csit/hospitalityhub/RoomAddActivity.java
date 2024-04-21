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

public class RoomAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_room_add);

        DatabaseHelper dbh=new DatabaseHelper();

       EditText roomNameEditText = findViewById(R.id.addroom_roomname);
        EditText roomTypeEditText = findViewById(R.id.addroom_roomtype);
        EditText acTypeEditText = findViewById(R.id.addroom_ACtype);
        EditText  roomNumberEditText = findViewById(R.id.addroom_roomnumber);
        EditText roomRateEditText = findViewById(R.id.addroom_roomrate);
        EditText  currentDateEditText = findViewById(R.id.addroom_date);
       Button addButton = findViewById(R.id.add_button);

       addButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dbh.addRoom(roomNameEditText.getText().toString(),roomTypeEditText.getText().toString(),acTypeEditText.getText().toString(),Integer.parseInt(roomNumberEditText.toString())
                       ,Double.parseDouble(roomRateEditText.getText()),currentDateEditText.toString());
               finish();
           }
       });

    }
}