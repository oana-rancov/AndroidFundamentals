package com.example.androidfundamentals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
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
    private static final int REQ_CAMERA_CODE = 1;

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

        //PERMISSION FOR CAMERA
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //daca s-a cerut permisiunea de camera
                if(ContextCompat.checkSelfPermission(MainActivity7.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    //daca permisiunea nu a fost granted, se face request la acea permisiune
                    ActivityCompat.requestPermissions(MainActivity7.this, new String[]{Manifest.permission.CAMERA}, REQ_CAMERA_CODE);
                }
            }
        });

    }

    //override for permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult() requestCode= " + requestCode);
        if(requestCode == REQ_CAMERA_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Log.d(TAG, "onRequestPermissionsResult() permission granted");
            }
            else{
                Log.d(TAG, "onRequestPermissionsResult() permission NOT granted");
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
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