package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numero0, numero1, numero2, numero3, numero4, numero5, numero6, numero7, numero8, numero9, adicao, sub, mult, divisao, igual;

    private TextView txt_expresao, txt_resultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();

        numero0.setOnClickListener(this);
        numero1.setOnClickListener(this);
        numero2.setOnClickListener(this);
        numero3.setOnClickListener(this);
        numero4.setOnClickListener(this);
        numero5.setOnClickListener(this);
        numero6.setOnClickListener(this);
        numero7.setOnClickListener(this);
        numero8.setOnClickListener(this);
        numero9.setOnClickListener(this);
        adicao.setOnClickListener(this);
        sub.setOnClickListener(this);
        mult.setOnClickListener(this);
        divisao.setOnClickListener(this);
        igual.setOnClickListener(this);

        // aqui apaga tudos os numeros de uma vez
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_expresao.setText("");
                txt_resultado.setText("");
            }
        });

        //aqui se apaga numero a numero
       /* backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.txt_expresao);
                String string = expressao.getText().toString();

                if(!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);

                }
                txt_resultado.setText("");
            }
        });*/

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Expression expressao = new ExpressionBuilder(txt_expresao.getText().toString()).build();
                    double resultado = expressao.evaluate();;
                    long longResult = (long) resultado;
                    if(resultado == (double) longResult){
                        txt_resultado.setText((CharSequence)String.valueOf(longResult));
                    }else{
                        txt_resultado.setText(String.valueOf(resultado));
                    }
                }catch (Exception e){

                }

                }

        });

    }

    private void IniciarComponentes() {
        numero0 = findViewById(R.id.numero_0);
        numero1 = findViewById(R.id.numero_1);
        numero2 = findViewById(R.id.numero_2);
        numero3 = findViewById(R.id.numero_3);
        numero4 = findViewById(R.id.numero_4);
        numero5 = findViewById(R.id.numero_5);
        numero6 = findViewById(R.id.numero_6);
        numero7 = findViewById(R.id.numero_7);
        numero8 = findViewById(R.id.numero_8);
        numero9 = findViewById(R.id.numero_9);
        adicao = findViewById(R.id.adicao);
        sub = findViewById(R.id.sub);
        mult = findViewById(R.id.mult);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        txt_expresao = findViewById(R.id.txt_expresao);
        txt_resultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);


    }

    public void AcrescentarExpressao(String string, boolean limpar_dados) {
        if (txt_resultado.getText().equals("")) {
            txt_expresao.setText(" ");
        }
        if (limpar_dados) {
            txt_resultado.setText(" ");
            txt_expresao.append(string);
        } else {
            txt_expresao.append(txt_resultado.getText());
            txt_expresao.append(string);
            txt_resultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.numero_0) {
            AcrescentarExpressao("0", true);
        } else if (view.getId() == R.id.numero_1) {
            AcrescentarExpressao("1", true);
        }else if (view.getId() == R.id.numero_2) {
            AcrescentarExpressao("2", true);
        }else if (view.getId() == R.id.numero_3) {
            AcrescentarExpressao("3", true);
        }else if (view.getId() == R.id.numero_4) {
            AcrescentarExpressao("4", true);
        }else if (view.getId() == R.id.numero_5) {
            AcrescentarExpressao("5", true);
        }else if (view.getId() == R.id.numero_6) {
            AcrescentarExpressao("6", true);
        }else if (view.getId() == R.id.numero_7) {
            AcrescentarExpressao("7", true);
        }else if (view.getId() == R.id.numero_8) {
            AcrescentarExpressao("8", true);
        }else if (view.getId() == R.id.numero_9) {
            AcrescentarExpressao("9", true);
        }else if (view.getId() == R.id.adicao) {
            AcrescentarExpressao("+", false);
        }else if (view.getId() == R.id.sub) {
            AcrescentarExpressao("-", false);
        }else if (view.getId() == R.id.mult) {
            AcrescentarExpressao("*", false);
        }else if (view.getId() == R.id.divisao) {
            AcrescentarExpressao("/", false);
        }

    }
}
