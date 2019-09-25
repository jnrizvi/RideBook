package com.example.jnrizvi_ridebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomRideList extends ArrayAdapter<Ride> {
    private ArrayList<Ride> rides;
    private Context context;

    public CustomRideList(Context context, ArrayList<Ride> rides) {
        super(context, 0, rides);
        this.context = context;
        this.rides = rides;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list, parent, false);
        }

        Ride ride = rides.get(position);

        TextView distance_view = view.findViewById(R.id.distance_text);
        TextView time_view = view.findViewById(R.id.time_text);
        TextView date_view = view.findViewById(R.id.date_text);

        distance_view.setText(ride.getDistance());
        time_view.setText(ride.getRideTime());
        date_view.setText(ride.getRideDate());

        return view;
    }
// getView allows you to set the values for the views inside a ListView object
}
