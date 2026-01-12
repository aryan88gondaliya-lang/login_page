package com.example.myapplication;

import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    CardView loginCard;
    TextView title, subTitle;
    EditText email, password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginCard = findViewById(R.id.loginCard);
        title = findViewById(R.id.title);
        subTitle = findViewById(R.id.subTitle);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);

        startIntroAnimation();
        setupButtonEffect();
    }

    private void startIntroAnimation() {

        loginCard.setScaleX(0.9f);
        loginCard.setScaleY(0.9f);
        loginCard.setAlpha(0f);

        loginCard.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(700)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .start();

        title.animate().alpha(1f).setDuration(500).setStartDelay(300).start();
        subTitle.animate().alpha(1f).setDuration(500).setStartDelay(400).start();

        email.animate().alpha(1f).translationYBy(20f)
                .setDuration(500).setStartDelay(500).start();

        password.animate().alpha(1f).translationYBy(20f)
                .setDuration(500).setStartDelay(650).start();

        loginBtn.animate().alpha(1f).translationYBy(20f)
                .setDuration(500).setStartDelay(800).start();
    }

    private void setupButtonEffect() {

        loginBtn.setOnClickListener(v -> {

            // Button press animation
            loginBtn.animate()
                    .scaleX(0.95f)
                    .scaleY(0.95f)
                    .setDuration(100)
                    .withEndAction(() -> loginBtn.animate()
                            .scaleX(1f)
                            .scaleY(1f)
                            .setDuration(100)
                            .start())
                    .start();

            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        });
    }
}
