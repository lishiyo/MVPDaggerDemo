package com.cziyeli.daggerbasic.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import com.cziyeli.daggerbasic.App;
import com.cziyeli.daggerbasic.R;
import com.cziyeli.daggerbasic.model.Vehicle;

import javax.inject.Inject;

public class MainActivity extends ActionBarActivity implements Injectable {

    @Inject
    Vehicle vehicle;

    TextView speedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        injectDependencies();

        speedValue = (TextView) findViewById(R.id.current_speed_value);
        speedValue.setText(String.valueOf(vehicle.getSpeed()));
    }

	/**
     * Inject dependencies for dagger.
     */
    public void injectDependencies() {
        // can do manually from the component but this builds a new one every time
//        VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
//        vehicle = component.provideVehicle();

        // or grab it from the Application singleton
        ((App) getApplication()).getVehicleComponent().inject(this);
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