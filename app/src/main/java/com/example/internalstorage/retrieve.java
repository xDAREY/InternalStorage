package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;

public class retrieve extends AppCompatActivity {
    EditText nameEditText, passwordEditText;
    String Myname, MyPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        getSupportActionBar().hide();

        nameEditText = (EditText) findViewById(R.id.nameEditTextID);
        passwordEditText = (EditText) findViewById(R.id.editTextPassword);
    }

    public void Login (View view){
        try{
            FileInputStream fileInputStream = openFileInput("androidtext.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fileInputStream.read()) != -1){
                buffer.append((char)read);
            }

            String name = buffer.substring(0, buffer.indexOf(" "));
            String password = buffer.substring(buffer.indexOf(" ") + 1);

           Myname = nameEditText.getText().toString();
           MyPassword = passwordEditText.getText().toString();

//            Toast.makeText(retrieve.this, "name: " + name + "\nPassword: "
//                    + password, Toast.LENGTH_LONG).show();
//            Toast.makeText(retrieve.this, "name: " + Myname + "\nPassword: "
//                    + MyPassword, Toast.LENGTH_LONG).show();

            if (name.equals(Myname) && password.equals(MyPassword)) {
               Toast.makeText(retrieve.this, "Login Successful", Toast.LENGTH_LONG).show();

            }else Toast.makeText(retrieve.this, " Incorrect", Toast.LENGTH_LONG).show();

        }catch(Exception e){
            Log.e("Exception: ", e.toString());
        }
    }

    public void Back (View view){
        Intent intent = new Intent(retrieve.this, MainActivity.class );
        startActivity(intent);
    }
}