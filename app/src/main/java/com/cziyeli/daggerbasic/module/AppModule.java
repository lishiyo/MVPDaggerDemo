package com.cziyeli.daggerbasic.module;

import android.app.Application;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Need application context to set up caching.
 */
@Module
public class AppModule {

	Application mApplication;

	public AppModule(Application application) {
		mApplication = application;
	}

	@Provides
	@Singleton
	Application providesApplication() {
		return mApplication;
	}
}