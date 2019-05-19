package com.example.own6;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class light_sensor extends Activity implements SensorEventListener {

    SensorManager sensorManager;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        textView=findViewById(R.id.light_text);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float values[]=sensorEvent.values;
        String str = "当前的光强度：";
        Float f = new Float(values[0]);
        str += f.toString();
        textView.setText(str);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
