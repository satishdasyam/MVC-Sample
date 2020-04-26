package com.satishdasyam.mvc.screens.postlist;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.satishdasyam.mvc.posts.Post;
import com.satishdasyam.mvc.screens.common.ViewMvcFactory;

import java.util.ArrayList;
import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostViewHolder>
        implements PostListItemViewMvc.Listener {

    interface Listener {
        void onPostClicked(Post post);
    }

    private List<Post> mPostList;
    private Listener mListener;
    private ViewMvcFactory mViewMvcFactory;

    public PostListAdapter(Listener listener, ViewMvcFactory viewMvcFactory) {
        mListener = listener;
        mViewMvcFactory = viewMvcFactory;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostListItemViewMvc postListItemViewMvc = mViewMvcFactory.getPostListItemViewMvc(parent);
        postListItemViewMvc.registerListener(this);
        return new PostViewHolder(postListItemViewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.itemViewMvc.bindPost(mPostList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPostList != null ? mPostList.size() : 0;
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        final PostListItemViewMvc itemViewMvc;

        PostViewHolder(@NonNull PostListItemViewMvc itemView) {
            super(itemView.getRootView());
            itemViewMvc = itemView;
        }
    }

    public void bindPosts(List<Post> postList) {
        mPostList = new ArrayList<>(postList);
        notifyDataSetChanged();
    }

    @Override
    public void onPostClicked(Post post) {
        mListener.onPostClicked(post);
    }
}
