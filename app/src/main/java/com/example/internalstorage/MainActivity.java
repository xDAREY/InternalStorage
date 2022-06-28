package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText, passwordEditText;
    private Button LoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        LoginBtn = (Button) findViewById(R.id.NextID);
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, retrieve.class);
                startActivity(intent);
            }
        });


        nameEditText = (EditText) findViewById(R.id.nameEditTextID);
        passwordEditText = (EditText) findViewById(R.id.editTextPassword);
    }

    public void Save(View view) {
        String name = nameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        File file = null ;
        FileOutputStream fileOutputStream = null;

        try {
            name = name + " ";
            file = getFilesDir();

            fileOutputStream = openFileOutput("androidtext.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(name.getBytes());
            fileOutputStream.write(password.getBytes());

            Toast.makeText(MainActivity.this, "Your file have been \n at path" + file
                    + "\tandroidtext.txt ", Toast.LENGTH_LONG).show();

            nameEditText.setText(" ");
            passwordEditText.setText(" ");

            return;
        } catch (Exception e) {
            Log.e("Exception", e.toString());
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
