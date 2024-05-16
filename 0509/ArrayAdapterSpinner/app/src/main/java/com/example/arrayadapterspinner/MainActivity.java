package com.example.arrayadapterspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner drink, temp;
    private TextView txv;
    private String[] tempSet1 = {"冰" ,"去冰","溫"}; // 一種溫度
    private String[] tempSet2 ={"冰","去冰"};// 兩種溫度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = (TextView) findViewById(R.id.order);
        temp = (Spinner) findViewById(R.id.temp);

        drink =(Spinner) findViewById(R.id.drink);
        drink.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] tempSet;
                if(position == 3)
                    tempSet = tempSet2;
                else
                    tempSet = tempSet1;

                ArrayAdapter<String> tempAd =
                        new ArrayAdapter<>(MainActivity.this,
                                android.R.layout.simple_spinner_item,
                                tempSet);  // 溫度選項
                tempAd.setDropDownViewResource(  //設定下拉選單的選像樣式
                        android.R.layout.simple_spinner_dropdown_item);
                temp.setAdapter(tempAd); //設定使用Adopter 物件
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button order = (Button) findViewById(R.id.btnOrder);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txv.setText(("飲料為: " + drink.getSelectedItem().toString()) +
                        "\n冰塊為: " + temp.getSelectedItem().toString());
            }
        });
    }
}