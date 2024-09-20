package com.example.login;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PhotoService {
    @GET("photos")
    Call<List<Photo>> getAllPhotos();

    @GET("photos/{id}")
    Call<Photo> getPhotoById(@Path("id") int id);
}

