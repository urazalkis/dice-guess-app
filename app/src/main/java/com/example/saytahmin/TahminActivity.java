package com.example.saytahmin;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class TahminActivity extends AppCompatActivity {

    private TextView KalanHak,Uyari;
    private EditText SayiGiris;
    private ImageView ImageViewZar;
    private Button buttonTahmin;
    private int sayac = 3;
    public static final Random RANDOM = new Random();
    private int value=0;
    private int Tahmin =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);

        KalanHak = findViewById(R.id.textViewKalanHak);
        ImageViewZar = findViewById(R.id.imageViewZar);
        buttonTahmin=findViewById(R.id.buttonTahmin);
        SayiGiris = findViewById(R.id.editTextSayiGir);
        Uyari = findViewById(R.id.textViewUyari);




        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Tahmin = Integer.parseInt(SayiGiris.getText().toString());
                if (SayiGiris.getText().toString().equals("") || Tahmin>6)
                {
                    Uyari.setText("Uygun Sayı Girin!");
                }else {
                    Uyari.setText("");

                    final Animation animasyon = AnimationUtils.loadAnimation(TahminActivity.this, R.anim.zaranimasyon);
                    final Animation.AnimationListener animationListener = new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                           // Log.e("animasyon","value : "+value);
                            int res = getResources().getIdentifier("dice_" + value, "drawable", "com.example.saytahmin");

                            if (animation == animasyon) {
                                ImageViewZar.setImageResource(res);
                            }
                        }
                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    };

                    animasyon.setAnimationListener(animationListener);
                    ImageViewZar.startAnimation(animasyon);

                    //Log.e("animasyon dışı","value : "+value);

                    value = randomDiceValue();
                    sayac--;
                    KalanHak.setText("Kalan Hak:" + sayac);
                    if (sayac != 0) {

                        if (Tahmin == value) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent i = new Intent(TahminActivity.this, SonucActivity.class);
                                    i.putExtra("sonuc", true);
                                    startActivity(i);
                                    finish();
                                }
                            },2000);

                        }
                    }

                    else {
                        if(Tahmin==value)
                        {
                            {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent i = new Intent(TahminActivity.this, SonucActivity.class);
                                        i.putExtra("sonuc", true);
                                        startActivity(i);
                                        finish();
                                    }
                                },2000);

                            }

                        }
                        else{
                               new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent i = new Intent(TahminActivity.this, SonucActivity.class);
                                    i.putExtra("sonuc", false);
                                    startActivity(i);
                                    finish();
                                }
                            },2000);

                        }

                    }
                }

                SayiGiris.setText("");
            }
        });
    }
    public static int randomDiceValue() {
        return RANDOM.nextInt(6) + 1;
    }
}
