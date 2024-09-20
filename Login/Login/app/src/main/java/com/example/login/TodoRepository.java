package com.example.login;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoRepository {

    private final TodoService todoService;

    public TodoRepository() {
        todoService = RetrofitClient.getClient().create(TodoService.class);
    }

    public void getAllTodos(Callback<List<Todo>> callback) {
        Call<List<Todo>> call = todoService.getAllTodos();
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable("Erro na resposta"));
                }
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    public void getTodoById(int id, Callback<Todo> callback) {
        Call<Todo> call = todoService.getTodoById(id);
        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable("Erro na resposta"));
                }
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }
}
