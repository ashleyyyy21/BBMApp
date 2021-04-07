package com.bbmapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    EditText email,password;
    Button login;
    TextView btnr;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        login = findViewById(R.id.button);
        btnr = findViewById(R.id.btnr);

        button = (Button) findViewById(R.id.button);
        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, bbmRegister.class);
                startActivity(i);
                finish();

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String mail, pass;

                mail = email.getText().toString();
                pass = password.getText().toString();
                loginUser(mail,pass);

            }
        });

    }

    private void loginUser(String mail, String pass) {
        Log.i(TAG, "Attempting to login user " + mail);
        ParseUser.logInInBackground(mail, pass, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with login", e);
                    Toast.makeText(MainActivity.this, "Issue with login", Toast.LENGTH_SHORT).show();
                    return;
                }
                goMainActivity();
                Toast.makeText(MainActivity.this, "Success!", Toast.LENGTH_SHORT).show();
            }

            private void goMainActivity() {
                Intent i = new Intent(MainActivity.this, bbmAccountActivity.class);
                startActivity(i);
                finish();

            }

        });
    }

}