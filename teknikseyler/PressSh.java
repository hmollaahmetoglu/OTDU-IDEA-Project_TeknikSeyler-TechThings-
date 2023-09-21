package com.hmollaahmetoglu.teknikseyler;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class PressSh extends AppCompatActivity {
    private Spinner pressspinner1, pressspinner2;
    private TextView pressshToVal;
    private EditText pressFrmVal;
    private ImageButton homebtn;
    private ImageButton backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_press_sh);

        //home ve back butonlarının bulunması
        homebtn = findViewById(R.id.homeButton);
        backbtn = findViewById(R.id.backButton);

        //home ve back butonlarının tıklamalarının algılanması
        homebtn.setOnClickListener(v -> {
            Intent intent = new Intent(PressSh.this, MainActivity.class);
            startActivity(intent);
        });
        backbtn.setOnClickListener(v -> {
            Intent intent = new Intent(PressSh.this, ConverterSelectSh.class);
            startActivity(intent);
        });
        // Spinner lar, TextView ve EditView in bulunması
        pressspinner1 = findViewById(R.id.pressspinner1);
        pressspinner2 = findViewById(R.id.pressspinner2);
        pressshToVal = findViewById(R.id.pressshToVal);
        pressFrmVal = findViewById(R.id.pressFrmVal);

        //Spinner'ların içeriğinin string.xml kaynaklarından alınması
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.pressspinner1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pressspinner1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.pressspinner2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pressspinner2.setAdapter(adapter2);

        //Spinner seçimlerini dinleyici
        AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculateResult();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };

        pressspinner1.setOnItemSelectedListener(spinnerListener);
        pressspinner2.setOnItemSelectedListener(spinnerListener);

        //Kullanıcının inputu güncellediğinde hesaplamaların yeniden başlaması için
        pressFrmVal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // kullanıcı girişi değiştirdiği anda hesaplama anlık yenilenecek
                calculateResult();
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void calculateResult() {
        String selectedOption1 = pressspinner1.getSelectedItem().toString();
        String selectedOption2 = pressspinner2.getSelectedItem().toString();
        Double inputVal = 0.0; // ilk değerin atanması
        DecimalFormat decimalFormat = new DecimalFormat("#.###"); // Noktadan sonra 3 hane ile sınırlandırma için kullanıldı.

        // Hatalı bir giriş yapılmasına karşı önlem ve uyarı
        try {
            String userInputStr = pressFrmVal.getText().toString(); // girilen değerin hesaplamalarda kullanılabilmesi için gerekli double çevrimi
            inputVal = Double.parseDouble(userInputStr);
        } catch (NumberFormatException e) {
            Toast.makeText(PressSh.this, "Lütfen Geçerli Bir Sayı Girin", Toast.LENGTH_SHORT).show();
        }

        //Spinner pozisyonlarına göre hangi Hesaplama yönteminin kullanılacağının bulunması ve sonucun üretilerek çıktının verilmesi

        if (selectedOption1.equals("Bar") && selectedOption2.equals("Bar")) {
            double result = inputVal;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("Bar") && selectedOption2.equals("mBar")) {
            double result = inputVal * 1000;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("Bar") && selectedOption2.equals("psi")) {
            double result = inputVal * 14.5038;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("Bar") && selectedOption2.equals("kPa")) {
            double result = inputVal * 100;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("Bar") && selectedOption2.equals("inH2O")) {
            double result = inputVal * 401.463;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("psi") && selectedOption2.equals("Bar")) {
            double result = inputVal * 0.0689;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("psi") && selectedOption2.equals("mBar")) {
            double result = inputVal * 68.947;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("psi") && selectedOption2.equals("psi")) {
            double result = inputVal;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("psi") && selectedOption2.equals("kPa")) {
            double result = inputVal * 6.894;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("psi") && selectedOption2.equals("inH2O")) {
            double result = inputVal * 27.6806;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("mBar") && selectedOption2.equals("Bar")) {
            double result = inputVal * 0.001;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("mBar") && selectedOption2.equals("mBar")) {
            double result = inputVal;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("mBar") && selectedOption2.equals("psi")) {
            double result = inputVal * 0.0145;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("mBar") && selectedOption2.equals("kPa")) {
            double result = inputVal * 0.1;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("mBar") && selectedOption2.equals("inH2O")) {
            double result = inputVal * 0.4014;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("kPa") && selectedOption2.equals("Bar")) {
            double result = inputVal * 0.01;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("kPa") && selectedOption2.equals("mBar")) {
            double result = inputVal * 10;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("kPa") && selectedOption2.equals("psi")) {
            double result = inputVal * 0.145;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("kPa") && selectedOption2.equals("kPa")) {
            double result = inputVal;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("kPa") && selectedOption2.equals("inH2O")) {
            double result = inputVal * 4.014;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("inH2O") && selectedOption2.equals("Bar")) {
            double result = inputVal * 0.00249;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("inH2O") && selectedOption2.equals("mBar")) {
            double result = inputVal * 2.4908;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("inH2o") && selectedOption2.equals("psi")) {
            double result = inputVal * 0.03612;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("inH2O") && selectedOption2.equals("kPa")) {
            double result = inputVal * 0.249;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        } else if (selectedOption1.equals("inH2O") && selectedOption2.equals("inH2O")) {
            double result = inputVal;
            String res = decimalFormat.format(result);
            pressshToVal.setText(res);
        }
    }
}















