package com.example.practica;

        import androidx.appcompat.app.AppCompatActivity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.ImageView;
        import android.widget.TextView;

        //importamos glide para el logo
        //hay que añadir dos cosas en gradle Module (mirar ahi)
        import com.bumptech.glide.Glide;
        import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //LINEA PARA NO ACTION BAR
        getSupportActionBar().hide();

        //ANIMATION LOGO
        TextView signup = findViewById(R.id.textsignup);

        //metodo para que al pulsar el texto indicado en el activity login haga la animacion
        signup.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              openSignup();
          }
          });

        //GLIDE LOGO
        ImageView mlogo = findViewById(R.id.logo);
        Glide.with(this)
                .load(R.drawable.persona)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .circleCrop()
                .into(mlogo);

        //ANIMATION LOGO

        ImageView logo = findViewById(R.id.logo);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        logo.startAnimation(myanim);

    }

    //metodo para cambiar de pagina
    public void openSignup() {
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);
    }
    public void openMain(View view) {
        Intent intent = new Intent(Login.this, Main.class);
        startActivity(intent);
    }

}