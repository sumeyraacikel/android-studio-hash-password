package com.example.hashpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class MainActivity extends AppCompatActivity {

    EditText et_username,
            et_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                if (username.isEmpty() || password.isEmpty()){
                    Toast.makeText(view.getContext(),  "Data", Toast.LENGTH_SHORT).show();

                } else {
                    String hashPassword = "4gxcjkl";
                    String bcryptHashString = BCrypt.withDefaults().hashToString(12, hashPassword.toCharArray());

                    BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
                    if (result.verified){
                        Toast.makeText(view.getContext(),  "Password", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(view.getContext(),  "Passworda", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}