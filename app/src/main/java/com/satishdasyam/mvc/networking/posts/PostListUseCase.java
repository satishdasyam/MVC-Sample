package com.satishdasyam.mvc.networking.posts;

import com.satishdasyam.mvc.networking.RestService;
import com.satishdasyam.mvc.posts.Post;
import com.satishdasyam.mvc.screens.common.BaseObservableViewMvc;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostListUseCase extends BaseObservableViewMvc<PostListUseCase.Listener> {


    public interface Listener {
        void onPostListFetched(List<Post> posts);

        void onPostListFetchFailed();
    }

    final RestService mRestService;

    public PostListUseCase(RestService restService) {
        mRestService = restService;
    }

    public void fetchPostList() {
        mRestService.fetchPosts().enqueue(new Callback<List<PostSchema>>() {
            @Override
            public void onResponse(Call<List<PostSchema>> call, Response<List<PostSchema>> response) {
                List<PostSchema> schemaList = response.body();
                List<Post> postList = new ArrayList<>();
                for (PostSchema postSchema : schemaList) {
                    postList.add(new Post(postSchema.getUserId(),
                            postSchema.getId(), postSchema.getTitle()));
                }
                notifySuccess(postList);
            }

            @Override
            public void onFailure(Call<List<PostSchema>> call, Throwable t) {
                notifyFailure();
            }
        });
    }

    private void notifySuccess(List<Post> postList) {
        for (Listener listener : getListeners()) {
            listener.onPostListFetched(postList);
        }
    }

    private void notifyFailure() {
        for (Listener listener : getListeners()) {
            listener.onPostListFetchFailed();
        }
    }
}
