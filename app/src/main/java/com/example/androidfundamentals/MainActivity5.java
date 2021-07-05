package com.example.androidfundamentals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

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
}