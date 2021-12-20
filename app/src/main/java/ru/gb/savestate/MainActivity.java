package ru.gb.savestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String MILLIS = "MILLIS";
    public static final String STRMILLIS = "STRMILLIS";

    private long millis;
    private String strMillis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if(savedInstanceState != null)
        {
            millis = savedInstanceState.getLong(MILLIS);
            strMillis = savedInstanceState.getString(STRMILLIS);
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(STRMILLIS, strMillis);
        outState.putLong(MILLIS, millis);
    }

    public void showMillis(View view) {
        Log.d("happy", "strMillis: " + strMillis );
        Log.d("happy", "millis: " + millis );
    }

    public void changeMillis(View view) {
        millis = System.currentTimeMillis();
        strMillis = "" + millis + ":" + millis;
    }
}