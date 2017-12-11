package com.example.dellinspiron.ingsoftabusoinfantil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VingresoPreguntas extends AppCompatActivity {
    TextView txt_nombre_cuestionario;
    LinearLayout contenedor;
    int num_preguntas;
    int num_respuestas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vingreso_preguntas);
        contenedor=(LinearLayout)findViewById(R.id.contenedor);

        recibirDatos();
        Button btn_siguiente=new Button(getApplicationContext());
        btn_siguiente.setText("Siguiente");
        //accion del boton
        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> data=new ArrayList<>();
                for(int i=1;i<=num_preguntas;i++){
                    EditText dato=(EditText)findViewById(i);
                    data.add(dato.getText()+"");
                }
                Intent vingresorespuestas=new Intent(VingresoPreguntas.this,VingresoRespuestas.class);
                vingresorespuestas.putStringArrayListExtra("arreglo",data);
                vingresorespuestas.putExtra("txt_nombre_cuestionario",txt_nombre_cuestionario.getText()+"");
                vingresorespuestas.putExtra("num_respuestas", num_respuestas+"");
                startActivity(vingresorespuestas);
            }
        });
        contenedor.addView(btn_siguiente);




    }
    public void recibirDatos(){
        Bundle data=getIntent().getExtras();
        String nombre_cuestionario=data.getString("txt_nombre_cuestionario");
        num_preguntas=Integer.parseInt(data.getString("num_preguntas"));
        num_respuestas=Integer.parseInt(data.getString("num_respuestas"));
        txt_nombre_cuestionario=(TextView)findViewById(R.id.txt_nombre);
        txt_nombre_cuestionario.setText(nombre_cuestionario);
        //generar el ingreso de las preguntas
        for(int i=1;i<=num_preguntas;i++){
            TextView txt_texto=new TextView(getApplicationContext());
            txt_texto.setText("Pregunta numero "+i);
            txt_texto.setTextColor(Color.BLUE);
            contenedor.addView(txt_texto);
            //creacion de los Edit text
            EditText preguntas=new EditText(getApplicationContext());
            preguntas.setId(i);
            contenedor.addView(preguntas);


        }


    }

}
