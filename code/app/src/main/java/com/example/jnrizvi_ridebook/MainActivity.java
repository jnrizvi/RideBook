package com.example.jnrizvi_ridebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView ridesListView;
    TextView textView;
    String[] listOfStrings;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ridesListView = (ListView) findViewById(R.id.ride_list);
        textView = (TextView) findViewById(R.id.textView);
        listOfStrings = getResources().getStringArray(R.array.rides_array);
        final ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, R.layout.list, listOfStrings);
        ridesListView.setAdapter(myAdapter);

        ridesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String val = ridesListView.getItemAtPosition(i).toString();
//                index = i;
//                ridesListView.setSelection(i);
                Intent intent = new Intent(getApplicationContext(), AddNewRide.class);
                startActivity(intent);
            }

        });

//        Button addNew_button = (Button) findViewById(R.id.add_new);
//        Button seeTotal_button = (Button) findViewById(R.id.see_total);
//
//        addNew_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), AddNewRide.class);
//                startActivity(intent);
//            }
//        });
//
//        seeTotal_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), ViewTotalDistance.class);
//                startActivity(intent);
//            }
//        });

    }
}
