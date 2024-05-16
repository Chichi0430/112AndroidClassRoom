package com.example.alertdialongdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAbout = (Button) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener( v -> {
            new AlertDialog.Builder(this)
                    .setTitle("關於這本書")
                    .setMessage("Android程式設計與應用\n作者：陳會安\n教師：恰克虎")
                    .setCancelable(true)
                    .setPositiveButton("確定",null)
                    .show();
        });
    }
}