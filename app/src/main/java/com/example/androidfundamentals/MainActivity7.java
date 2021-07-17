package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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
        Button button = (Button) findViewById(R.id.animButton);
        TextView textViewAnim = (TextView) findViewById(R.id.textViewAnim);

        //start animation
        AnimationDrawable animationDrawable = (AnimationDrawable) textViewAnim.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);

        myFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"FAB click");
                //SNACKBAR
                Snackbar snackbar = Snackbar.make(v, "Hello this is a snackBar", Snackbar.LENGTH_LONG);
                snackbar.setAction("Retry", new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        //when we click on "Retry on FAB, the color of the textview starts to change"
                        animationDrawable.start();
                    }
                });
                //change color text from snckbar
                View snackbarView = snackbar.getView();
                snackbar.setBackgroundTint(ContextCompat.getColor(v.getContext(), R.color.purple_500)); //change color of the whole snackbar
                TextView textView1 = snackbarView.findViewById(R.id.snackbar_text);
                textView1.setTextColor(ContextCompat.getColor(v.getContext(), R.color.orange));

                snackbar.show();
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