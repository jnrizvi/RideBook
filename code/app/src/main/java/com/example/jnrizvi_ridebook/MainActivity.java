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

public class MainActivity extends AppCompatActivity implements ModifyRideFragment.OnFragmentInteractionListener {
    ListView ridesListView;
    ArrayAdapter<Ride> rideAdapter;
    ArrayList<Ride> rideDataList;
    Ride carrier;
    int editPosition;

    boolean deletePressed;
    public boolean expanded;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ridesListView = (ListView) findViewById(R.id.ride_list);

        String []distances_test = {"3.213", "2.198", "6.231", "5.234", "4.992", "1.782"};
        String []dates_test = {"2019-09-12", "2019-09-7", "2019-07-23", "2019-07-02", "2019-05-19", "2019-05-13"};
        String []times_test = {"07:47", "09:03", "08:33", "08:57", "07:18", "08:15"};

        rideDataList = new ArrayList<>();

        for (int i = 0; i< distances_test.length; i++) {
            rideDataList.add((new Ride(dates_test[i], times_test[i], distances_test[i], false)));
        }

        rideAdapter = new CustomRideList(this, rideDataList, false);

        ridesListView.setAdapter(rideAdapter);

        ridesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, final int position, final long id) {
                if (rideAdapter.getItem(position).getExpandStatus() == false) {
                    rideAdapter.getItem(position).setExpanded(true);
                } else if (rideAdapter.getItem(position).getExpandStatus() == true) {
                    rideAdapter.getItem(position).setExpanded(false);
                }

//                expanded = true;
                rideAdapter.notifyDataSetChanged();
            }

        });

        ridesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, final View view, final int i, final long l) {

                ridesListView.setSelection(i);
                System.out.println(rideAdapter.getItem(i).getRideTime());
                editPosition = i;
                new ModifyRideFragment().newInstance(rideAdapter.getItem(i)).show(getSupportFragmentManager(), "MODIFY_CITY");
//                new ModifyRideFragment().passList(rideDataList).show(getSupportFragmentManager(), "MODIFY_LIST");
                rideAdapter.notifyDataSetChanged();
                return true;
            }
        });



        Button addNew_button = (Button) findViewById(R.id.add_new);
//        Button seeTotal_button = (Button) findViewById(R.id.see_total);

        addNew_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddNewRide.class);
                startActivityForResult(intent, 2);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                Ride newRide = (Ride) data.getSerializableExtra("newRide");
                rideAdapter.add(newRide);
            }
        }
        else if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                Ride editedRide = (Ride) data.getSerializableExtra("newRide");
                System.out.println(editedRide.getRideTime());
                rideAdapter.remove(rideAdapter.getItem(editPosition));
                rideAdapter.insert(editedRide, editPosition);
                rideAdapter.notifyDataSetChanged();
            }
        }
    }

    public void onEditPressed(Ride rideToEdit) {
        Intent intent = new Intent(getApplicationContext(), AddNewRide.class);
        startActivityForResult(intent, 2);
//        carrier = rideToEdit;
    }
}
