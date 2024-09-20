package com.example.login;

import androidx.annotation.NonNull;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentRepository {

    private final CommentService commentService;

    public CommentRepository() {
        commentService = RetrofitClient.getClient().create(CommentService.class);
    }

    public void getAllComments(Callback<List<Comment>> callback) {
        Call<List<Comment>> call = commentService.getAllComments();
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(@NonNull Call<List<Comment>> call, @NonNull Response<List<Comment>> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable("Erro na resposta"));
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    public void getCommentById(int id, Callback<Comment> callback) {
        Call<Comment> call = commentService.getCommentById(id);
        call.enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(@NonNull Call<Comment> call, @NonNull Response<Comment> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable("Erro na resposta"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Comment> call, @NonNull Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }
}

