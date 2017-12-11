package com.example.dellinspiron.ingsoftabusoinfantil;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class VingresoRespuestas extends AppCompatActivity {
    LinearLayout contenedor;
    TextView nombreCuestionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vingreso_respuestas);
        nombreCuestionario=(TextView)findViewById(R.id.txt_nombre);

        contenedor=(LinearLayout)findViewById(R.id.contenedor);

        recibirDatos();

    }
    public void recibirDatos(){
        Bundle data=getIntent().getExtras();
        String nombre_cuestionario=data.getString("txt_nombre_cuestionario");

        int num_respuestas=Integer.parseInt(data.getString("num_respuestas"));
        ArrayList<String> datos=data.getStringArrayList("arreglo");
        //enviar datos
        nombreCuestionario.setText(nombre_cuestionario);
        int i=1;
        for(String da:datos){
            int id=i*10;
            for(int j=id;j<=num_respuestas+id;j++){

            }
            generarTextView(da,i);
            i++;
        }

    }

    public void generarTextView(String dato,int id){
        TextView texto=new TextView(getApplicationContext());
        texto.setText(dato);
        contenedor.addView(texto);
        EditText editpregunta=new EditText(getApplicationContext());
        editpregunta.setId(id);
        contenedor.addView(editpregunta);
    }

}
