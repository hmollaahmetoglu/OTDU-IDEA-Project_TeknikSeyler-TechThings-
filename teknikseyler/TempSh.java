package com.hmollaahmetoglu.teknikseyler;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class TempSh extends AppCompatActivity {

    public EditText tempshinputtxt;
    protected TextView tempshoutputc;
    protected TextView tempshoutputf;
    protected TextView tempshoutputk;
    protected Double inputVal = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_sh);

        // Home ve Back Butonlarının bulunması
        ImageButton homebtn = findViewById(R.id.homeButton);
        ImageButton backbtn = findViewById(R.id.backButton);
        // Home ve Back Butonlarının İşlevleri
        homebtn.setOnClickListener(v -> {
            Intent intent = new Intent(TempSh.this, MainActivity.class);
            startActivity(intent);
        });
        backbtn.setOnClickListener(v -> {
            Intent intent = new Intent(TempSh.this, ConverterSelectSh.class);
            startActivity(intent);
        });

        // Sıcaklık değeri hesaplamaları başlangıcı
        ImageButton celciusbtn = findViewById(R.id.celciusbtn);
        ImageButton fahrenheitbtn = findViewById(R.id.fahrenheitbtn);
        ImageButton kelvinbtn = findViewById(R.id.kelvinbtn);
        tempshoutputc = findViewById(R.id.tempshoutputc);
        tempshoutputf = findViewById(R.id.tempshoutputf);
        tempshoutputk = findViewById(R.id.tempshoutputk);
        // Buton tıklamalarını izleme
        celciusbtn.setOnClickListener(v -> celciusToOther());  // Celcius
        fahrenheitbtn.setOnClickListener(v -> fahrenheitToOther());  // Fahranheit
        kelvinbtn.setOnClickListener(v -> kelvinToOther());  // Kelvin
    }
    private void celciusToOther(){  //Celcius dan diğer birimlere dönüşüm fonksiyonu
        DecimalFormat decimalFormat = new DecimalFormat("#.####"); // Noktadan sonraki hane sınırlaması
        tempshinputtxt = findViewById(R.id.tempshinputtxt);
        try {
            String inputtaken = tempshinputtxt.getText().toString();
            inputVal = Double.parseDouble(inputtaken);

        } catch (NumberFormatException e) {
            Toast.makeText(TempSh.this, "Lütfen Geçerli Bir Sayı Girin", Toast.LENGTH_SHORT).show();
        }

        Double celcius = inputVal;
        String celc = decimalFormat.format(celcius);
        tempshoutputc.setText(celc);

        Double fahrenheit = (inputVal*1.8)+32 ;
        String fahr = decimalFormat.format(fahrenheit);
        tempshoutputf.setText(fahr);

        Double kelvin = (inputVal+273.15);
        String kel = decimalFormat.format(kelvin);
        tempshoutputk.setText(kel);
   }
    private void fahrenheitToOther(){   // Fahranheit dan diğer birimlere dönüşüm fonksiyonu
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        tempshinputtxt = findViewById(R.id.tempshinputtxt);
        try {
            String inputtaken = tempshinputtxt.getText().toString();
            inputVal = Double.parseDouble(inputtaken);

        } catch (NumberFormatException e) {
            Toast.makeText(TempSh.this, "Lütfen Geçerli Bir Sayı Girin", Toast.LENGTH_SHORT).show();
        }

        Double celcius = (inputVal-32) / 1.8 ;
        String celc = decimalFormat.format(celcius);
        tempshoutputc.setText(celc);

        Double fahrenheit = inputVal;
        String fahr = decimalFormat.format(fahrenheit);
        tempshoutputf.setText(fahr);

        Double kelvin = (inputVal-32)*5/9+273.15;
        String kel = decimalFormat.format(kelvin);
        tempshoutputk.setText(kel);
    }
    private void kelvinToOther(){  //Kelvinden Diğer formatlara dönüşüm fonksiyonu
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        tempshinputtxt = findViewById(R.id.tempshinputtxt);
        try {
            String inputtaken = tempshinputtxt.getText().toString();
            inputVal = Double.parseDouble(inputtaken);

        } catch (NumberFormatException e) {
            Toast.makeText(TempSh.this, "Lütfen Geçerli Bir Sayı Girin", Toast.LENGTH_SHORT).show();
        }

        Double celcius = inputVal-273.15;
        String celc = decimalFormat.format(celcius);
        tempshoutputc.setText(celc);

        Double fahrenheit = (inputVal-273.15)*1.8+32 ;
        String fahr = decimalFormat.format(fahrenheit);
        tempshoutputf.setText(fahr);

        Double kelvin = inputVal;
        String kel = decimalFormat.format(kelvin);
        tempshoutputk.setText(kel);
    }
}