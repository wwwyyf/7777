package com.example.own6;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class mangnetic_sensor extends Activity implements SensorEventListener {

    SensorManager sensorManager;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mangnetic_sensor);
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        textView=findViewById(R.id.mangnetic_text);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float values[]=sensorEvent.values;
        StringBuilder sb = new StringBuilder();
        sb.append("x轴方向的磁场强度为： ");
        sb.append(values[0]);
        sb.append("\ny轴方向的磁场强度为：");
        sb.append(values[1]);
        sb.append("\nz轴方向的磁场强度为：");
        sb.append(values[2]);
        textView.setText(sb.toString());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
