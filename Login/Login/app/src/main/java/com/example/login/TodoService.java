package com.example.login;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TodoService {
    @GET("todos")
    Call<List<Todo>> getAllTodos();

    @GET("todos/{id}")
    Call<Todo> getTodoById(@Path("id") int id);
}


