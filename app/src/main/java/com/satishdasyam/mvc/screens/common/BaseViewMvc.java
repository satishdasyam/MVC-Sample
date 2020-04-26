package com.satishdasyam.mvc.screens.common;

import android.content.Context;
import android.view.View;

public abstract class BaseViewMvc implements IViewMvc {

    private View mRootView ;

    @Override
    public View getRootView() {
        return mRootView;
    }

    protected void setRootView(View mRootView) {
        this.mRootView = mRootView;
    }

    protected <T extends View> T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    protected Context getContext() {
        return getRootView().getContext();
    }
}
