package com.satishdasyam.mvc.screens.postlist;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.satishdasyam.mvc.R;
import com.satishdasyam.mvc.posts.Post;
import com.satishdasyam.mvc.screens.common.BaseObservableViewMvc;

public class PostListItemViewMvcImpl extends BaseObservableViewMvc<IPostListItemViewMvc.Listener>
        implements IPostListItemViewMvc {

    private TextView mTvPostTitle;
    private TextView mTvUserId;
    private Post mPost;

    public PostListItemViewMvcImpl(LayoutInflater layoutInflater, ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.item_post, parent, false));
        mTvPostTitle = findViewById(R.id.tv_title);
        mTvUserId = findViewById(R.id.tv_user_id);
        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()) {
                    listener.onPostClicked(mPost);
                }
            }
        });
    }

    @Override
    @SuppressLint("SetTextI18n")
    public void bindPost(Post post) {
        mPost = post;
        mTvPostTitle.setText(post.getPostTitle());
        mTvUserId.setText(Integer.toString(post.getUserId()));
    }
}
