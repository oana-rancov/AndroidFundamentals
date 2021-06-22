package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {
    private static final String TAG = MainActivity3.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //luam referintele de la edit text-uri si buton
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.pass);
        Button signIn = findViewById(R.id.login);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "EMAIL= " + email.getText() + "\nPASS= " + password.getText());

                //atentionare cand nu ai completat emailul
                if(email.getText().toString().isEmpty()){
                    email.setError("This field should not be empty!");
                }else{
                    email.setError(null); //ca sa nu mai apara nici semnul rosu
                }

                //atentionare cand nu ai completat parola
                if(password.getText().toString().isEmpty()){
                    password.setError("This field should not be empty!");
                }else{
                    password.setError(null); //ca sa nu mai apara nici semnul rosu
                }
            }
        });

    }
}