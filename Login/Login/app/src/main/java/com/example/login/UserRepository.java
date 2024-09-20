package com.example.login;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private final UserService userService;

    public UserRepository() {
        userService = RetrofitClient.getClient().create(UserService.class);
    }

    public void getAllUsers(Callback<List<User>> callback) {
        Call<List<User>> call = userService.getAllUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable("Erro na resposta"));
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    public void getUserById(int id, Callback<User> callback) {
        Call<User> call = userService.getUserById(id);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable("Erro na resposta"));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }
}

