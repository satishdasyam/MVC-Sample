package com.satishdasyam.mvc.screens.postlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.satishdasyam.mvc.R;
import com.satishdasyam.mvc.posts.Post;
import com.satishdasyam.mvc.screens.common.BaseObservableViewMvc;
import com.satishdasyam.mvc.screens.common.ViewMvcFactory;

import java.util.List;

public class PostListViewMvcImpl extends BaseObservableViewMvc<IPostListViewMvc.Listener>
        implements IPostListViewMvc, PostListAdapter.Listener {

    private PostListAdapter mPostAdapter;
    private RecyclerView mRvPostList;


    public PostListViewMvcImpl(LayoutInflater layoutInflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(layoutInflater.inflate(R.layout.activity_main, parent));
        mRvPostList = findViewById(R.id.rv_post_list);
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
}