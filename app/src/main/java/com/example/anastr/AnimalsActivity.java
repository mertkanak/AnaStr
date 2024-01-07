package com.example.anastr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimalsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postAdapter = new PostAdapter(this, new ArrayList<>());
        recyclerView.setAdapter(postAdapter);

        request();
    }

    public void request() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceholder jsonPlaceholder = retrofit.create(JSONPlaceholder.class);
        Call<List<Photos>> call = jsonPlaceholder.getPhotos();
        call.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                if (!response.isSuccessful()) {
                    // Hata durumunda gerekli işlemleri yapabilirsiniz.
                    return;
                }

                List<Photos> photosList = response.body();

                // PostAdapter'a verileri ekleyin ve RecyclerView'ı güncelleyin
                postAdapter.setPhotosList(photosList);
                postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {
                // Hata durumunda gerekli işlemleri yapabilirsiniz.
            }
        });
    }
}
