package pt.ulisboa.tecnico.neeti;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashActivity extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2950;
    private static int SPLASH_SPEED = 150;

    private void startSplash () {
        AnimationDrawable animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.splash0), SPLASH_SPEED);
        animation.addFrame(getResources().getDrawable(R.drawable.splash1), SPLASH_SPEED);
        animation.addFrame(getResources().getDrawable(R.drawable.splash2), SPLASH_SPEED);
        animation.addFrame(getResources().getDrawable(R.drawable.logo), SPLASH_SPEED);
        animation.setOneShot(false);
        ((ImageView)findViewById(R.id.splashLogo)).setImageDrawable(animation);
        animation.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, MainMenu.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

        startSplash();
    }

}