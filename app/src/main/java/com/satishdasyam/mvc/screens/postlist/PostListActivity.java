package com.satishdasyam.mvc.screens.postlist;

import android.os.Bundle;
import android.widget.Toast;

import com.satishdasyam.mvc.common.BaseActivity;
import com.satishdasyam.mvc.networking.posts.PostListUseCase;
import com.satishdasyam.mvc.posts.Post;

import java.util.List;

public class PostListActivity extends BaseActivity implements IPostListViewMvc.Listener,
        PostListUseCase.Listener {

    IPostListViewMvc mPostListViewMvc;
    PostListUseCase mPostListUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPostListViewMvc = getCompositionRoot().getViewMvcFactory().getPostListViewMvc(null);
        mPostListUseCase = getCompositionRoot().getPostListUseCase();
        setContentView(mPostListViewMvc.getRootView());
    }

    @Override
    public void onPostClicked(Post post) {
        Toast.makeText(getApplicationContext(), post.getPostTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPostListViewMvc.registerListener(this);
        mPostListUseCase.registerListener(this);
        mPostListViewMvc.showProgressIndication();
        mPostListUseCase.fetchPostList();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPostListViewMvc.unregisterListener(this);
        mPostListUseCase.unregisterListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPostListViewMvc.unregisterListener(this);
    }

    @Override
    public void onPostListFetched(List<Post> posts) {
        mPostListViewMvc.bindPosts(posts);
        mPostListViewMvc.hideProgressIndication();
    }

    @Override
    public void onPostListFetchFailed() {
        mPostListViewMvc.hideProgressIndication();
        Toast.makeText(getApplicationContext(), "Fetching failed", Toast.LENGTH_SHORT).show();
    }
}
