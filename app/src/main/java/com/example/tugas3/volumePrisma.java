package com.example.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class volumePrisma extends AppCompatActivity implements View.OnClickListener {
    private EditText edtText,edtPanjang,edtLebar,edtTinggi;
    private Button btnCalculattt;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_prisma);

        edtPanjang = findViewById(R.id.edt_Panjang);
        edtLebar = findViewById(R.id.edt_Lebar);
        edtTinggi = findViewById(R.id.edt_Tinggi);
        btnCalculattt = findViewById(R.id.btn_calculatt);
        tvResult = findViewById(R.id.tv_resultt);



        btnCalculattt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() ==  R.id.btn_calculatt){
            String inputPanjang = edtPanjang.getText().toString().trim();
            String inputLebar = edtLebar.getText().toString().trim();
            String inputTinggi = edtTinggi.getText().toString().trim();

            boolean isEmptyFields = false;
            boolean isInvalidDouble = false;

            if (TextUtils.isEmpty(inputPanjang)){
                isEmptyFields = true;
                edtPanjang.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputLebar)){
                isEmptyFields = true;
                edtLebar.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputTinggi)){
                isEmptyFields = true;
                edtTinggi.setError("Field ini tidak boleh kosong");
            }


            Double panjang = toDouble(inputPanjang);
            Double lebar = toDouble(inputLebar);
            Double tinggi = toDouble(inputTinggi);


            if (panjang == null){
                isInvalidDouble = true;
                edtPanjang.setError("field ini harus berupa nomor yang valid");
            }

            if (lebar == null){
                isInvalidDouble = true;
                edtLebar.setError("field ini harus berupa nomor yang valid");
            }
            if (tinggi == null){
                isInvalidDouble = true;
                edtTinggi.setError("field ini harus berupa nomor yang valid");
            }



            if (!isEmptyFields && !isInvalidDouble){
                double llluas = 2/panjang*lebar*tinggi ;
                Intent intent = new Intent();
                intent.setData(Uri.parse(String.valueOf(llluas)));
                setResult(RESULT_OK,intent);
                finish();
            }


        }
    }
    private Double toDouble(String str){
        try {
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }

}
