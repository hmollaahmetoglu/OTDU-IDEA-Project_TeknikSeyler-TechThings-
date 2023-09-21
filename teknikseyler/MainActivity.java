package com.hmollaahmetoglu.teknikseyler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton convertbtn; //gönderen sayfa dönüştür butonu için değişkenler oluşturuldu
        ImageButton scalebtn;    //gönderen sayfa oranla butonu için değişkenler oluşturuldu
        ImageButton calcbtn;      //gönderen sayfa hesapla butonu için değişkenler oluşturuldu

        convertbtn = findViewById(R.id.mainbtnDonustur); //gönderen sayfa dönüştür butonu bulundu
        scalebtn = findViewById(R.id.mainbtnOranla);    //gönderen sayfa oranla butonu bulundu
        calcbtn = findViewById(R.id.mainbtnHesapla);    //gönderen sayfa hesapla butonu bulundu

        // Butona tıklanma olayını dinle
        convertbtn.setOnClickListener(v -> {
            // Hedef sayfayı başlatmak için Intent nesnesi oluştur
            Intent intent = new Intent(MainActivity.this, ConverterSelectSh.class);
            startActivity(intent);      // Converter seçim sayfayı başlat
        });

        scalebtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ScalerSh.class);
            startActivity(intent);      // oranlayıcı sayfayı başlat
        });

        calcbtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalcSh.class);
            startActivity(intent);      // rtd hesaplayıcı sayfayı başlat
        });
    }
}
