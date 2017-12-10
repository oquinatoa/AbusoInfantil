package com.example.dellinspiron.ingsoftabusoinfantil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.time.Instant;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner opciones;
    Spinner opciones_respuestas;
    Button btn_crear;
    EditText txt_nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //llenar el spinner con la lista de preguntas
        opciones=(Spinner)findViewById(R.id.spinner_preguntas);
        ArrayList<String> lista=crearListaPreguntas(5);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,lista);
        opciones.setAdapter(adapter);
        //llenar el spinner con la lista de respuestas
        opciones_respuestas=(Spinner)findViewById(R.id.spinner_respuestas);
        ArrayList<String> listarespuestas=crearListaPreguntas(5);
        ArrayAdapter<String> adapterrespuestas=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,listarespuestas);
        opciones_respuestas.setAdapter(adapterrespuestas);
        //inicializar edittext
        txt_nombre=(EditText)findViewById(R.id.txt_nombre);
        //botones
        btn_crear=(Button)findViewById(R.id.btn_crear);
        btn_crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String datos=txt_nombre.getText()+"-"+opciones.getSelectedItem()+"-"+opciones_respuestas.getSelectedItem();
               // Toast.makeText(getApplicationContext(),datos,Toast.LENGTH_LONG).show();
                Intent i=new Intent(MainActivity.this,VingresoPreguntas.class);

                i.putExtra("txt_nombre_cuestionario",txt_nombre.getText()+"");
                i.putExtra("num_preguntas",opciones.getSelectedItem().toString()+"");
                i.putExtra("num_respuestas",opciones_respuestas.getSelectedItem().toString()+"");
                startActivity(i);
            }
        });


    }
    public ArrayList<String> crearListaPreguntas(int num){
        ArrayList<String> lista=new ArrayList<>();
        for(int i=1;i<=num;i++){
            lista.add(i+"");
        }
        return lista;

    }
}
