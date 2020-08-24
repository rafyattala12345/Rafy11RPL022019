package com.example.trial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    EditText    usernameet;
    EditText    passwordet;
    Button      loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        pref = getSharedPreferences("login", MODE_PRIVATE);
        usernameet = (EditText)findViewById(R.id.usernameet);
        passwordet = (EditText)findViewById(R.id.passwordet);
        loginbtn = (Button)findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usernameet.getText().toString().equalsIgnoreCase("admin")
                        && passwordet.getText().toString().equalsIgnoreCase("admin")) {
                    Toast.makeText(MainActivity.this,"thankyou for login", Toast.LENGTH_SHORT).show();

                    editor = pref.edit();
                    editor.putString("username", usernameet.getText().toString());
                    editor.putString("status", "login");
                    editor.apply();

                    startActivity(new Intent(getApplicationContext(), MainMenu.class));
                    finish();
                }

                if (usernameet.getText().toString().isEmpty() && usernameet.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this,"fill the login to continue!", Toast.LENGTH_SHORT).show();
                }else if (usernameet.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "wrong username!", Toast.LENGTH_SHORT).show();
                }else if (passwordet.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "wrong password!", Toast.LENGTH_SHORT).show();
                }   else {
                    Toast.makeText(MainActivity.this, "please try again!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}