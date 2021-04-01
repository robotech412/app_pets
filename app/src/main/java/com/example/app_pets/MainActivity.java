package com.example.app_pets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextName;
    private EditText mEditTextEmail;
    private EditText mEditTextPassword;
    private Button mButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextName =(EditText) findViewById(R.id.editTextName);
        mEditTextEmail=(EditText) findViewById(R.id.editTextEmail);
        mEditTextPassword=(EditText)findViewById(R.id.ediTextPassword);
    }
}