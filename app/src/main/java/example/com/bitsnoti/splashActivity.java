package example.com.bitsnoti;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splashActivity extends Activity {
    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView inf = (ImageView) findViewById(R.id.imageView);
        inf.setImageResource(R.drawable.animate);
        AnimationDrawable infl = (AnimationDrawable) inf.getDrawable();
        infl.start();
        /****** Create Thread that will sleep for 5 seconds *************/
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(5 * 1000);

                    // After 5 seconds redirect to another intent
                    Intent i = new Intent(getBaseContext(), Allevents.class);
                    startActivity(i);

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }

            }
        };
        // start thread
        background.start();
    }
        @Override
        protected void onDestroy() {

            super.onDestroy();

        }
}
