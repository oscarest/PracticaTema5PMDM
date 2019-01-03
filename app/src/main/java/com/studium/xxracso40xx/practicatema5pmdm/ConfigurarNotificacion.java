package com.studium.xxracso40xx.practicatema5pmdm;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfigurarNotificacion extends AppCompatActivity {
    AppCompatActivity estaActividad;
    Button boton;
    EditText edit1;
    EditText edit2;
    EditText edit3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_notificacion);
        estaActividad = this;
        boton = findViewById(R.id.button3);
        edit1 = findViewById(R.id.editText4);
        edit2 = findViewById(R.id.editText5);
        edit3 = findViewById(R.id.editText6);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PendingIntent i = PendingIntent.getActivity(estaActividad, 0, getIntent(), 0);
                NotificationCompat.Builder mensaje = new NotificationCompat.Builder(estaActividad, "CH_ID");
                mensaje.setAutoCancel(true)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setWhen(System.currentTimeMillis() + (Integer.parseInt(edit3.getText().toString()) * 1000))
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.imagen))
                        //.setWhen(System.currentTimeMillis() + AlarmManager.ELAPSED_REALTIME * Integer.parseInt(edit3.getText().toString()))
                        .setSmallIcon(R.drawable.imagen)
                        .setPriority(Notification.PRIORITY_MAX) // No válido en API 26
                        .setContentTitle(edit1.getText())
                        .setContentText(edit2.getText())
                        .setContentIntent(i);
                NotificationManager nM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nM.notify(1, mensaje.build());
            }
        });
    }
}
