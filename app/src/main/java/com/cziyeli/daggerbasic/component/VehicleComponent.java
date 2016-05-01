package com.cziyeli.daggerbasic.component;

import com.cziyeli.daggerbasic.model.Vehicle;
import com.cziyeli.daggerbasic.module.VehicleModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kerry on 14/02/15.
 */

@Singleton

//Step 1
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {

    //Step 2
    Vehicle provideVehicle();

}