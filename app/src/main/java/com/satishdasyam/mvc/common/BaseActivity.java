package com.satishdasyam.mvc.common;

import android.annotation.SuppressLint;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot mControllerCompositionRoot;

    public ControllerCompositionRoot getCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(((App) getApplication())
                    .getCompositionRoot(), this);
        }
        return mControllerCompositionRoot;
    }
}
