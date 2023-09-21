package com.hmollaahmetoglu.teknikseyler;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class ConverterSelectSh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_select_sh);

        ImageButton homebtn;
        ImageButton pressbtn;
        ImageButton tempbtn;
        ImageButton lenghtbtn;

        homebtn = findViewById(R.id.homeButton);
        pressbtn = findViewById(R.id.cvrtslctbtnPress);
        tempbtn = findViewById(R.id.cvrtslctbtnTemp);
        lenghtbtn = findViewById(R.id.cvrtslctbtnLenght);

        homebtn.setOnClickListener(v -> {
            Intent intent = new Intent(ConverterSelectSh.this, MainActivity.class);
            startActivity(intent);

        });
        pressbtn.setOnClickListener(v -> {  // PressSh sayfasına ulaşım yapısı
            Intent intent = new Intent(ConverterSelectSh.this, PressSh.class);
            startActivity(intent);
        });
        tempbtn.setOnClickListener(v -> {   // TempSh sayfasına ulaşım yapısı
            Intent intent = new Intent(ConverterSelectSh.this, TempSh.class);
            startActivity(intent);
        });
        lenghtbtn.setOnClickListener(v -> {  // LenghtSh sayfasına ulaşım yapısı
            Intent intent = new Intent(ConverterSelectSh.this, LenghtSh.class);
            startActivity(intent);
        });


    }
}