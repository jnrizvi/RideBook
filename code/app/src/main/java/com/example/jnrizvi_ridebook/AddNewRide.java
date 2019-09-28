package com.example.jnrizvi_ridebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddNewRide extends AppCompatActivity {

//    static AddNewRide passList(ArrayList<Ride> list) {
//        Bundle args = new Bundle();
//        args.putSerializable("list", list);
//        System.out.println(list);
//        AddNewRide fragment = new AddNewRide();
//        fragment.setArguments(args);
//        return fragment;
//    }
    String date;
    String distance;
    String time;
    EditText enter_date;
    EditText enter_distance;
    EditText enter_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_ride);

        enter_date = (EditText) findViewById(R.id.date_field);
        enter_distance = (EditText) findViewById(R.id.distance_field);
        enter_time = (EditText) findViewById(R.id.time_field);

        Button confirm_add = (Button) findViewById(R.id.confirm_button);

        confirm_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date = enter_date.getText().toString();
                distance = enter_distance.getText().toString();
                time = enter_time.getText().toString();
                System.out.println(date);
                Ride newRide = new Ride(date, distance, time);
                Intent returnIntent = getIntent();
                returnIntent.putExtra("newRide", newRide);
                setResult(RESULT_OK, returnIntent);

                finish();
            }
        });



    }
}
