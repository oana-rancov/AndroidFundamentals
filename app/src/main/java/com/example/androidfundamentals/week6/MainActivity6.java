package com.example.androidfundamentals.week6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.androidfundamentals.R;

public class MainActivity6 extends AppCompatActivity {
    private static final String TAG = MainActivity6.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        //Dynamic Fragment -> container
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, new Fragment6(), Fragment6.class.getSimpleName());
        fragmentTransaction.commit();


        findViewById(R.id.hideFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //se poate folosi si findFragmentById -> atunci cand fragmentul este static
                //Fragment6 fragment6 = (Fragment6)fragmentManager.findFragmentById(R.id.firstFragment);
                Fragment6 fragment6 = (Fragment6)fragmentManager.findFragmentByTag(Fragment6.class.getSimpleName());
                Log.d(TAG, "Is fragment visible: " + fragment6.isHidden());
                fragmentTransaction.hide(fragment6); //face hide la fragment

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