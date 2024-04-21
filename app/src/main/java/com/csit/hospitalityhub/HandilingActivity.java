package com.csit.hospitalityhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;



public class HandilingActivity extends AppCompatActivity {

    LinearLayout AddRoom;
    LinearLayout AddGuest;
    LinearLayout GuestList;
    LinearLayout BookedRooms;
    LinearLayout RemainingRooms;
    LinearLayout AllRooms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handiling);
       AddRoom=findViewById(R.id.add_room);
       AddGuest=findViewById(R.id.add_guest);
       GuestList=findViewById(R.id.Guest_booking_list);
       BookedRooms=findViewById(R.id.booked_room_list);
       RemainingRooms=findViewById(R.id.remainning_room_list);
       AllRooms=findViewById(R.id.all_room_list);

       AddRoom.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent addroomIntent=new Intent(HandilingActivity.this, com.csit.hospitalityhub.RoomAddActivity.class);
               startActivity(addroomIntent);

           }
       });

       AddGuest.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent addGuestIntent=new Intent(HandilingActivity.this, com.csit.hospitalityhub.AddGuestActivity.class);
               startActivity(addGuestIntent);
           }
       });

        GuestList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent guestlistIntent=new Intent(HandilingActivity.this, com.csit.hospitalityhub.GuestList.class);
                startActivity(guestlistIntent);
            }
        });

        BookedRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bookedroomsIntent=new Intent(HandilingActivity.this, com.csit.hospitalityhub.BookedRoomList.class);
                startActivity(bookedroomsIntent);
            }
        });

        RemainingRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent remainningroomsIntent=new Intent(HandilingActivity.this, com.csit.hospitalityhub.RemainningRoomList.class);
                startActivity(remainningroomsIntent);
            }
        });

        AllRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent allroomsIntent=new Intent(HandilingActivity.this, com.csit.hospitalityhub.AllRoomList.class);
                startActivity(allroomsIntent);
            }
        });

    }
}