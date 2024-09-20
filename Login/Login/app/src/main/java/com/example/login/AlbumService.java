package com.example.login;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AlbumService {
    @GET("albums")
    Call<List<Album>> getAllAlbums();

    @GET("albums/{id}")
    Call<Album> getAlbumById(@Path("id") int id);
}

