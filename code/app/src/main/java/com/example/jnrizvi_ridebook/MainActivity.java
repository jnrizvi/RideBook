package com.example.jnrizvi_ridebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView RidesListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button addNew_button = (Button) findViewById(R.id.add_new);
        Button seeTotal_button = (Button) findViewById(R.id.see_total);

        addNew_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddNewRide.class);
                startActivity(intent);
            }
        });

        seeTotal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewTotalDistance.class);
                startActivity(intent);
            }
        });

    }
}
