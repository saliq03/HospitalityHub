package com.csit.hospotalityhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HandilingActivity extends AppCompatActivity {

    LinearLayout AddRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handiling);
       AddRoom=findViewById(R.id.add_room);
       AddRoom.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent addroomIntent=new Intent(HandilingActivity.this, RoomAddActivity.class);
               startActivity(addroomIntent);

           }
       });
    }
}