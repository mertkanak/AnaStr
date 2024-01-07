package com.example.anastr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchCloseBtn = findViewById(R.id.search_close_btn);

        // Butona tıklama olayını dinle
        searchCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona tıklandığında AnimalsActivity'yi başlat
                Intent intent = new Intent(MainActivity.this, AnimalsActivity.class);
                startActivity(intent);
            }
        });
    }


}
