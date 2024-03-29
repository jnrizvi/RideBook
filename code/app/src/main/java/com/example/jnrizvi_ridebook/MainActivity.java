package com.example.jnrizvi_ridebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView ridesListView;
    private ArrayAdapter<Ride> rideAdapter;
    private ArrayList<Ride> rideDataList;

    int editPosition;
    TextView seeTotal_button;
    float total_distance = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ridesListView = (ListView) findViewById(R.id.ride_list);
        seeTotal_button = findViewById(R.id.see_total);
//        String []distances_test = {"3.213", "2.198", "6.231", "5.234", "4.992", "1.782"};
//        String []dates_test = {"2019-09-12", "2019-09-7", "2019-07-23", "2019-07-02", "2019-05-19", "2019-05-13"};
//        String []times_test = {"07:47", "09:03", "08:33", "08:57", "07:18", "08:15"};

        rideDataList = new ArrayList<>();

//        for (int i = 0; i< distances_test.length; i++) {
//            rideDataList.add((new Ride(dates_test[i], times_test[i], distances_test[i], false)));
//        }

        rideAdapter = new CustomRideList(this, rideDataList);

        ridesListView.setAdapter(rideAdapter);

        ridesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, final long id) {
                if (rideAdapter.getItem(position).getExpandStatus() == false) {
                    rideAdapter.getItem(position).setExpanded(true);
                } else if (rideAdapter.getItem(position).getExpandStatus() == true) {
                    rideAdapter.getItem(position).setExpanded(false);
                }
                rideAdapter.notifyDataSetChanged();
            }
        });

        ridesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, final View view, final int i, final long l) {

                ridesListView.setSelection(i);
//                System.out.println(rideAdapter.getItem(i).getRideTime());
                editPosition = i;

                new ModifyRideFragment().newInstance(rideAdapter.getItem(i)).show(getSupportFragmentManager(), "MODIFY_CITY");

                rideAdapter.notifyDataSetChanged();


                return true;
            }
        });

        Button addNew_button = (Button) findViewById(R.id.add_new);

        addNew_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddNewRide.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        total_distance = 0;
//        System.out.println(rideAdapter.getCount());
        for (int j = 0; j < rideAdapter.getCount(); j++) {
            total_distance += Float.parseFloat(rideAdapter.getItem(j).getDistance());
        }
        total_distance= (float) Math.floor(total_distance*100) / 100;
        seeTotal_button.setText("Total Distance: " + Float.toString(total_distance)+" km");
    }



    public void onDelete(Ride ride) {
        rideAdapter.remove(ride);
        // add a Toast if you have time
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                Ride newRide = (Ride) data.getSerializableExtra("newRide");
                rideAdapter.add(newRide);
                // add a Toast if you have time
            }
        }
        else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                Ride editedRide = (Ride) data.getSerializableExtra("editedRide");
//                System.out.println(editedRide.getRideTime());

                rideAdapter.getItem(editPosition).setRideDate(editedRide.getRideDate());
                rideAdapter.getItem(editPosition).setRideTime(editedRide.getRideTime());
                rideAdapter.getItem(editPosition).setDistance(editedRide.getDistance());
                rideAdapter.getItem(editPosition).setAvg_speed(editedRide.getAvg_speed());
                rideAdapter.getItem(editPosition).setAvg_cadence(editedRide.getAvg_cadence());
                rideAdapter.getItem(editPosition).setRideComment(editedRide.getRideComment());

                rideAdapter.notifyDataSetChanged();
            }
        }
    }

    public void onEditPressed(Ride rideToEdit) {
        Intent intent = new Intent(getApplicationContext(), EditRide.class);
        intent.putExtra("rideToEdit", rideToEdit);
        startActivityForResult(intent, 2);
    }

    public void updateTotalDistance() {
        total_distance = 0;
        for (int j = 0; j < rideAdapter.getCount(); j++) {
            total_distance += Float.parseFloat(rideAdapter.getItem(j).getDistance());
        }
        total_distance= (float) Math.floor(total_distance*100) / 100;
        seeTotal_button.setText("Total Distance: " + Float.toString(total_distance)+" km");
    }
}
