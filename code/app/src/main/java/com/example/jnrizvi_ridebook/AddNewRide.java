package com.example.jnrizvi_ridebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddNewRide extends AppCompatActivity {

    String date;
    String distance;
    String time;
    String avg_speed;
    String cadence;
    String comment;
    EditText enter_date;
    EditText enter_distance;
    EditText enter_time;
    EditText enter_avg_speed;
    EditText enter_cadence;
    EditText enter_comment;
    boolean valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_ride);

        enter_date = (EditText) findViewById(R.id.date_field);
        enter_distance = (EditText) findViewById(R.id.distance_field);
        enter_time = (EditText) findViewById(R.id.time_field);

        enter_avg_speed = (EditText) findViewById(R.id.avg_speed_field);
        enter_cadence = (EditText) findViewById(R.id.cadence_field);
        enter_comment = (EditText) findViewById(R.id.comment_field);

        Button confirm_add = (Button) findViewById(R.id.confirm_button);
        Button cancel_add = (Button) findViewById(R.id.cancel_button);

//        Ride rideToEdit = (Ride) getIntent().getSerializableExtra("rideToEdit");
//        enter_date.setText(rideToEdit.getRideDate());

        confirm_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date = enter_date.getText().toString();
                distance = enter_distance.getText().toString();
                time = enter_time.getText().toString();

                avg_speed = enter_avg_speed.getText().toString();
                cadence = enter_cadence.getText().toString();
                comment = enter_comment.getText().toString();

                if (date.isEmpty() || distance.isEmpty() || time.isEmpty() || avg_speed.isEmpty() || cadence.isEmpty()) {
//                    System.out.println("Only the comment field may be empty");
                    Toast error = Toast.makeText(getApplicationContext(), "Only the comment field may be empty", Toast.LENGTH_SHORT);
                    error.show();
                    valid = false;
                }
                else {
                    valid = true;
                }

                if (valid == true) {
                    Ride newRide = new Ride(date, time, distance, avg_speed, cadence, comment, false);
                    Intent returnIntent = getIntent();
                    returnIntent.putExtra("newRide", newRide);
                    setResult(RESULT_OK, returnIntent);

                    finish();
                }
            }
        });

        cancel_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
