package com.example.jnrizvi_ridebook;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ModifyRideFragment extends DialogFragment {
    private Button view_edit;
    private Button delete;
    private OnFragmentInteractionListener listener;
    
    static ModifyRideFragment newInstance(Ride ride) {
        Bundle args = new Bundle();
        args.putSerializable("ride", ride);

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
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.modify_ride_fragment_layout, null);
        delete = view.findViewById(R.id.delete_button);
        view_edit = view.findViewById(R.id.viewedit_button);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        String myTag = getTag();


        System.out.println(myTag);
        return builder
                .setView(view)
                .setTitle("Modify Ride")
                .setNegativeButton("Go Back", null)
                .create();



    }
}
