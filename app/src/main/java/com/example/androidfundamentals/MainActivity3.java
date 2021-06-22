package com.example.androidfundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG = MainActivity3.class.getSimpleName();
    private ArrayList<String> dataSource;
    private ArrayAdapter<String> arrayAdapter;
    private String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //luam referintele de la edit text-uri si buton
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.pass);
        Button signIn = findViewById(R.id.login);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "EMAIL= " + email.getText() + "\nPASS= " + password.getText());

                //atentionare cand nu ai completat emailul
                if(email.getText().toString().isEmpty()){
                    email.setError("This field should not be empty!");
                }else{
                    email.setError(null); //ca sa nu mai apara nici semnul rosu
                }

                //atentionare cand nu ai completat parola
                if(password.getText().toString().isEmpty()){
                    password.setError("This field should not be empty!");
                }else{
                    password.setError(null); //ca sa nu mai apara nici semnul rosu
                }
            }
        });


        WebView webView = findViewById(R.id.webView);
        //setam set java script enable
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("https://developer.android.com/");


        //sau pt spinner ca si data source mai putem avea un array de string cu data e array facut local in strings.xml
        data = getResources().getStringArray(R.array.photos);

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(getAdapter()); //setam adapter-ul
        spinner.setOnItemSelectedListener(this); //this-ul e efectiv MainActivity3 care extinde o alta interfata
        //ori
        /*
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){})
         */
    }

    //ne cream o fctie care ne returneaza chapterul
    // si o functie  care ne da ori un array string
    //avem sursa de date unde ii atribuim noi data source
    private ArrayList<String> getDataSource(){
        dataSource = new ArrayList<>();
        dataSource.add("Photos1");
        dataSource.add("Photos2");
        dataSource.add("Photos3");
        dataSource.add("Photos4");
        dataSource.add("Photos5");

        return dataSource;
    }

    private ArrayAdapter<String> getAdapter(){
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, getDataSource()); //si aici putem sa folosim 'data' in loc de getDataSource()
                                                            //in loc de android.R.layout.simple_list_item_1 putem folosi R.layout.spinner_item
        return arrayAdapter;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "Item SELECTED: " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}