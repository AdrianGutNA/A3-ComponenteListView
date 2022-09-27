package com.example.a3_componentelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button   btnCalcular;
    private Button   btnLimpiar;
    private EditText txtN1;
    private EditText txtN2;
    private ListView lvNumeros;

    private double numero1    = 0;
    private double numero2    = 0;
    private double resultado  = 0;
    private String datos      = "";

    private ArrayList<String> numeros;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular =            findViewById(R.id.btnCalcular);
        btnLimpiar  =            findViewById(R.id.btnLimpiar);
        txtN1       = (EditText) findViewById(R.id.txtN1);
        txtN2       = (EditText) findViewById(R.id.txtN2);
        lvNumeros   = (ListView) findViewById(R.id.lvNumeros);

        numeros     = new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numeros);

        lvNumeros.setAdapter(adapter);

        txtN1.setOnClickListener(this);
        txtN2.setOnClickListener(this);

        btnCalcular.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);

        lvNumeros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Has pulsado: "+ numeros.get(position), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override public void onClick(View view){
        switch (view.getId()){
            case R.id.txtN1:
                txtN2.requestFocus();
                break;
            case R.id.txtN2:
                btnCalcular.requestFocus();
                break;
            case R.id.btnCalcular:

                numero1 = Double.valueOf(txtN1.getText().toString());
                numero2 = Double.valueOf(txtN2.getText().toString());

                resultado = numero1 + numero2;

                datos     = numero1 + " + " + numero2 + " = " + resultado;

                numeros.add(datos);
                break;
            case R.id.btnLimpiar:
                txtN1.setText("");
                txtN2.setText("");

                txtN1.requestFocus();
                lvNumeros.setAdapter(null);
                numeros.clear();
                break;
        }

    }

}