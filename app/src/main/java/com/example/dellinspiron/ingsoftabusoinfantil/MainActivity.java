package com.example.dellinspiron.ingsoftabusoinfantil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner opciones;
    Spinner opciones_respuestas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opciones=(Spinner)findViewById(R.id.spinner);
        opciones_respuestas=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.opciones,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_respuestas= ArrayAdapter.createFromResource(this,R.array.opciones,android.R.layout.simple_spinner_item);
        opciones_respuestas.setAdapter(adapter_respuestas);
        opciones.setAdapter(adapter);
    }
}
