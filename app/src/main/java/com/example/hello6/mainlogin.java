package com.example.hello6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class mainlogin extends AppCompatActivity {
    EditText email,password;
    String s;
    RadioGroup radioGrp;
    Button prev_button;
    TextView txt;
    SQLiteDatabase db;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login);
//        name =(EditText) findViewById(R.id.Name);
        email =(EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
//        age =(EditText) findViewById(R.id.age);


        db = openOrCreateDatabase("PassengerDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Passenger(name VARCHAR,email VARCHAR, age INT);");
        prev_button = (Button) findViewById(R.id.button2);
        prev_button.setOnClickListener(v->{
            if(v==prev_button)
            {
                if(email.getText().toString().trim().length()==0 || password.getText().toString().trim().length()==0)
                {
                    showMessage("Error", "Please enter all values");
                    return;
                }
                Cursor c= db.rawQuery("SELECT * FROM Passenger",null);
                s=c.getString(1);

                //showMessage("Success", "You are now logged in");
                showMessage("success",s);
                clearText();
            }
        });

    }


    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText()
    {
        email.setText("");
        password.setText("");
    }
}