package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"This is a bug!!");

        //luare instanta in activity
        //findViewById se duce pe arbore si se duce si cauta dupa arbore fiecare id
        TextView tvTitle1 = (TextView) findViewById(R.id.tvTitle1);
        tvTitle1.setText("This is the new string title");

        TextView tvTitle2 = (TextView) findViewById(R.id.tvTitle2);

        ImageView ivImage = (ImageView) findViewById(R.id.ivImage);
        //chiar daca am setat o alta imagine in xml, imaginea de aici va fi afisata, pt ca am setat-o din cod
        ivImage.setImageResource(R.drawable.ic_launcher_foreground);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);


        /*
        Schimbarile pe care le facem in cod suprascriu schimbarile din layout
         */

        Button button = (Button) findViewById(R.id.button);
        button.setVisibility(View.VISIBLE); //sau gone sau invisible

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Button click!!");

                seekBar.setProgress(40);
                progressBar.setVisibility(View.GONE);
            }
        });


        EditText username = (EditText) findViewById(R.id.etUsername);
        EditText password = (EditText) findViewById(R.id.etPassword);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "username beforeTextChanged " + s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "username onTextChanged " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "username afterTextChanged " + s);
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "password beforeTextChanged " + s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "password onTextChanged " + s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "password afterTextChanged " + s);
            }
        });

        ((CheckBox) findViewById(R.id.checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged(), isChecked=  " + isChecked);

                if(isChecked){
                    username.setVisibility(View.GONE);
                    password.setVisibility(View.GONE);
                }else{
                    username.setVisibility(View.VISIBLE);
                    password.setVisibility(View.VISIBLE);
                }
            }
        });


        ((RadioGroup) findViewById(R.id.radioGroup)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Log.d(TAG, "onCheckedChanged() " + radioButton.getText().toString());
            }
        });

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setRating(1); //am setat sa fie o steluta initial
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d(TAG, "onRatingChanged(), rating=  " + rating);
            }
        });


        ((Switch) findViewById(R.id.notifications)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged(), isChecked= " + isChecked);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG, "onProgressChanged(), progress " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStartTrackingTouch()" );
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStopTrackingTouch()");
            }
        });

        SearchView searchView = (SearchView) findViewById(R.id.searchView);


    }
}