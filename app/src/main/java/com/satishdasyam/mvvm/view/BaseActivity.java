package com.satishdasyam.mvvm.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*public ActivityComponent getActivityComponent() {
        return ((MvvmApp) getApplication()).getAppComponent().
                newActivityComponent(new ActivityModule(this));
    }*/
}
