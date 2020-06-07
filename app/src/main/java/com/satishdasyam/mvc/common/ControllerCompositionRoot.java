package com.satishdasyam.mvc.common;

import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;

import com.satishdasyam.mvc.networking.RestService;
import com.satishdasyam.mvc.networking.posts.PostListUseCase;
import com.satishdasyam.mvc.screens.common.ViewMvcFactory;

public class ControllerCompositionRoot {

    private final AppCompositionRoot mCompositionRoot;
    private final AppCompatActivity mActivity;

    public ControllerCompositionRoot(AppCompositionRoot compositionRoot, AppCompatActivity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    private RestService getApi() {
        return mCompositionRoot.getApi();
    }

    public LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mActivity);
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }

    public PostListUseCase getPostListUseCase() {
        return new PostListUseCase(getApi());
    }
}
