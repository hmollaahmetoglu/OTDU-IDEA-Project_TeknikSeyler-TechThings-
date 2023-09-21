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

public class LenghtSh extends AppCompatActivity {
    private ImageButton homebtn;
    private ImageButton backbtn;
    private Spinner lenghtspinner1, lenghtspinner2;
    private TextView lenghtshToVal;
    private EditText lenghtFrmVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenght_sh);

        //home ve back butonlarının bulunması
        homebtn = findViewById(R.id.homeButton);
        backbtn = findViewById(R.id.backButton);

        //home ve back butonlarının tıklamalarının algılanması
        homebtn.setOnClickListener(v -> {
            Intent intent = new Intent(LenghtSh.this, MainActivity.class);
            startActivity(intent);
        });

        backbtn.setOnClickListener(v -> {
            Intent intent = new Intent(LenghtSh.this, ConverterSelectSh.class);
            startActivity(intent);
        });

        // Spinner lar, TextView ve EditView in bulunması
        lenghtspinner1 = findViewById(R.id.lenghtspinner1);
        lenghtspinner2 = findViewById(R.id.lenghtspinner2);
        lenghtshToVal = findViewById(R.id.lenghtshToVal);
        lenghtFrmVal = findViewById(R.id.lenghtFrmVal);

        //Spinner'ların içeriğinin string.xml kaynaklarından alınması
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.lenghtspinner1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lenghtspinner1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.lenghtspinner2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lenghtspinner2.setAdapter(adapter2);

        //Spinner seçimi yapıldığında hesaplama fonksiyonunu çağırmak için kullanılan yapı
        AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculateResult();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        lenghtspinner1.setOnItemSelectedListener(spinnerListener);
        lenghtspinner2.setOnItemSelectedListener(spinnerListener);

        //Kullanıcının inputu güncellediğinde hesaplamaların yeniden başlaması için dinleyici
        lenghtFrmVal.addTextChangedListener(new TextWatcher() {
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
        String selectedOption1 = lenghtspinner1.getSelectedItem().toString();
        String selectedOption2 = lenghtspinner2.getSelectedItem().toString();
        Double inputVal = 0.0; // ilk değerin atanması
        DecimalFormat decimalFormat = new DecimalFormat("#.#####"); // Noktadan sonra 3 hane ile sınırlandırma için kullanıldı.

        // Hatalı bir giriş yapılmasına karşı önlem ve uyarı
        try {
            String userInputStr = lenghtFrmVal.getText().toString(); // girilen değerin hesaplamalarda kullanılabilmesi için gerekli double çevrimi
            inputVal = Double.parseDouble(userInputStr);
        } catch (NumberFormatException e) {
            Toast.makeText(LenghtSh.this, "Lütfen Geçerli Bir Sayı Girin", Toast.LENGTH_SHORT).show();
        }

        //Spinner pozisyonlarına göre hangi Hesaplama yönteminin kullanılacağının bulunması ve sonucun üretilerek çıktının verilmesi

        //metreden diğerlerine
        if (selectedOption1.equals("m") && selectedOption2.equals("m")) {
            double result = inputVal;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("m") && selectedOption2.equals("km")) {
            double result = inputVal * 0.001;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("m") && selectedOption2.equals("cm")) {
            double result = inputVal * 100;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("m") && selectedOption2.equals("mm")) {
            double result = inputVal * 1000;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("m") && selectedOption2.equals("mile")) {
            double result = inputVal * 0.0006214;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("m") && selectedOption2.equals("yard")) {
            double result = inputVal * 1.094;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("m") && selectedOption2.equals("ft")) {
            double result = inputVal * 3.281;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("m") && selectedOption2.equals("in")) {
            double result = inputVal * 39.37;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }

        //km den diğerlerine
        if (selectedOption1.equals("km") && selectedOption2.equals("km")) {
            double result = inputVal;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("km") && selectedOption2.equals("m")) {
            double result = inputVal * 1000;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("km") && selectedOption2.equals("cm")) {
            double result = inputVal * 100000;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }if (selectedOption1.equals("km") && selectedOption2.equals("mm")) {
            double result = inputVal * 1000000;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("km") && selectedOption2.equals("mile")) {
            double result = inputVal * 0.6214;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("km") && selectedOption2.equals("yard")) {
            double result = inputVal * 1094;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("km") && selectedOption2.equals("ft")) {
            double result = inputVal * 3281;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("km") && selectedOption2.equals("in")) {
            double result = inputVal * 39370;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }

        //cm den diğerlerine
        if (selectedOption1.equals("cm") && selectedOption2.equals("cm")) {
            double result = inputVal;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("cm") && selectedOption2.equals("km")) {
            double result = inputVal * 0.00001;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("cm") && selectedOption2.equals("m")) {
            double result = inputVal * 0.01;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("cm") && selectedOption2.equals("mm")) {
            double result = inputVal * 10;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }if (selectedOption1.equals("cm") && selectedOption2.equals("mile")) {
            double result = inputVal * 0.000006214;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("cm") && selectedOption2.equals("yard")) {
            double result = inputVal * 0.01094;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("cm") && selectedOption2.equals("ft")) {
            double result = inputVal * 0.03281;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("cm") && selectedOption2.equals("in")) {
            double result = inputVal * 0.3937;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }

        //mm den diğerlerine
        if (selectedOption1.equals("mm") && selectedOption2.equals("mm")) {
            double result = inputVal;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("mm") && selectedOption2.equals("km")) {
            double result = inputVal * 0.000001;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("mm") && selectedOption2.equals("m")) {
            double result = inputVal * 0.001;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }if (selectedOption1.equals("mm") && selectedOption2.equals("cm")) {
            double result = inputVal * 0.1;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("mm") && selectedOption2.equals("mile")) {
            double result = inputVal * 0.0000001;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }if (selectedOption1.equals("mm") && selectedOption2.equals("yard")) {
            double result = inputVal * 0.001094;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }if (selectedOption1.equals("mm") && selectedOption2.equals("ft")) {
            double result = inputVal * 0.00328;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }if (selectedOption1.equals("mm") && selectedOption2.equals("in")) {
            double result = inputVal * 0.3937;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }

        //mile den diğerlerine
        if (selectedOption1.equals("mile") && selectedOption2.equals("mile")) {
            double result = inputVal;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("mile") && selectedOption2.equals("km")) {
            double result = inputVal * 1.609;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("mile") && selectedOption2.equals("m")) {
            double result = inputVal * 1609;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("mile") && selectedOption2.equals("cm")) {
            double result = inputVal * 160900;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("mile") && selectedOption2.equals("mm")) {
            double result = inputVal * 1609000;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("mile") && selectedOption2.equals("yard")) {
            double result = inputVal * 1760;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("mile") && selectedOption2.equals("ft")) {
            double result = inputVal * 5280;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("mile") && selectedOption2.equals("in")) {
            double result = inputVal * 63360;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }

        //yard dan diğerlerine
        if (selectedOption1.equals("yard") && selectedOption2.equals("yard")) {
            double result = inputVal;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("yard") && selectedOption2.equals("km")) {
            double result = inputVal * 0.0063;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("yard") && selectedOption2.equals("m")) {
            double result = inputVal * 0.9144;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("yard") && selectedOption2.equals("cm")) {
            double result = inputVal * 91.44;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("yard") && selectedOption2.equals("mm")) {
            double result = inputVal * 914.4;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("yard") && selectedOption2.equals("mile")) {
            double result = inputVal * 0.0005682;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("yard") && selectedOption2.equals("ft")) {
            double result = inputVal * 3;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("yard") && selectedOption2.equals("in")) {
            double result = inputVal * 36;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }

        //ft den diğerlerine
        if (selectedOption1.equals("ft") && selectedOption2.equals("ft")) {
            double result = inputVal;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("ft") && selectedOption2.equals("km")) {
            double result = inputVal * 0.0003048;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("ft") && selectedOption2.equals("m")) {
            double result = inputVal * 0.3048;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("ft") && selectedOption2.equals("cm")) {
            double result = inputVal * 30.48;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("ft") && selectedOption2.equals("mm")) {
            double result = inputVal * 304.80;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("ft") && selectedOption2.equals("mile")) {
            double result = inputVal * 0.0001894;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("ft") && selectedOption2.equals("yard")) {
            double result = inputVal * 0.3333;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("ft") && selectedOption2.equals("in")) {
            double result = inputVal * 12;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }

        //in den diğerlerine
        if (selectedOption1.equals("in") && selectedOption2.equals("in")) {
            double result = inputVal;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("in") && selectedOption2.equals("km")) {
            double result = inputVal * 0.00002835;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("in") && selectedOption2.equals("m")) {
            double result = inputVal * 0.0254;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("in") && selectedOption2.equals("cm")) {
            double result = inputVal * 2.54;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("in") && selectedOption2.equals("mm")) {
            double result = inputVal * 25.40;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("in") && selectedOption2.equals("mile")) {
            double result = inputVal * 0.00001578;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("in") && selectedOption2.equals("yard")) {
            double result = inputVal * 0.0278;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
        if (selectedOption1.equals("in") && selectedOption2.equals("ft")) {
            double result = inputVal * 0.0833;
            String res = decimalFormat.format(result); // Bu yöntemi String e çevirme ve noktadan sonra 3 hane ile sınırlandırmak için kullandım
            lenghtshToVal.setText(res);
        }
    }
}