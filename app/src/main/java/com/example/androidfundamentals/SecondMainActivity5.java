package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondMainActivity5 extends AppCompatActivity {
    private final static String TAG = SecondMainActivity5.class.getSimpleName();
    final static String SECOND_MESSAGE = "second_message"; //public ca sa il putem accesa in prima activitate


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main5);

        Log.d(TAG, "onCreate()");


        //luam mesajul de pe cealalta activitate
        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            //String message = bundle.getString(MainActivity5.MESSAGE); //asta poate sa crape pt ca bundle-ul poate sa fie null fara if
            //((TextView)findViewById(R.id.message)).setText(message); //am setat msj pe textview de la activitate

            //sau cu person
            Person5 person = (Person5) bundle.getSerializable(MainActivity5.MESSAGE);
            String name = person.name;
            ((TextView)findViewById(R.id.message)).setText(name);

        }

        //revenim la prima activitate
        Button closeActivity = findViewById(R.id.closeSecondActivity);
        closeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //revenim la a doua activitate dupa Activity For Result
        Button closeActivityForResult = findViewById(R.id.closeSecondActivityForResult);
        closeActivityForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(SECOND_MESSAGE, "Hello from second activity!");
                setResult(Activity.RESULT_OK, intent); //aici setam ce result vrem
                finish();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy()");
    }
}