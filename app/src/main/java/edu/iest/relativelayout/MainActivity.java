package edu.iest.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bnCanal =findViewById(R.id.bnCanal);
        EditText etCanal =findViewById(R.id.etCanal);
        TextView tvCanal =findViewById(R.id.tvCanal);


        Spinner spProgramas=findViewById(R.id.spProgramas);
        ImageView ivContinuara=findViewById(R.id.ivContinuara);

        spProgramas.setOnItemSelectedListener(this);


        bnCanal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //AQUI LA LOGICA QUE HACER AL DAR CLICK
                //OBTENDREMOS EL VALOR DEL EDITTEXT Y LO ASIGRNAREMOS AL TEXT VIEW INFERIOR

                String texto = etCanal.getText().toString();
                Toast.makeText(MainActivity.this, "El valor era " + texto, Toast.LENGTH_SHORT).show();
                tvCanal.setText(texto);

            }
        });

    }
    private ImageView ivContinuara;

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long idFila) {
        String programa = adapterView.getItemAtPosition(posicion).toString();
        Snackbar.make(adapterView, "El programa seleccionado es: " + programa, Snackbar.LENGTH_LONG).show();

        ivContinuara = findViewById(R.id.ivContinuara);

        if (posicion == 0) {
            ivContinuara.setImageResource(R.drawable.tobecontinued1);
        } else if (posicion == 1) {
            ivContinuara.setImageResource(R.drawable.tobecontinued2);
        } else {
            ivContinuara.setImageResource(R.drawable.tobecontinued3);
        }


        ivContinuara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DatosActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}