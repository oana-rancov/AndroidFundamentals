package com.example.androidfundamentals.week6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.androidfundamentals.R;

public class MainActivity6 extends AppCompatActivity implements SetTextListener{
    private static final String TAG = MainActivity6.class.getSimpleName();
    //public ca sa il putem accesa in Fragment6
    static final String KEY = "Key"; //key for bundle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        Log.d(TAG, "onCreate()");

        //vom trimite o informatie dintr-o activitate intr-un fragment
        //BUNDLE COMMUNICATION
        Bundle bundle = new Bundle();
        bundle.putString(KEY, "Hello Fragment");


        //Dynamic Fragment -> container
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.replace(R.id.fragmentContainer, new Fragment6(), Fragment6.class.getSimpleName());
        Fragment6 fragment6 = new Fragment6();
        fragment6.setArguments(bundle); //for bundle -> trimitem date
        fragmentTransaction.replace(R.id.fragmentContainer, fragment6, Fragment6.class.getSimpleName());

        //search for a fragment by ID (static frgm) or by TAG (dynamic frgm)
        Fragment6 staticFragment = (Fragment6) fragmentManager.findFragmentById(R.id.firstFragment);
        Fragment6 dynamicFragment = (Fragment6) fragmentManager.findFragmentByTag(Fragment6.class.getSimpleName());
        fragmentTransaction.commit();


        findViewById(R.id.hideFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Is fragment visible: " + staticFragment.isHidden());

                //fragmentTransaction.hide(staticFragment); //face hide la fragment
                //fragmentTransaction.commit(); //se da commit la final, cand nu mai ai nimic de facut

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

        //METHOD COMMUNICATION
        Fragment6 fragment6 = (Fragment6) getSupportFragmentManager().findFragmentById(R.id.firstFragment);
        fragment6.setText("Hello user");
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

    //metoda din interfata SetTextListener
    //trimitem un text din fragment in activitate
    @Override
    public void setText(String text) {
        Log.d(TAG, "setText(" + text + ")");
    }

    //BACK BUTTON
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d(TAG, "onBackPressed()");
    }
}