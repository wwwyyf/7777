package com.example.own6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    Button light,gyro,mangnetic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        light=findViewById(R.id.light);
        gyro=findViewById(R.id.gyro);
        mangnetic=findViewById(R.id.mangnetic);

        light.setOnClickListener(this);
        gyro.setOnClickListener(this);
        mangnetic.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.light:{
                Intent intent = new Intent(MainActivity.this,light_sensor.class);
                startActivity(intent);
                break;
            }
            case R.id.gyro:{
                Intent intent = new Intent(MainActivity.this,gyro_sensor.class);
                startActivity(intent);
                break;
            }
            case R.id.mangnetic:{
                Intent intent = new Intent(MainActivity.this,mangnetic_sensor.class);
                startActivity(intent);
                break;
            }
        }
    }
}
