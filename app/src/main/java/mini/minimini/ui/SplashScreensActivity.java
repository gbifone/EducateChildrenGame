package mini.minimini.ui;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import mini.minimini.IntroActivity;
import mini.minimini.R;
import mini.minimini.font.MaterialDesignIconsTextView;
import mini.minimini.ui.kbv.KenBurnsView;


public class SplashScreensActivity extends AppCompatActivity {
	private KenBurnsView mKenBurns;
	private MaterialDesignIconsTextView mLogo;
	private TextView welcomeText;
	private final int SPLASH_DISPLAY_LENGTH = 3500;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_splash_screen);
		mKenBurns = (KenBurnsView) findViewById(R.id.ken_burns_images);
		mLogo = (MaterialDesignIconsTextView) findViewById(R.id.logo);
		welcomeText = (TextView) findViewById(R.id.welcome_text);
		setAnimation();
		new Handler().postDelayed(new Runnable(){
			@Override
			public void run(){
				Intent startActivityIntent = new Intent(SplashScreensActivity.this, IntroActivity.class);
				startActivity(startActivityIntent);
				finish();
			}
		}, SPLASH_DISPLAY_LENGTH);
	}
	
	/** Animation depends on category.
	 * */
	private void setAnimation() {
			mKenBurns.setImageResource(R.drawable.splash_screen_option_three);
			animation();
			animation2();

	}
	private void animation() {
		mLogo.setAlpha(1.0F);
		Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate_top_to_center);
		mLogo.startAnimation(anim);
	}
	
	private void animation2() {
		ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(welcomeText, "alpha", 0.0F, 1.0F);
		alphaAnimation.setStartDelay(1700);
		alphaAnimation.setDuration(500);
		alphaAnimation.start();
	}
	@Override
	public void onBackPressed() {

	}
}
