package com.satishdasyam.mvc.networking.posts;

import com.satishdasyam.mvc.networking.RestService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostListUseCase {

    public void fetchPostList(RestService api) {
        api.fetchPosts().enqueue(new Callback<List<PostSchema>>() {
            @Override
            public void onResponse(Call<List<PostSchema>> call, Response<List<PostSchema>> response) {

            }

            @Override
            public void onFailure(Call<List<PostSchema>> call, Throwable t) {

            }
        });
    }
}
