package com.example.maya.desaparecidos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Activity extends AppCompatActivity {
    Button button;
    TextView txt;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar_sesion);
        button = (Button) findViewById(R.id.button);
        txt = (TextView) findViewById(R.id.textView);
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumir();
            }
        });*/
    }

    private String inisiarSecion(String email, String pass) {
        URL url = null;
        String linea = "";
        int respuesta = 0;
        StringBuilder resul = null;
        try {

            url = new URL("http://192.168.0.10:8080/WebServiceM/service/Webservice.php?email=" + email + "&apellido=" + pass);
            HttpURLConnection conection = (HttpURLConnection) url.openConnection();
            respuesta = conection.getResponseCode();
            resul = new StringBuilder();

            if (respuesta == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(conection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                while ((linea = reader.readLine()) != null) {
                    resul.append(linea);
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex + "", Toast.LENGTH_SHORT).show();
        }

        return resul.toString();
    }

    public String TolistUsuario() {
        URL url = null;
        String linea = "";
        int respuesta = 0;
        StringBuilder resul = null;
        try {

            url = new URL("http://192.168.0.10:8080/WebServiceM/service/Websevice.php");
            HttpURLConnection conection = (HttpURLConnection) url.openConnection();
            respuesta = conection.getResponseCode();
            resul = new StringBuilder();

            if (respuesta == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(conection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                while ((linea = reader.readLine()) != null) {
                    resul.append(linea);
                }
            }
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex + "", Toast.LENGTH_SHORT).show();
        }

        return resul.toString();
    }

    public void consumir() {
        Thread sl = new Thread() {
            @Override
            public void run() {
                final String respuesta = TolistUsuario();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int i = mostrardatos(respuesta);
                        if (i > 0) {

                        }
                    }
                });
            }
        };
        sl.start();
    }

    public int mostrardatos(String respt) {
        int i = 0;
        try {
            JSONArray jso = new JSONArray(respt);
            txt.setText(jso.toString());
        } catch (Exception ex) {

        }
        return i;
    }

    public int verificarRespuesta(String respt) {
        int i = 0;
        try {
            JSONArray jso = new JSONArray(respt);
            if (jso.length() > 0) {
                return 1;
            }
        } catch (Exception ex) {

        }
        return i;
    }
}
