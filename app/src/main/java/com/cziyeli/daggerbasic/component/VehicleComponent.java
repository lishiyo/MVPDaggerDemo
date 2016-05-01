package com.cziyeli.daggerbasic.component;

import com.cziyeli.daggerbasic.ui.MainActivity;
import com.cziyeli.daggerbasic.module.AppModule;
import com.cziyeli.daggerbasic.module.VehicleModule;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Component hooks references in activities, services, or fragments to the module singletons.
 */

@Singleton
@Component(modules = {AppModule.class, VehicleModule.class})
public interface VehicleComponent {

    // activities, fragments that are interested in VehicleModule
    void inject(MainActivity activity);
}