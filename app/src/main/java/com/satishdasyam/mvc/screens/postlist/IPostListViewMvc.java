package com.satishdasyam.mvc.screens.postlist;

import com.satishdasyam.mvc.posts.Post;
import com.satishdasyam.mvc.screens.common.IObservableViewMvc;

import java.util.List;

public interface IPostListViewMvc extends IObservableViewMvc<IPostListViewMvc.Listener> {

    public interface Listener {
        void onPostClicked(Post post);
    }

    void bindPosts(List<Post> postList);

    void showProgressIndication();

    void hideProgressIndication();

}
