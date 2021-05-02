package com.tuto.mangaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    TextView email;
    TextView password;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( email.getText().toString().equals("admin@admin.com") && password.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Correct", LENGTH_LONG).show();
                    button.setEnabled(true);
                    Intent intent = new Intent(MainActivity.this , MyRecyclerView.class);
                    startActivity(intent);
                    overridePendingTransition(R.transition.rotate_in,R.transition.rotate_out);


                }
                else
                    Toast.makeText(MainActivity.this, "not valid", Toast.LENGTH_SHORT).show();



            }
        });








    }
}