package com.satishdasyam.mvc.screens.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.satishdasyam.mvc.screens.postlist.PostListItemViewMvc;
import com.satishdasyam.mvc.screens.postlist.PostListViewMvc;
import com.satishdasyam.mvc.screens.postlist.PostListItemViewMvcImpl;
import com.satishdasyam.mvc.screens.postlist.PostListViewMvcImpl;

public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public PostListViewMvc getPostListViewMvc(@Nullable ViewGroup parent) {
        return new PostListViewMvcImpl(mLayoutInflater, parent, this);
    }

    public PostListItemViewMvc getPostListItemViewMvc(@Nullable ViewGroup parent) {
        return new PostListItemViewMvcImpl(mLayoutInflater, parent);
    }
}
