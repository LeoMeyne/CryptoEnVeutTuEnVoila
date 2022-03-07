package com.leonathan.cryptobenef;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCalcul;

    TextView txtResultat;

    EditText txtCrypto;
    EditText txtValeurInt;
    EditText txtValeurInvesti;
    EditText txtValeurFin;

    float floatValeurInt;
    float floatValeurInvesti;
    float floatValeurFin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcul = (Button)findViewById(R.id.btnCalcule);
        btnCalcul.setOnClickListener(this);
        txtCrypto = findViewById(R.id.editTxtMonai);
        txtValeurInt = findViewById(R.id.editValeurInit);
        txtValeurInvesti = findViewById(R.id.editValeurIvesti);
        txtValeurFin = findViewById(R.id.editValeurFin);
        txtResultat = findViewById(R.id.txtRésultat);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.coinbase.com/v2/prices/spot?currency=USD")
                .build();
        System.out.print(request.toString());
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnCalcule){
            txtResultat.setText(Float.toString(calculBenef()));

        }
    }

    public Float calculBenef(){
        floatValeurInt = Float.parseFloat(txtValeurInt.getText().toString());
        floatValeurFin = Float.parseFloat(txtValeurFin.getText().toString());
        floatValeurInvesti = Float.parseFloat(txtValeurInvesti.getText().toString());

        float resultat = floatValeurInvesti * floatValeurFin / floatValeurInt;

        return  resultat;
    }
}