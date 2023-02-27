package com.example.hello6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b= findViewById(R.id.button5);
        txt = findViewById(R.id.textview);
        b.setOnClickListener(v-> {
            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);
        });

    }

    @Override
    public void onClick(View view){
      txt.setText("Hey There");
    }




}