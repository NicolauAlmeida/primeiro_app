package com.example.login;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRepository {

    private final PhotoService photoService;

    public PhotoRepository() {
        photoService = RetrofitClient.getClient().create(PhotoService.class);
    }

    public void getAllPhotos(Callback<List<Photo>> callback) {
        Call<List<Photo>> call = photoService.getAllPhotos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable("Erro na resposta"));
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    public void getPhotoById(int id, Callback<Photo> callback) {
        Call<Photo> call = photoService.getPhotoById(id);
        call.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                if (response.isSuccessful()) {
                    callback.onResponse(call, response);
                } else {
                    callback.onFailure(call, new Throwable("Erro na resposta"));
                }
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }
}

