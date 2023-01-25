package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        openApp();

        //implements and starts animation
        // objeto thunder sobre el cual aplicaremos la animación
        ImageView thunder = findViewById(R.id.logosplash);

        //creamos un objeto animación que incorpora la animación descrita en el xml y con el método
        // startAnimation lo aplicamos al imageview del logo
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.blink);
        thunder.startAnimation(myanim);

        //    Glide para cargar el fondo
        ImageView fondo = findViewById(R.id.fondo);

        Glide.with(this)
              .load(R.drawable.img)
                .transition(DrawableTransitionOptions.withCrossFade(50))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(fondo);

    }

//metodo para cambiar de pagina Splash - Login
    private void openApp() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent(Splash
                        .this, Login.class);
                startActivity(intent);
            }
        }, 2000); //tiempo que tarda en pasar de pagina
    }

}