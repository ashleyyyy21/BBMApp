package com.bbmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bbmRegister extends AppCompatActivity {
    EditText Name,email,phoneNumber,mailingAddress,username,password,reenterpassword;
    Button register;
    TextView btn;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbm_register);
        Name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phoneNumber);
        mailingAddress = findViewById(R.id.mailingAddress);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        reenterpassword = findViewById(R.id.reenterpassword);


        register = findViewById(R.id.button);
        btn = findViewById(R.id.btn);

        button = (Button) findViewById(R.id.button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,mail,number,address,user,pass,repass;

                name = Name.getText().toString();
                mail = email.getText().toString();
                number = phoneNumber.getText().toString();
                address = mailingAddress.getText().toString();
                user = username.getText().toString();
                pass = password.getText().toString();
                repass = reenterpassword.getText().toString();


                if (name.equals("")){
                    Toast.makeText(bbmRegister.this,"Name is Blank", Toast.LENGTH_SHORT).show();
                }
                else if (email.equals("")){
                    Toast.makeText(bbmRegister.this,"Email is Blank", Toast.LENGTH_LONG).show();
                }
                else if (number.equals("")){
                    Toast.makeText(bbmRegister.this,"Phone Number is Blank", Toast.LENGTH_LONG).show();
                }
                else if (address.equals("")){
                    Toast.makeText(bbmRegister.this,"Mailing Address is Blank", Toast.LENGTH_LONG).show();
                }
                else if (user.equals("")){
                    Toast.makeText(bbmRegister.this,"Username is Blank", Toast.LENGTH_LONG).show();
                }
                else if (pass.equals("")){
                    Toast.makeText(bbmRegister.this,"Password is Blank", Toast.LENGTH_LONG).show();
                }
                else if (repass.equals("")){
                    Toast.makeText(bbmRegister.this,"Re-enter Password is Blank", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent R = new Intent(bbmRegister.this, MainActivity.class);
                startActivity(R);
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bbmRegister.this, post.class);
                startActivity(intent);
            }
        });
    }
}
