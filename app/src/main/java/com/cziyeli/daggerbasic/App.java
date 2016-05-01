package com.cziyeli.daggerbasic;

import android.app.Application;
import com.cziyeli.daggerbasic.component.DaggerVehicleComponent;
import com.cziyeli.daggerbasic.component.VehicleComponent;
import com.cziyeli.daggerbasic.module.AppModule;
import com.cziyeli.daggerbasic.module.VehicleModule;

/**
 * Application singleton provides the components as singletons.
 */
public class App extends Application {

	private VehicleComponent mVehicleComponent;

	@Override
	public void onCreate() {
		super.onCreate();

		// Dagger%COMPONENT_NAME%
		mVehicleComponent = DaggerVehicleComponent.builder()
				// list of modules that are part of this component need to be created here too
				.appModule(new AppModule(this)) // also corresponds to the name of your module: %component_name%Module
				.vehicleModule(new VehicleModule())
				.build();

		// If a Dagger 2 component does not have any constructor arguments for any of its modules,
		// then we can use .create() as a shortcut instead:
		//  mAppComponent = com.codepath.dagger.components.DaggerVehicleComponent.create();
	}

	public VehicleComponent getVehicleComponent() {
		return mVehicleComponent;
	}
}
