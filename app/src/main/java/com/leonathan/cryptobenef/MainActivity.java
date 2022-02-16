package com.leonathan.cryptobenef;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = findViewById(R.id.cryptoText);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.coinbase.com/v2/prices/spot?currency=USD")
                .build();
        System.out.print(request.toString());
    }
}