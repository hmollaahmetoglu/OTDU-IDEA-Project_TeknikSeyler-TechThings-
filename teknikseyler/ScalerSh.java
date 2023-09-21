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

public class ScalerSh extends AppCompatActivity {
    private EditText prcssLowVal,prcssHighVal,signalLowVal,signalHighVal,prcssValIn,signalValIn;
    private TextView prcssToSignalOut,signalToPrcssOut;
    Double signalValIn1=0.0,prcssValIn1=0.0,prcssLowVal1=0.0,prcssHighVal1=0.0,signalHighVal1=0.0,signalLowVal1=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaler_sh);

        ImageButton homebtn;
        //home butonunun bulunması
        homebtn = findViewById(R.id.homeButton);
        //home butonu tıklandığında yapılacak işlem
        homebtn.setOnClickListener(v -> {
            Intent intent = new Intent(ScalerSh.this, MainActivity.class);
            startActivity(intent);

        });

        //TextView ve EditView lerin bulunması
        prcssLowVal = findViewById(R.id.prcssLowVal);
        prcssHighVal = findViewById(R.id.prcssHighVal);
        signalLowVal = findViewById(R.id.signalLowVal);
        signalHighVal = findViewById(R.id.signalHighVal);
        prcssValIn = findViewById(R.id.prcssValIn);
        signalValIn = findViewById(R.id.signalValIn);
        prcssToSignalOut = findViewById(R.id.prcssToSignalOut);
        signalToPrcssOut = findViewById(R.id.signalToPrcssOut);

        prcssValIn.addTextChangedListener(new TextWatcher() {  // process değeri giriş alnındaki değişiklikleri izleyerek her değişimde anlık hesaplama yapması sağlandı
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                PrcssToSignalCalc();
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        signalValIn.addTextChangedListener(new TextWatcher() { // signal değeri giriş alnındaki değişiklikleri izleyerek her değişimde anlık hesaplama yapması sağlandı
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SignalToProcessCalc();
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void PrcssToSignalCalc(){  // Process den Sinyale oranlama metodu
        DecimalFormat decimalFormat = new DecimalFormat("#.###"); // Noktadan sonra 3 hane ile sınırlandırma için kullanıldı.

        try {
            prcssValIn1 = Double.parseDouble(prcssValIn.getText().toString());      // Tüm değişkenler bulunarak double tipine çevriliyor
            prcssLowVal1 = Double.parseDouble(prcssLowVal.getText().toString());
            prcssHighVal1 = Double.parseDouble(prcssHighVal.getText().toString());
            signalLowVal1 = Double.parseDouble(signalLowVal.getText().toString());
            signalHighVal1 = Double.parseDouble(signalHighVal.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(ScalerSh.this, "Lütfen Geçerli Bir Sayı Girin", Toast.LENGTH_SHORT).show();
        }
        // Hesaplama - Formül
        Double scaleResult = ((prcssValIn1 - prcssLowVal1) / (prcssHighVal1 - prcssLowVal1)*(signalHighVal1-signalLowVal1)+signalLowVal1);
        String res = decimalFormat.format(scaleResult); // Bulunan doublu tipindeki sonuç tekrar TextView da kullanılabilmesi için String tipine çevriliyor
        prcssToSignalOut.setText(res); // İlgili TextView da sonuç kullanıcıya gösteriliyor
    }
    private void SignalToProcessCalc(){  // Sinyal den Process değerine oranlama metodu
        DecimalFormat decimalFormat = new DecimalFormat("#.###"); // Noktadan sonra 3 hane ile sınırlandırma için kullanıldı.

        try {
            signalValIn1 = Double.parseDouble(signalValIn.getText().toString());
            prcssLowVal1 = Double.parseDouble(prcssLowVal.getText().toString());
            prcssHighVal1 = Double.parseDouble(prcssHighVal.getText().toString());
            signalLowVal1 = Double.parseDouble(signalLowVal.getText().toString());
            signalHighVal1 = Double.parseDouble(signalHighVal.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(ScalerSh.this, "Lütfen Geçerli Bir Sayı Girin", Toast.LENGTH_SHORT).show();
        }

        Double scaleResult = ((signalValIn1 - signalLowVal1) / (signalHighVal1 - signalLowVal1)*(prcssHighVal1-prcssLowVal1)+prcssLowVal1);
        String res = decimalFormat.format(scaleResult);
        signalToPrcssOut.setText(res);

    }
}