package com.example.anastr;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholder {

    @GET("photos")
    Call<List<Photos>> getPhotos();

}
