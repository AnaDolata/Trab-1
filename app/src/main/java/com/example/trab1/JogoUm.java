package com.example.trab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Random;

public class JogoUm extends AppCompatActivity {

    Random r = new Random();
    String ops[] = {"+", "-"};
    int n1, n2, result, nota;

    EditText input = findViewById(R.id.editTextNumber);
    TextView num1 = findViewById(R.id.textViewN1);
    TextView num2 = findViewById(R.id.textViewN2);
    TextView oper = findViewById(R.id.textViewOper);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_um);
    }

    public void validate(View view){
        int j = 0;

            n1 = r.nextInt(10);
            n2 = r.nextInt(10);

            int i = r.nextInt(1);
            String operation = ops[i];

            num1.setText(String.valueOf(n1));
            num2.setText(String.valueOf(n2));
            oper.setText(operation);

            switch (operation) {
                case "+":
                    result = n1+n2;
                    break;
                case "-":
                    result = n1-n2;
                    break;
            }

            if(Integer.parseInt(input.toString())==result){
                Toast.makeText(this, "Acertou", Toast.LENGTH_SHORT).show();
                nota = nota + 20;
            }else{
                Toast.makeText(this, "Errou! A resposta é " + result, Toast.LENGTH_SHORT).show();
            }

            j++;

        if(j==5) {
            Toast.makeText(this, "Pontuação: " + nota, Toast.LENGTH_SHORT).show();
        }

    }

    public void voltar(View view){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();
    }
}