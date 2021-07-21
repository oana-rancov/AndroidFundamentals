package com.example.androidfundamentals.week9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidfundamentals.R;

public class SharedPrefActivity extends AppCompatActivity {
    private static final String TAG = SharedPrefActivity.class.getSimpleName();

    private static final String USER_LOCAL_STORE = "user_local_store"; //key -> numele fis xml
    private static final String USER_NAME = "user_name"; //key
    private static final String USER_SURNAME = "user_surname"; //key
    private EditText name;
    private EditText surname;
    private TextView nameSurname;

    private String userName;
    private String userSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);

        nameSurname = findViewById(R.id.name_surname);
        nameSurname.setText(userName + userSurname);


        Log.d(TAG, getUserNameSurNameFromSharedPref());
        nameSurname.setText(getUserNameSurNameFromSharedPref()); //get from file name and surname

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        surname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userSurname = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void onPause() {
        saveUserNameInSharedPref();

        saveUserSurnameInSharedPref();

        super.onPause();
    }

    //pt ca userName e o variabila globala, nu trebuie dat ca parametru metodei
    private void saveUserNameInSharedPref(){
        SharedPreferences sharedPreferences = this.getSharedPreferences(USER_LOCAL_STORE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME, userName);
        editor.apply();
    }

    private void saveUserSurnameInSharedPref(){
        SharedPreferences sharedPreferences = this.getSharedPreferences(USER_LOCAL_STORE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_SURNAME, userSurname);
        editor.apply();
    }

    private String getUserNameSurNameFromSharedPref(){
        SharedPreferences sharedPreferences = this.getSharedPreferences(USER_LOCAL_STORE, MODE_PRIVATE);

        return sharedPreferences.getString(USER_NAME, "") + " "
                + sharedPreferences.getString(USER_SURNAME, "");
    }
}