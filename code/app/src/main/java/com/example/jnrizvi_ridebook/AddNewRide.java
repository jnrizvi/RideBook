package com.example.jnrizvi_ridebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class AddNewRide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_ride);

        EditText enter_date = (EditText) findViewById(R.id.date_field);
        EditText enter_distance = (EditText) findViewById(R.id.distance_field);
        EditText enter_time = (EditText) findViewById(R.id.time_field);

        String date = enter_date.getText().toString();
        String distance = enter_distance.getText().toString();
        String time = enter_time.getText().toString();

//        ((MainActivity) getActivity()).onConfirmAdd();

    }
}
