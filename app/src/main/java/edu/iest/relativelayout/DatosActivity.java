package edu.iest.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras!= null) {
                int canal = extras.getInt("canal");
                String programa = extras.getString("programa");
            }
        }


    }
}