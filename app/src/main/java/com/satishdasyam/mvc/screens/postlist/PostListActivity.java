package com.satishdasyam.mvc.screens.postlist;

import android.os.Bundle;
import android.widget.Toast;

import com.satishdasyam.mvc.common.BaseActivity;
import com.satishdasyam.mvc.networking.RestService;
import com.satishdasyam.mvc.networking.posts.PostListUseCase;
import com.satishdasyam.mvc.networking.posts.PostSchema;
import com.satishdasyam.mvc.posts.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostListActivity extends BaseActivity implements IPostListViewMvc.Listener {

    IPostListViewMvc mPostListViewMvc;
    PostListUseCase mPostListUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPostListViewMvc = getCompositionRoot().getViewMvcFactory().getPostListViewMvc(null);
        mPostListViewMvc.registerListener(this);
        mPostListUseCase = new PostListUseCase();
        //mPostListUseCase.fetchPostList();
        fetchPostList(getCompositionRoot().getApi());
        setContentView(mPostListViewMvc.getRootView());
    }

    @Override
    public void onPostClicked(Post post) {
        Toast.makeText(getApplicationContext(), post.getPostTitle(), Toast.LENGTH_SHORT).show();
    }

    public void fetchPostList(RestService api) {
        api.fetchPosts().enqueue(new Callback<List<PostSchema>>() {
            @Override
            public void onResponse(Call<List<PostSchema>> call, Response<List<PostSchema>> response) {
                List<PostSchema> schemaList = response.body();
                List<Post> postList = new ArrayList<>();
                for (PostSchema postSchema : schemaList) {
                    postList.add(new Post(postSchema.getUserId(),
                            postSchema.getId(), postSchema.getTitle()));
                }
                mPostListViewMvc.bindPosts(postList);
            }

            @Override
            public void onFailure(Call<List<PostSchema>> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPostListViewMvc.unregisterListener(this);
    }

}
