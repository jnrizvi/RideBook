package com.example.jnrizvi_ridebook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class ModifyRideFragment extends DialogFragment {
    private Button edit_this_ride;
    private Button delete;
    private OnFragmentInteractionListener listener;

    static ModifyRideFragment newInstance(Ride ride) {
        Bundle args = new Bundle();
        args.putSerializable("ride", ride);

        ModifyRideFragment fragment = new ModifyRideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    static ModifyRideFragment passList(ArrayList<Ride> list) {
        Bundle args = new Bundle();
        args.putSerializable("list", list);
//        System.out.println(list);
        ModifyRideFragment fragment = new ModifyRideFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public interface OnFragmentInteractionListener {
        void onOkPressed(Ride newRide);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.modify_ride_fragment_layout, null);
//        delete = view.findViewById(R.id.delete_button);
        edit_this_ride = view.findViewById(R.id.viewedit_button);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        edit_this_ride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                Ride rideToEdit = (Ride) bundle.getSerializable("ride");

                ((MainActivity) getActivity()).onEditPressed(rideToEdit);

            }
        });

        return builder
                    .setView(view)
                    .setTitle("Modify Ride")
                    .setNegativeButton("Cancel", null)
                    .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Bundle bundle = getArguments();
                            Ride rideToDelete = (Ride) bundle.getSerializable("ride");
                            ((MainActivity) getActivity()).onDelete(rideToDelete);
                        }
                    })
                    .create();


    }
}
