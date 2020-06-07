package com.satishdasyam.mvc.common;

import android.app.Application;

public class App extends Application {

    private AppCompositionRoot mCompositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        mCompositionRoot = new AppCompositionRoot();
    }

    public AppCompositionRoot getCompositionRoot() {
        return mCompositionRoot;
    }

}
