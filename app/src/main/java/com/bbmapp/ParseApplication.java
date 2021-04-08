package com.bbmapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();
        //Register your parse models
        ParseObject.registerSubclass(Post1.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("7YXgLjiey8RUYnquATzomc7Hy38j7GAKFwUxGQf6")
                .clientKey("42EIH3wkSJtClMyc5XKUaGYTV6OsfkZ01FK09HgJ")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
