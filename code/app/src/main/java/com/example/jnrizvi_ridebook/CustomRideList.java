package com.example.jnrizvi_ridebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomRideList extends ArrayAdapter<Ride> implements Serializable {
    private ArrayList<Ride> rides;
    private Context context;
    private boolean expanded;
    public CustomRideList(Context context, ArrayList<Ride> rides, boolean expanded) {
        super(context, 0, rides);
        this.context = context;
        this.rides = rides;
        this.expanded = expanded;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;
        LayoutInflater inflator = ((android.app.Activity) this.context).getLayoutInflater();



            if (rides.get(position).getExpandStatus() == true) {
//                view = LayoutInflater.from(context).inflate(R.layout.expanded_list, parent, false);
                view = inflator.inflate(R.layout.expanded_list, parent, false);
                Ride ride = rides.get(position);

                TextView date_view = view.findViewById(R.id.date_text);
                date_view.setText(ride.getRideDate());

                TextView time_view = view.findViewById(R.id.time_text);
                time_view.setText(ride.getRideTime());

                TextView distance_view = view.findViewById(R.id.distance_text);
                distance_view.setText(ride.getDistance()+" km");

                TextView avg_speed_view = view.findViewById(R.id.avg_speed_text);
                avg_speed_view.setText(ride.getAvg_speed()+" km/h");

                TextView cadence_view = view.findViewById(R.id.cadence_text);
                cadence_view.setText(ride.getAvg_cadence()+" rpm");

                TextView comment_view = view.findViewById(R.id.comment_text);
                comment_view.setText(ride.getRideComment());
//                System.out.println("jksdfksehu");
            }
            else if (rides.get(position).getExpandStatus() == false) {
//                view = LayoutInflater.from(context).inflate(R.layout.list, parent, false);
                view = inflator.inflate(R.layout.list, parent, false);

                Ride ride = rides.get(position);

                TextView distance_view = view.findViewById(R.id.distance_text);
                TextView time_view = view.findViewById(R.id.time_text);
                TextView date_view = view.findViewById(R.id.date_text);

                distance_view.setText(ride.getDistance()+" km");
                time_view.setText(ride.getRideTime());
                date_view.setText(ride.getRideDate());
            }






        return view;
    }
// getView allows you to set the values for the views inside a ListView object
}
