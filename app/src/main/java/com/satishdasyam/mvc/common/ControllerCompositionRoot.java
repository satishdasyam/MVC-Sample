package com.satishdasyam.mvc.common;

import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;

import com.satishdasyam.mvc.networking.RestService;
import com.satishdasyam.mvc.screens.common.ViewMvcFactory;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final AppCompatActivity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, AppCompatActivity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    public RestService getApi() {
        return mCompositionRoot.getApi();
    }

    public LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mActivity);
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }

}
