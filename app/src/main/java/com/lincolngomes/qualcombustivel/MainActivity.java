package com.lincolngomes.qualcombustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {


    // Inicia as propriedades
    private TextInputEditText editarPrecoAlcool, editarPrecoGasolina;
    private TextView textoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Propriedades recebem o que for encontrado em findView

        editarPrecoAlcool = findViewById(R.id.editarPrecoAlcool);
        editarPrecoGasolina = findViewById(R.id.editarPrecoGasolina);
        textoResultado = findViewById(R.id.textoResultado);


    }
        // Inicia metódo

    public void calculaPreco(View view){

        //recuperar os dados digitados
        String precoAlcool = editarPrecoAlcool.getText().toString();
        String precoGasolina = editarPrecoGasolina.getText().toString();

        // Validar os campos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if (camposValidados){

            //Convertendo String para numeros
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);


            //Fazer calculo

            Double resultado = valorAlcool / valorGasolina;
            if ( resultado >= 0.7){
                textoResultado.setText("Melhor usar Gasolina");
            }else{
                textoResultado.setText("Melhor usar Álcool");
            }

        }else {
            textoResultado.setText("Por favor, preencha os preços.");
        }
    }

        public Boolean validarCampos (String pAlcool, String pGasolina) {

        Boolean camposValidados = true;

        if ( pAlcool == null || pAlcool.equals("") ){
            camposValidados = false;
        }
        else if(
            pGasolina == null || pGasolina.equals("") ){
            camposValidados = false;
                }


        return camposValidados;
        }

}