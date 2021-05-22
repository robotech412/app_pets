package com.example.app_pets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroMedActivity extends AppCompatActivity {

    private Button med_btn_back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_med);
        med_btn_back= (Button) findViewById(R.id.btnVolver);

        med_btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistroMedActivity.this,ProfileActivity.class));
                finish();
            }
        });
    }


}