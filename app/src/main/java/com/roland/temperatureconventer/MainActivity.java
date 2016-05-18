package com.roland.temperatureconventer;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    EditText input;
    Button clear, hitung;
    Spinner spinner;
    TextView hasil;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
        clear = (Button) findViewById(R.id.clear);
        hitung = (Button) findViewById(R.id.hitung);
        spinner = (Spinner) findViewById(R.id.spinner);
        hasil = (TextView) findViewById(R.id.hasil);
        clear.setOnClickListener(this);
        hitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clear:
                input.setText("");
                hasil.setText("");
                break;
            case R.id.hitung:
                String text = input.getText().toString();
                if (text.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Suhu Awal Masih Kosong", Toast.LENGTH_SHORT).show();
                } else {
                    double suhu = Double.parseDouble(text);
                    int posisi = spinner.getSelectedItemPosition();
                    switch (posisi) {
                        case 0:
                            result = 4.0 / 5.0 * suhu;
                            break;
                        case 1:
                            result = (9.0 / 5.0) * suhu + 32;
                            break;
                        case 2:
                            result = suhu + 273;
                            break;
                        case 3:
                            result = 5.0 / 4.0 * suhu;
                            break;
                        case 4:
                            result = 9.0 / 4.0 * suhu + 32;
                            break;
                        case 5:
                            result = 5.0 / 4.0 * suhu + 273;
                            break;
                        case 6:
                            result = 5.0 / 9.0 * (suhu - 32);
                            break;
                        case 7:
                            result = 4.0 / 9.0 * (suhu - 32);
                            break;
                        case 8:
                            result = 5.0 / 9.0 * (suhu - 32) + 273;
                            break;
                        case 9:
                            result = suhu - 273;
                            break;
                        case 10:
                            result = 4.0 / 5.0 * (suhu - 273);
                            break;
                        case 11:
                            result = 9.0 / 5.0 * (suhu - 273) + 32;
                            break;
                    }

                    hasil.setText("Hasil Konversi : " + result);
                }
                break;
        }

    }

}