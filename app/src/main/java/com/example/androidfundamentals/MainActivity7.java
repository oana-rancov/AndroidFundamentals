package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity7 extends AppCompatActivity {
    private static final String TAG = MainActivity7.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        //BACK BUTTON ACTION BAR
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //set color to little icon
        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);
        myFab.setColorFilter(ContextCompat.getColor(this, R.color.orange));
        myFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"FAB click");
            }
        });

    }

    //Asta pentru navigation drawer alea cu 3 puncte-> cand ne cream un menu in action bar
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    } */


}