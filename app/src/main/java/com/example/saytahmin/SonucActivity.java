package com.example.saytahmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {

    private ImageView imageSonuc;
    private TextView textSonuc;
    private Button buttonTekrar;
    private boolean Sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);


        imageSonuc = findViewById(R.id.imageViewSonuc);
        textSonuc = findViewById(R.id.textViewSonuc);
        buttonTekrar=findViewById(R.id.buttonTekrarOyna);

        Sonuc = getIntent().getBooleanExtra("sonuc",false);

        if(Sonuc==true)
        {
            imageSonuc.setImageResource(R.drawable.smile_resim);
            textSonuc.setText("KAZANDINIZ!");
        }
        else
        {

            imageSonuc.setImageResource(R.drawable.sad_resim);
            textSonuc.setText("KAYBETTİNİZ :( ");
            textSonuc.setTextColor(Color.BLACK);

        }

        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SonucActivity.this, TahminActivity.class);
                startActivity(i);
                finish();

            }

        });

    }
}
