package com.example.dagger2.dagger;

import android.app.Application;
import android.content.Context;
import com.example.dagger2.models.User;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    User provideUser() {
        return new User();
    }
}
