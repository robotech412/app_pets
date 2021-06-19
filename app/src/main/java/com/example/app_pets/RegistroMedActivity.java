package com.example.app_pets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_pets.model.Medicamento;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RegistroMedActivity extends AppCompatActivity {
    EditText marca, nombre, cantidad, uso, descripcion;

    private Button btn_back, btn_registrar;
    private FirebaseFirestore db;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_med);
        btn_back = (Button) findViewById(R.id.btnVolver);
        btn_registrar = (Button) findViewById(R.id.btnRegistrar);

        marca = findViewById(R.id.editTextMarca);
        nombre = findViewById(R.id.editTextNombre);
        cantidad = findViewById(R.id.editTextCantidad);
        uso = findViewById(R.id.editTextUso);
        descripcion = findViewById(R.id.editTextDescripcion);

        db = FirebaseFirestore.getInstance();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistroMedActivity.this, ProfileActivity.class));
                finish();
            }
        });

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Marca = marca.getText().toString();
                String Nombre = nombre.getText().toString();
                String Cantidad = cantidad.getText().toString();
                String Uso = uso.getText().toString();
                String Descripcion = descripcion.getText().toString();
                if (Marca.equals("") || Nombre.equals("") || Cantidad.equals("") || Uso.equals("") || Descripcion.equals("")) {
                    validacion();
                } else {
                    // Toast.makeText(this,"Agregado",Toast.LENGTH_LONG).show();
                    crearDatos();
                    limpiarTexto();
                    startActivity(new Intent(RegistroMedActivity.this, ProfileActivity.class));
                    finish();
                }

            }
        });

    }

    private void crearDatos() {
        String Marca = marca.getText().toString();
        String Nombre = nombre.getText().toString();
        String Cantidad = cantidad.getText().toString();
        String Uso = uso.getText().toString();
        String Descripcion = descripcion.getText().toString();
        Map<String,Object> map = new HashMap<>();
        map.put("Marca",Marca);
        map.put("Nombre",Nombre);
        map.put("Cantidad",Cantidad);
        map.put("Uso",Uso);
        map.put("Descripcion",Descripcion);
        db.collection("Medicamentos").document().set(map);
    }

    private void limpiarTexto() {
        marca.setText("");
        nombre.setText("");
        cantidad.setText("");
        uso.setText("");
        descripcion.setText("");
    }

    private void validacion() {
        String Marca = marca.getText().toString();
        String Nombre = nombre.getText().toString();
        String Cantidad = cantidad.getText().toString();
        String Uso = uso.getText().toString();
        String Descripcion = descripcion.getText().toString();
        if (Marca.equals("")) {
            marca.setError("Requerido");
        } else if (Nombre.equals("")) {
            nombre.setError("Requerido");
        } else if (Cantidad.equals("")) {
            cantidad.setError("Requerido");
        } else if (Uso.equals("")) {
            uso.setError("Requerido");
        } else if (Descripcion.equals("")) {
            descripcion.setError("Requerido");
        }
    }

}