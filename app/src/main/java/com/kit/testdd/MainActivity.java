package com.kit.testdd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView temp,humid,wd,ws;
    ImageView icon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.antivity_main);
        temp = (TextView) findViewById(R.id.temp);
        humid = (TextView) findViewById(R.id.humidity);
        wd = (TextView) findViewById(R.id.wind_direction);
        ws = (TextView) findViewById(R.id.wind_speed);
        icon = (ImageView) findViewById(R.id.icon);
    }

}
