package com.example.app_pets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Activity_Datos_Usuario extends AppCompatActivity {
    //Button bfecha;
    //EditText efecha;
    //private int dia,mes,ano;

    EditText nombres, apellidos, sexo, telefono;
    private Button btn_guardar;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_usuario);

        //bfecha=(Button)findViewById(R.id.bfecha);
        //efecha=(EditText) findViewById(R.id.efecha);
        //bfecha.setOnClickListener(this);

        nombres = findViewById(R.id.txtNombres);
        apellidos = findViewById(R.id.txtApellidos);
        sexo = findViewById(R.id.txtSexo);
        telefono = findViewById(R.id.txtTelefono);

        btn_guardar = (Button) findViewById(R.id.btn_guardar);

        db = FirebaseFirestore.getInstance();


        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nombres = nombres.getText().toString();
                String Apellidos = apellidos.getText().toString();
                String Sexo = sexo.getText().toString();
                String Telefono = telefono.getText().toString();
                if (Nombres.equals("") || Apellidos.equals("") || Sexo.equals("") || Telefono.equals("")) {
                    validacion();
                } else {
                    crearDatos();
                    //startActivity(new Intent(Activity_Datos_Usuario.this, profile_fragment.class));
                    finish();
                }
            }
        });
    }

    private void limpiarTexto() {
        nombres.setText("");
        apellidos.setText("");
        sexo.setText("");
        telefono.setText("");
    }

    private void crearDatos() {
        String Nombres = nombres.getText().toString();
        String Apellidos = apellidos.getText().toString();
        String Sexo = sexo.getText().toString();
        String Telefono = telefono.getText().toString();
        Map<String, Object> map = new HashMap<>();
        map.put("Nombres", Nombres);
        map.put("Apellidos", Apellidos);
        map.put("Sexo", Sexo);
        map.put("Telefono", Telefono);
        db.collection("Perfil").document("1").set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(Activity_Datos_Usuario.this, "El perfil se ha llenado correctamente", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Activity_Datos_Usuario.this, "El perfil no se ha podido llenar", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void validacion() {
        String Nombres = nombres.getText().toString();
        String Apellidos = apellidos.getText().toString();
        String Sexo = sexo.getText().toString();
        String Telefono = telefono.getText().toString();
        if (Nombres.equals("")) {
            nombres.setError("Requerido");
        } else if (Apellidos.equals("")) {
            apellidos.setError("Requerido");
        } else if (Sexo.equals("")) {
            sexo.setError("Requerido");
        } else if (Telefono.equals("")) {
            telefono.setError("Requerido");
        }
    }

    /*@Override
    public void onClick(View v) {
        if(v==bfecha){
            final Calendar c= Calendar.getInstance();
            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    efecha.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                }
            }
            ,dia,mes,ano);
            datePickerDialog.show();
        }
    }*/
}