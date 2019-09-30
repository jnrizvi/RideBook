package com.example.jnrizvi_ridebook;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

public class EditRide extends AppCompatActivity {
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
    Button confirm_edit;
    Button cancel_edit;
    Ride rideToEdit;

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

        confirm_edit = (Button) findViewById(R.id.confirm_button);
        cancel_edit = (Button) findViewById(R.id.cancel_button);

        rideToEdit = (Ride) getIntent().getSerializableExtra("rideToEdit");

        enter_date.setText(rideToEdit.getRideDate());
        enter_distance.setText(rideToEdit.getDistance());
        enter_time.setText(rideToEdit.getRideTime());
        enter_avg_speed.setText(rideToEdit.getAvg_speed());
        enter_cadence.setText(rideToEdit.getAvg_cadence());
        enter_comment.setText(rideToEdit.getRideComment());

        confirm_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date = enter_date.getText().toString();
                distance = enter_distance.getText().toString();
                time = enter_time.getText().toString();

                avg_speed = enter_avg_speed.getText().toString();
                cadence = enter_cadence.getText().toString();
                comment = enter_comment.getText().toString();


                Ride editedRide = new Ride(date, time, distance, avg_speed, cadence, comment, false);
//                rideToEdit.setRideDate(date);
//                rideToEdit.setRideTime(time);
//                rideToEdit.setDistance(distance);
//                rideToEdit.setAvg_speed(avg_speed);
//                rideToEdit.setAvg_cadence(cadence);
//                rideToEdit.setRideComment(comment);

                Intent returnIntent = getIntent();
                returnIntent.putExtra("editedRide", rideToEdit);
                setResult(RESULT_OK, returnIntent);

                finish();
            }
        });

        cancel_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}