package com.satishdasyam.mvc.screens.postlist;


import com.satishdasyam.mvc.posts.Post;
import com.satishdasyam.mvc.screens.common.IObservableViewMvc;

public interface IPostListItemViewMvc extends IObservableViewMvc<IPostListItemViewMvc.Listener> {

    public interface Listener {
        void onPostClicked(Post post);
    }
    void bindPost(Post post);
}
