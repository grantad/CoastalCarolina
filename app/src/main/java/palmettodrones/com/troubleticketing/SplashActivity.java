package palmettodrones.com.troubleticketing;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    private boolean backbtnPress;
    private static final int SPLASH_DURATION = 3000; //3 secs
    private Handler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide the Action Bar
  //      getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
//        getActionBar().hide();;

        // hide action bar for android version before Jellybean
        if (Build.VERSION.SDK_INT < 16 ) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
         else {
            View decorView = getWindow().getDecorView();
            // Hide the status bar
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
            // Using an older version of ActionBar
            //android.app.ActionBar actionBar = getActionBar();
           // actionBar.hide();
        }

        setContentView(R.layout.activity_splash);

        myHandler = new Handler();

        myHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();

                if (!backbtnPress)
                {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);  // MainActivty is the Activity we are going to after the splash screen
                    SplashActivity.this.startActivity(intent);
                }
            }
        }, SPLASH_DURATION);
    }

    @Override
    public void onBackPressed() {

        backbtnPress = true;
        super.onBackPressed();
    }
}
