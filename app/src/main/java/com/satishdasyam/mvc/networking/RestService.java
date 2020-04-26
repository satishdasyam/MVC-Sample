package com.satishdasyam.mvc.networking;

import com.satishdasyam.mvc.networking.posts.PostSchema;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestService {

    @GET("posts")
    Call<List<PostSchema>> fetchPosts();
}
