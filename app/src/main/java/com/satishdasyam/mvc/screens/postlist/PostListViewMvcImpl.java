package com.satishdasyam.mvc.screens.postlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.satishdasyam.mvc.R;
import com.satishdasyam.mvc.posts.Post;
import com.satishdasyam.mvc.screens.common.ViewMvcFactory;

import java.util.List;

public class PostListViewMvcImpl extends PostListViewMvc implements  PostListAdapter.Listener {

    private PostListAdapter mPostAdapter;
    private ProgressBar mPbProgressBar;


    public PostListViewMvcImpl(LayoutInflater layoutInflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(layoutInflater.inflate(R.layout.activity_main, parent));
        RecyclerView mRvPostList = findViewById(R.id.rv_post_list);
        mPbProgressBar = findViewById(R.id.pb_progress_bar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvPostList.setLayoutManager(linearLayoutManager);
        mPostAdapter = new PostListAdapter(this, viewMvcFactory);
        mRvPostList.setAdapter(mPostAdapter);
    }

    @Override
    public void bindPosts(List<Post> postList) {
        mPostAdapter.bindPosts(postList);
    }

    @Override
    public void onPostClicked(Post post) {
        for (Listener listener : getListeners()) {
            listener.onPostClicked(post);
        }
    }

    @Override
    public void showProgressIndication() {
        mPbProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressIndication() {
        mPbProgressBar.setVisibility(View.GONE);
    }
}
