package com.example.login;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CommentService {
    @GET("comments")
    Call<List<Comment>> getAllComments();

    @GET("comments/{id}")
    Call<Comment> getCommentById(@Path("id") int id);
}

