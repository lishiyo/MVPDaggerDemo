package com.cziyeli.daggerbasic;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import com.cziyeli.daggerbasic.component.DaggerVehicleComponent;
import com.cziyeli.daggerbasic.component.VehicleComponent;
import com.cziyeli.daggerbasic.model.Vehicle;
import com.cziyeli.daggerbasic.module.VehicleModule;

public class MainActivity extends ActionBarActivity {

    Vehicle vehicle;

    TextView speedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speedValue = (TextView) findViewById(R.id.current_speed_value);

        VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();

        vehicle = component.provideVehicle();

        speedValue.setText(String.valueOf(vehicle.getSpeed()));
    }

    public void callBrake(View v){
        vehicle.stop();
        speedValue.setText(String.valueOf(vehicle.getSpeed()));
    }

    public void callIncrease(View v){
        vehicle.increaseSpeed(10);
        speedValue.setText(String.valueOf(vehicle.getSpeed()));
    }
}