package com.hmollaahmetoglu.teknikseyler;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class CalcSh extends AppCompatActivity {

    private EditText rtdFrmValC;
    private EditText rtdFrmValO;
    private TextView rtdshToValO;
    private TextView rtdshToValC;
    Double rtdFrmValC1=0.0,rtdFrmValO1=0.0,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_sh);

        ImageButton homebtn;
        homebtn = findViewById(R.id.homeButton);
        homebtn.setOnClickListener(v -> {
            Intent intent = new Intent(CalcSh.this, MainActivity.class);
            startActivity(intent);

        });
        rtdFrmValC = findViewById(R.id.rtdFrmValC);
        rtdFrmValO = findViewById(R.id.rtdFrmValO);
        rtdshToValO = findViewById(R.id.rtdshToValO);
        rtdshToValC = findViewById(R.id.rtdshToValC);

        rtdFrmValC.addTextChangedListener(new TextWatcher() {   // Sıcaklıktan Dirence Hesaplama Fonksiyonu çağrılması;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cToOhm();
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        rtdFrmValO.addTextChangedListener(new TextWatcher() {   //Dirençten Sıcaklığa Hesaplama Fonksiyonu çağrılması;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ohmToC();
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void cToOhm(){    //Sıcaklıktan Dirence fonksiyonu
        DecimalFormat decimalFormat = new DecimalFormat("#.####");

        try {
            rtdFrmValC1 = Double.parseDouble(rtdFrmValC.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(CalcSh.this, "Lütfen Geçerli Bir Sayı Girin", Toast.LENGTH_SHORT).show();
        }
        result = 100*(1+0.00385*rtdFrmValC1);
        String res = decimalFormat.format(result);
        rtdshToValO.setText(res);
    }
    //Dirençten Sıcaklığa foksiyonu
    private void ohmToC(){
        DecimalFormat decimalFormat =new DecimalFormat("#.####");

        try {
            rtdFrmValO1 = Double.parseDouble(rtdFrmValO.getText().toString());
        }catch (NumberFormatException e) {
            Toast.makeText(CalcSh.this, "Lütfen Geçerli Bir Sayı Girin", Toast.LENGTH_SHORT).show();
        }

        result = (rtdFrmValO1/100-1)/0.00385;
        String res = decimalFormat.format(result);
        rtdshToValC.setText(res);

    }
}