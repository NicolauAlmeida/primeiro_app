package com.example.login;

import androidx.annotation.NonNull;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

    private final AlbumService albumService;

    public AlbumRepository() {
        albumService = RetrofitClient.getClient().create(AlbumService.class);
    }

    public void getAllAlbums(Callback<List<Album>> callback) {
        Call<List<Album>> call = albumService.getAllAlbums();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(@NonNull Call<List<Album>> call, @NonNull Response<List<Album>> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable("Erro na resposta"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Album>> call, @NonNull Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    public void getAlbumById(int id, Callback<Album> callback) {
        Call<Album> call = albumService.getAlbumById(id);
        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(@NonNull Call<Album> call, @NonNull Response<Album> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable("Erro na resposta"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Album> call, @NonNull Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }
}
