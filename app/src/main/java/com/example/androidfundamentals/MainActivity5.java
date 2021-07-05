package com.example.androidfundamentals;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity5 extends AppCompatActivity {
    private final static String TAG = MainActivity5.class.getSimpleName();
    private TextView username;
    private EditText lastname;
    private EditText firstname;

    private String userLastname;
    private String userFirstname;

    //ca si un map-> le atribuim dupa key-value
    private static final String LAST_NAME = "lastname";
    private static final String FIRST_NAME = "firstname";

    //cheie pt explicit intent
    static final String MESSAGE = "message";

    //for activity for result
    private final static int REQ_CODE_SECOND_ACTIVITY = 8;

    //LifeCycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        Log.d(TAG, "onCreate(), savedInstanceState = " + savedInstanceState);//prima data cand activ se creeaza e nula

        username = (TextView)findViewById(R.id.username);
        lastname = (EditText) findViewById(R.id.lastName);
        firstname = (EditText) findViewById(R.id.firstName);

        if(savedInstanceState != null){
            String lastname = savedInstanceState.getString(LAST_NAME);
            String firstname = savedInstanceState.getString(FIRST_NAME);
            String userName = lastname + " " + firstname;

            username.setText(userName); //la textView i-am setat numele pe care i l-am intors
        }



        lastname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userLastname = s.toString(); //assign the value that the user wrote in the editText field to a global var userLastname
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        firstname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userFirstname = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        findViewById(R.id.openBrowser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN BROWSER USING IMPLICIT INTENT

                Intent intent = new Intent(Intent.ACTION_VIEW); //ca sa deschidem browser-ul
                if(intent.resolveActivity(getPackageManager()) != null) {
                    intent.setData(Uri.parse("http://developer.android.com/guide/components/intents-common"));
                    startActivity(intent);
                }


//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                Log.d(TAG, "Resolve Activity" + intent.resolveActivity(getPackageManager()));
//                if(intent.resolveActivity(getPackageManager()) != null){ //ar fi crapat aplicatia fara asta
//                    intent.setData(Uri.parse("023456"));
//                    startActivity(intent);
//                }
            }
        });


        //EXPLICIT INTENT
        /* Going from one activity to another through a button and display a message*/
        findViewById(R.id.startSecondActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN SECOND ACTIVITY AND SET A MESSAGE USING EXPLICIT INTENT
                Intent intent = new Intent(MainActivity5.this, SecondMainActivity5.class);
                //intent.putExtra(MESSAGE, "Hello from first Activity");
                Person5 person = new Person5("Oana", "21");
                intent.putExtra(MESSAGE, person);
                startActivity(intent);
            }
        });


        //ACTIVITY FOR RESULT
        findViewById(R.id.startSecondActivityForResult).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, SecondMainActivity5.class);
                setResult(REQ_CODE_SECOND_ACTIVITY);
                startActivityForResult(intent, REQ_CODE_SECOND_ACTIVITY);
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

    /*am rotit ecranul si avem mai multe campuri
    user-ul incepe sa completeze toate campurile si dintr-o data a rotit ecranul
    si si-a pierdut toate datele
    EditText-ul stie sa isi tina campurile
    Asta se intampla doar la configuration changes -> cand rotate the screen*/
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(LAST_NAME, userLastname);//salvam valorile resp intr-un bundle
        outState.putString(FIRST_NAME, userFirstname);
        super.onSaveInstanceState(outState);
    }

    //FOR ACTIVITY RESULT
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(TAG, "onActivityResult()");
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE_SECOND_ACTIVITY){
            if(resultCode == Activity.RESULT_OK){
                if(data != null){
                    String message = data.getStringExtra(SecondMainActivity5.SECOND_MESSAGE); //primim mesaj din a doua activitate
                    username.setText(message); //setam mesajul pe TextView username
                }
            }else if(resultCode == Activity.RESULT_CANCELED){
                username.setText("Request failed"); //setam mesajul pe TextView username

            }

        }


    }
}