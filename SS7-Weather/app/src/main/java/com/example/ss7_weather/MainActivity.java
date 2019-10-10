package com.example.ss7_weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHour;
    private TextView tvTem;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTem = (TextView) findViewById(R.id.tvTem);
        tvStatus = (TextView) findViewById(R.id.tvStatus);

        //B1:
        getHours();
    }

    private void getHours() {
        
    }
}
