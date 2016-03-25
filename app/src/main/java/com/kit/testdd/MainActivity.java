package com.kit.testdd;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private static final String KEY_CITY = "key_city";
    private TextView temp, humid, wd, ws, city;
    private EditText cityEt;
    private ImageView icon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.antivity_main);
        city = (TextView) findViewById(R.id.city_name);
        cityEt = (EditText) findViewById(R.id.city_et);
        findViewById(R.id.save_btn).setOnClickListener(this);
        findViewById(R.id.next).setOnClickListener(this);
        if (savedInstanceState != null) {
            city.setText(savedInstanceState.getString(KEY_CITY, ""));
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_btn:
                city.setText(cityEt.getText().toString());
                cityEt.setText("");
                break;

            case R.id.next:
                Intent intent = new Intent(this,SecondActivity.class);

                startActivity(intent);

                break;
        }

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CITY, city.getText().toString());

        Log.d(TAG, city.getText().toString());
    }
}
