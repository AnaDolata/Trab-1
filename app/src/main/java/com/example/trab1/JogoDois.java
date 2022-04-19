package com.example.trab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class JogoDois extends AppCompatActivity {

    EditText input = findViewById(R.id.editTextNumber2);
    TextView num1 = findViewById(R.id.textView);
    TextView num2 = findViewById(R.id.textView2);
    TextView num3 = findViewById(R.id.textView3);

    Random r = new Random();
    int n1, n2, n3, result, nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_dois);
    }

    public void validate(View view){
        int j = 0;

            n1 = r.nextInt(10);
            n2 = r.nextInt(10);
            n3 = r.nextInt(10);

            num1.setText(String.valueOf(n1));
            num2.setText(String.valueOf(n2));
            num3.setText(String.valueOf(n3));

            if(n1>=n2 && n1>=n3){
                result = n1*100;
                if(n2>=n3){
                    result = n2*10 + n3;
                }else{
                    result = n3*10 + n2;
                }
            }else if(n2>=n1 && n2>=n3){
                result = n2*100;
                if(n1>=n3){
                    result = n1*10 + n3;
                }else{
                    result = n3*10 + n1;
                }
            }else if(n3>=n1 && n3>=n2){
                result = n3*100;
                if(n2>=n1){
                    result = n2*10 + n1;
                }else{
                    result = n1*10 + n2;
                }
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