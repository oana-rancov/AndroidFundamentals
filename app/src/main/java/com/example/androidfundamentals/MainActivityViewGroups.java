package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityViewGroups extends AppCompatActivity {
    private static final String TAG = MainActivityViewGroups.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view_groups);

        EditText email = findViewById(R.id.etEmail);
        EditText phone = findViewById(R.id.etPhone);
        Button submit = findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "EMAIL= " + email.getText() + "\nPHONE= " + phone.getText());

                if(email.getText().toString().isEmpty()){
                    email.setError("Fill the input with a valid email address");
                }else{
                    email.setError(null);
                }
            }
        });
    }
}