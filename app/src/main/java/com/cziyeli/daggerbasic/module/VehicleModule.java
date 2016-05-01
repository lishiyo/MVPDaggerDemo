package com.cziyeli.daggerbasic.module;

import com.cziyeli.daggerbasic.model.Motor;
import com.cziyeli.daggerbasic.model.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kerry on 14/02/15.
 */

@Module
public class VehicleModule {

    @Provides @Singleton
    Motor provideMotor(){
        return new Motor();
    }

    @Provides @Singleton
    Vehicle provideVehicle(){
        return new Vehicle(new Motor());
    }
}