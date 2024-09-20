package com.example.login;

import androidx.annotation.NonNull;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {

    private final PostService postService;

    public PostRepository() {
        postService = RetrofitClient.getClient().create(PostService.class);
    }

    public void getAllPosts(Callback<List<Post>> callback) {
        Call<List<Post>> call = postService.getAllPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable("Erro na resposta"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    public void getPostById(int id, Callback<Post> callback) {
        Call<Post> call = postService.getPostById(id);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable("Erro na resposta"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Post> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }
}

