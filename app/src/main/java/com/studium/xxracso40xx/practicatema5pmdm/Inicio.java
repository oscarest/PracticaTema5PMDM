package com.studium.xxracso40xx.practicatema5pmdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {
Button boton1;
Button boton2;
Intent intent1;
Intent intent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        boton1 = findViewById(R.id.button);
        boton2 = findViewById(R.id.button1);
        intent1 = new Intent(this, ConfigurarToast.class);
        intent2 = new Intent(this, ConfigurarNotificacion.class);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(intent1);
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(intent2);
            }
        });
    }
}
