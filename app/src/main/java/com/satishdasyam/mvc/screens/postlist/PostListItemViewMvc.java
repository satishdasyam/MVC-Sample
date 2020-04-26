package com.satishdasyam.mvc.screens.postlist;


import com.satishdasyam.mvc.posts.Post;
import com.satishdasyam.mvc.screens.common.BaseObservableViewMvc;

public abstract class PostListItemViewMvc extends
        BaseObservableViewMvc<PostListItemViewMvc.Listener> {

    public interface Listener {
        void onPostClicked(Post post);
    }
    abstract void bindPost(Post post);
}
