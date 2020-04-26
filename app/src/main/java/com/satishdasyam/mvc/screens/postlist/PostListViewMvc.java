package com.satishdasyam.mvc.screens.postlist;

import com.satishdasyam.mvc.posts.Post;
import com.satishdasyam.mvc.screens.common.BaseObservableViewMvc;

import java.util.List;

public abstract class PostListViewMvc extends BaseObservableViewMvc<PostListViewMvc.Listener> {

    public interface Listener {
        void onPostClicked(Post post);
    }

    abstract void bindPosts(List<Post> postList);

    abstract void showProgressIndication();

    abstract void hideProgressIndication();

}
