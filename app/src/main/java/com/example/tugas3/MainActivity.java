package com.example.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int req_code = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button luasPrima = findViewById(R.id.lup);
        Button volumePrisma = findViewById(R.id.vlp);

        luasPrima.setOnClickListener(this);
        volumePrisma.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lup:
                Intent luas_Prisma =new Intent(MainActivity.this,luasPrisma.class);
                startActivityForResult(luas_Prisma, req_code);
                break;
            case R.id.vlp:
                Intent volume_Prisma =new Intent(MainActivity.this,volumePrisma.class);
                startActivityForResult(volume_Prisma, req_code);
                break;


        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == req_code && resultCode == RESULT_OK){
                TextView hasil = findViewById(R.id.view);
                hasil.setText(data.getData().toString());
        }
    }
}
