package com.example.bestfuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button_calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_calcular = (Button) findViewById(R.id.btnCalcular);

        button_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double consumo_alcool, consumo_gasolina, preco_alcool, preco_gasolina,
                        value_consumo, value_preco;

                EditText conalc = (EditText) findViewById(R.id.con_alc);
                consumo_alcool = Double.parseDouble(conalc.getText().toString());

                EditText congas = (EditText) findViewById(R.id.con_gas);
                consumo_gasolina = Double.parseDouble(congas.getText().toString());

                EditText precalc = (EditText) findViewById(R.id.pre_alcool);
                preco_alcool = Double.parseDouble(precalc.getText().toString());

                EditText precgas = (EditText) findViewById(R.id.pre_gas);
                preco_gasolina = Double.parseDouble(precgas.getText().toString());

                TextView textView = findViewById(R.id.txtResult);

                value_consumo = consumo_alcool / consumo_gasolina;
                value_preco = preco_alcool / preco_gasolina;

                Log.i("DEBUG_TAG", String.valueOf(value_consumo));
                Log.i("DEBUG_TAG", String.valueOf(value_preco));

                if(value_preco > value_consumo){
                    textView.setText("Abastecer com gasolina");
                }else{
                    textView.setText("Abastecer com álcool");
                }
            }
        });
    }
}