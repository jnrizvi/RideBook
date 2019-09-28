package com.example.jnrizvi_ridebook;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity implements ModifyRideFragment.OnFragmentInteractionListener {
    ListView ridesListView;
    ArrayAdapter<Ride> rideAdapter;
    ArrayList<Ride> rideDataList;

    TextView textView;
//    String[] listOfStrings;
    boolean deletePressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ridesListView = (ListView) findViewById(R.id.ride_list);

//        textView = (TextView) findViewById(R.id.textView);
//        String []listOfStrings = getResources().getStringArray(R.array.rides_array);
//        final ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, R.layout.list, listOfStrings);
//        ridesListView.setAdapter(myAdapter);

        String []distances_test = {"3.213", "2.198", "6.231", "5.234", "4.992", "1.782"};
        String []dates_test = {"2019-09-12", "2019-09-7", "2019-07-23", "2019-07-02", "2019-05-19", "2019-05-13"};
        String []times_test = {"07:47", "09:03", "08:33", "08:57", "07:18", "08:15"};

        rideDataList = new ArrayList<>();

        for (int i = 0; i< distances_test.length; i++) {
            rideDataList.add((new Ride(dates_test[i], times_test[i], distances_test[i])));
        }

        rideAdapter = new CustomRideList(this, rideDataList);

        ridesListView.setAdapter(rideAdapter);

        ridesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ridesListView.setSelection(i);
                System.out.println(rideAdapter.getItem(i).getRideTime());



//                if (deletePressed == true) {
//                    rideAdapter.remove(rideAdapter.getItem(i));
//                }


                new ModifyRideFragment().newInstance(rideAdapter.getItem(i)).show(getSupportFragmentManager(), "MODIFY_CITY");
//
//                new ModifyRideFragment().passList(rideDataList).show(getSupportFragmentManager(), "MODIFY_LIST");
                rideAdapter.notifyDataSetChanged();
            }

        });
        final Button delete_button = (Button) findViewById(R.id.delete_ride);
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deletePressed == false) {
                    deletePressed = true;
                    delete_button.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                else {
                    deletePressed = false;
                    delete_button.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }
            }
        });

        Button addNew_button = (Button) findViewById(R.id.add_new);
//        Button seeTotal_button = (Button) findViewById(R.id.see_total);
//
        addNew_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddNewRide.class);
                startActivity(intent);
            }
        });



    }

    //this one is redundant
    @Override
    public void onOkPressed(Ride newRide) {
        rideAdapter.add(newRide);
    }

    public void onDelete(Ride ride) {
        rideAdapter.remove(ride);
    }

    public void onConfirmAdd(Ride newRide) {
        rideAdapter.add(newRide);
    }
}
