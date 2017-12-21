package mini.minimini;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;




public class MenuActivity extends AppCompatActivity {
    TextView  animalText, fruitText, shapeText, colorText, numberText , riddleText;
    ImageView animal, fruit, shape, color, number, riddle;
    ImageView language;
    String selectedLanguage;
    SharedPreferences sharedPreferences;
    boolean isTurkish;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_mainmenu);

        language = (ImageView)findViewById(R.id.language);

        animal = (ImageView)findViewById(R.id.animal);
        fruit =  (ImageView) findViewById(R.id.fruit);
        shape =  (ImageView)findViewById(R.id.shape);
        color =  (ImageView) findViewById(R.id.color);
        number = (ImageView)findViewById(R.id.number);
        riddle = (ImageView)findViewById(R.id.riddle);


        animalText = (TextView) findViewById(R.id.text_animal);
        fruitText =(TextView) findViewById(R.id.text_fruit);
        shapeText = (TextView) findViewById(R.id.text_shape);
        colorText =(TextView) findViewById(R.id.text_color);
        numberText = (TextView) findViewById(R.id.text_number);
        riddleText = (TextView) findViewById(R.id.text_riddle);

        numberText.setTextColor(getResources().getColor(R.color.material_light_yellow_700));
        fruitText.setTextColor(getResources().getColor(R.color.material_red_700));
        shapeText.setTextColor(getResources().getColor(R.color.material_light_blue_700));
        colorText.setTextColor(getResources().getColor(R.color.material_deep_purple_700));
        animalText.setTextColor(getResources().getColor(R.color.material_yellow_700));
        riddleText.setTextColor(getResources().getColor(R.color.material_green_600));


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        selectedLanguage = sharedPreferences.getString("language", null);

        if (selectedLanguage.equals("turkish")) {
            isTurkish = true;
            language.setImageDrawable(getResources().getDrawable(R.drawable.uk_flag));

            animalText.setText("HAYVANLAR");
            colorText.setText("RENKLER");
            numberText.setText("SAYILAR");
            shapeText.setText("BİÇİMLER");
            riddleText.setText("BULMACA");
            fruitText.setText("MEYVELER");

        } else{
            isTurkish = false;
            language.setImageDrawable(getResources().getDrawable(R.drawable.turkish_flag));
            animalText.setText("ANIMALS");
            colorText.setText("COLORS");
            numberText.setText("NUMBERS");
            shapeText.setText("SHAPES");
            riddleText.setText("RIDDLES");
            fruitText.setText("FRUITS");

    }




        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTurkish)
                {
                    isTurkish = false;
                    sharedPreferences.edit()
                            .putString("language", "english")
                            .commit();
                    language.setImageDrawable(getResources().getDrawable(R.drawable.turkish_flag));

                    animalText.setText("ANIMALS");
                    colorText.setText("COLORS");
                    numberText.setText("NUMBERS");
                    shapeText.setText("SHAPES");
                    riddleText.setText("RIDDLES");
                    fruitText.setText("FRUITS");
                }
                else
                {
                    isTurkish = true;
                        sharedPreferences.edit()
                                .putString("language", "turkish")
                                .commit();
                    language.setImageDrawable(getResources().getDrawable(R.drawable.uk_flag));

                    animalText.setText("HAYVANLAR");
                    colorText.setText("RENKLER");
                    numberText.setText("SAYILAR");
                    shapeText.setText("BİÇİMLER");
                    riddleText.setText("BULMACA");
                    fruitText.setText("MEYVELER");

                }
            }
        });

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferences.edit()
                        .putString("type", "color")
                        .commit();

                Intent i1=new Intent(MenuActivity.this, LearningActivity.class);
                startActivity(i1);
                finish();
            }
        });

        fruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences.edit()
                        .putString("type", "fruit")
                        .commit();

                Intent i1=new Intent(MenuActivity.this,LearningActivity.class);
                startActivity(i1);
                finish();

            }
        });
        shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences.edit()
                        .putString("type", "shape")
                        .commit();

                Intent i1=new Intent(MenuActivity.this,LearningActivity.class);
                startActivity(i1);
                finish();

            }
        });
        animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences.edit()
                        .putString("type", "animal")
                        .commit();

                Intent i1=new Intent(MenuActivity.this,LearningActivity.class);
                startActivity(i1);
                finish();

            }
        });
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences.edit()
                        .putString("type", "number")
                        .commit();

                Intent i1=new Intent(MenuActivity.this,LearningActivity.class);
                startActivity(i1);
                finish();

            }
        });
        riddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(MenuActivity.this,RiddleActivity.class);
                startActivity(i1);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

}
