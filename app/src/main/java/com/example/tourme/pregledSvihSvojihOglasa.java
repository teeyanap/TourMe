package com.example.tourme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class pregledSvihSvojihOglasa extends AppCompatActivity {

    Button goToCheckOglas;
    Button goToAddOglas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            setContentView(R.layout.activity_pregled_svih_svojih_oglasa);

            goToCheckOglas = findViewById(R.id.goToCheckOglas);
            goToAddOglas = findViewById(R.id.goToAddOglas);

            goToAddOglas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(pregledSvihSvojihOglasa.this, dodajOglas.class);
                    startActivity(i);
                }
            });

            goToCheckOglas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(pregledSvihSvojihOglasa.this, pregled_jednog_oglasa.class);
                    i.putExtra("IDOglasa", "-MpwlHJZTT2jwEl5ZhRE");
                    startActivity(i);
                }
            });
        }
        else{
            setContentView(R.layout.not_logged_in);
            Button dugme_login = findViewById(R.id.dugme_login);
            dugme_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(pregledSvihSvojihOglasa.this, Login.class);
                    startActivity(i);
                }
            });
        }
    }
}