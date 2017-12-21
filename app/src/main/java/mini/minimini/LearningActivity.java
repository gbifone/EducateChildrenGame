package mini.minimini;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;


import java.io.IOException;
import java.util.ArrayList;

public class LearningActivity extends AppCompatActivity {
    MediaPlayer introAudio,firstAudio, secondAudio, thirdAudio, fourthAudio, fifthAudio, sixthAudio,seventhAudio,eightAudio,ninthAudio,tenthAudio,eleventhAudio,current,frozen;
    ArrayList<MediaPlayer[]> mediaPlayer = new ArrayList();
    FloatingActionButton repeat, previous, pause, home;
    int imagesAnimal[] = {R.drawable.animalicon,R.drawable.kedi,R.drawable.kopek,R.drawable.balik,R.drawable.kus,R.drawable.tavuk,R.drawable.at,R.drawable.kanguru,R.drawable.kaplumbaga,R.drawable.aslan};
    int imagesColor[] = {R.drawable.colorsicon, R.drawable.red, R.drawable.blue,R.drawable.green,R.drawable.yellow,R.drawable.orange,R.drawable.purple};
    int imagesNumber[] = {R.drawable.numbers,R.drawable.numberzero,R.drawable.numberone,R.drawable.numbertwo,R.drawable.numberthree,R.drawable.numberfour,R.drawable.numberfive,R.drawable.numbersix,R.drawable.numberseven,R.drawable.numbereight,R.drawable.numbernine};
    int imagesFruit[] = {R.drawable.fruit,R.drawable.cilek,R.drawable.elma,R.drawable.muz,R.drawable.havuc,R.drawable.domates,R.drawable.patlican,R.drawable.portakal};
    int imagesShape[] = {R.drawable.shapeicon, R.drawable.square, R.drawable.star,R.drawable.triangle,R.drawable.circle};
    int currentArray[];

    public boolean paused=false;

    String language;
    String type;
    SharedPreferences sharedPreferences;

    int index = 0;
    ImageView imagePlace;
    @Override
    protected void onStart() {
        super.onStart();

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_learning);
        imagePlace = (ImageView) findViewById(R.id.demoImage);
        imagePlace.setImageResource(R.drawable.fruit);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        language = sharedPreferences.getString("language",null);
        type = sharedPreferences.getString("type",null);



        if (type.equals("animal"))
        {
            if(language.equals("turkish")) {
                introAudio = MediaPlayer.create(this, R.raw.hayvanlar);
                firstAudio = MediaPlayer.create(this, R.raw.kedi);
                secondAudio = MediaPlayer.create(this, R.raw.kopek);
                thirdAudio = MediaPlayer.create(this, R.raw.balik);
                fourthAudio = MediaPlayer.create(this, R.raw.kus);
                fifthAudio = MediaPlayer.create(this, R.raw.tavuk);
                sixthAudio = MediaPlayer.create(this, R.raw.at);
                seventhAudio = MediaPlayer.create(this, R.raw.kanguru);
                eightAudio = MediaPlayer.create(this, R.raw.kaplumbaga);
                ninthAudio = MediaPlayer.create(this, R.raw.aslan);
            }else{
                introAudio = MediaPlayer.create(this, R.raw.animals);
                firstAudio = MediaPlayer.create(this, R.raw.cat);
                secondAudio = MediaPlayer.create(this, R.raw.dog);
                thirdAudio = MediaPlayer.create(this, R.raw.fish);
                fourthAudio = MediaPlayer.create(this, R.raw.bird);
                fifthAudio = MediaPlayer.create(this, R.raw.chicken);
                sixthAudio = MediaPlayer.create(this, R.raw.horse);
                seventhAudio = MediaPlayer.create(this, R.raw.kangaroo);
                eightAudio = MediaPlayer.create(this, R.raw.turtle);
                ninthAudio = MediaPlayer.create(this, R.raw.lion);
            }
            MediaPlayer mediaPlayerAnimal[]={introAudio,firstAudio, secondAudio, thirdAudio, fourthAudio, fifthAudio, sixthAudio,seventhAudio,eightAudio,ninthAudio};
            mediaPlayer.add(mediaPlayerAnimal);

            animate(imagePlace, imagesAnimal, 0);
            currentArray=imagesAnimal;
        }
        if (type.equals("fruit"))
        {

            if(language.equals("turkish")) {
                introAudio = MediaPlayer.create(this, R.raw.meyveler);
                firstAudio = MediaPlayer.create(this, R.raw.cilek);
                secondAudio = MediaPlayer.create(this, R.raw.elma);
                thirdAudio = MediaPlayer.create(this, R.raw.muz);
                fourthAudio = MediaPlayer.create(this, R.raw.havuc);
                fifthAudio = MediaPlayer.create(this, R.raw.domates);
                sixthAudio = MediaPlayer.create(this, R.raw.patlican);
                seventhAudio = MediaPlayer.create(this, R.raw.portakal);
            }else{
                    introAudio = MediaPlayer.create(this, R.raw.fruits);
                    firstAudio = MediaPlayer.create(this, R.raw.strawberry);
                    secondAudio = MediaPlayer.create(this, R.raw.apple);
                    thirdAudio = MediaPlayer.create(this, R.raw.banana);
                    fourthAudio = MediaPlayer.create(this, R.raw.carrot);
                    fifthAudio = MediaPlayer.create(this, R.raw.tomato);
                    sixthAudio = MediaPlayer.create(this, R.raw.eggplant);
                    seventhAudio = MediaPlayer.create(this, R.raw.orange);
                }

            MediaPlayer mediaPlayerFruit[]={introAudio, firstAudio, secondAudio, thirdAudio, fourthAudio, fifthAudio,sixthAudio,seventhAudio};
            mediaPlayer.add(mediaPlayerFruit);

            animate(imagePlace, imagesFruit, 0);
            currentArray=imagesFruit;
        }
        if (type.equals("number"))
        {
            if(language.equals("turkish")) {
                firstAudio = MediaPlayer.create(this, R.raw.sayilar);
                secondAudio = MediaPlayer.create(this, R.raw.sifir);
                thirdAudio = MediaPlayer.create(this, R.raw.bir);
                fourthAudio = MediaPlayer.create(this, R.raw.iki);
                fifthAudio = MediaPlayer.create(this, R.raw.uc);
                sixthAudio = MediaPlayer.create(this, R.raw.dort);
                seventhAudio = MediaPlayer.create(this, R.raw.bes);
                eightAudio = MediaPlayer.create(this, R.raw.alti);
                ninthAudio = MediaPlayer.create(this, R.raw.yedi);
                tenthAudio = MediaPlayer.create(this, R.raw.sekiz);
                eleventhAudio = MediaPlayer.create(this, R.raw.dokuz);
            }else{
                firstAudio = MediaPlayer.create(this, R.raw.numbers);
                secondAudio = MediaPlayer.create(this, R.raw.zero);
                thirdAudio = MediaPlayer.create(this, R.raw.one);
                fourthAudio = MediaPlayer.create(this, R.raw.two);
                fifthAudio = MediaPlayer.create(this, R.raw.three);
                sixthAudio = MediaPlayer.create(this, R.raw.four);
                seventhAudio = MediaPlayer.create(this, R.raw.five);
                eightAudio = MediaPlayer.create(this, R.raw.six);
                ninthAudio = MediaPlayer.create(this, R.raw.seven);
                tenthAudio = MediaPlayer.create(this, R.raw.eight);
                eleventhAudio = MediaPlayer.create(this, R.raw.nine);
            }
            MediaPlayer mediaPlayerNumber[]={firstAudio, secondAudio, thirdAudio, fourthAudio, fifthAudio, sixthAudio,seventhAudio,eightAudio,ninthAudio,tenthAudio,eleventhAudio};
            mediaPlayer.add(mediaPlayerNumber);



            animate(imagePlace, imagesNumber, 0);
            currentArray=imagesNumber;
        }
        if (type.equals("color"))
        {
            if(language.equals("turkish")) {
                introAudio = MediaPlayer.create(this, R.raw.renkler);
                firstAudio = MediaPlayer.create(this, R.raw.kirmizi);
                secondAudio = MediaPlayer.create(this, R.raw.mavi);
                thirdAudio = MediaPlayer.create(this, R.raw.yesil);
                fourthAudio = MediaPlayer.create(this, R.raw.sari);
                fifthAudio = MediaPlayer.create(this, R.raw.turuncu);
                sixthAudio = MediaPlayer.create(this, R.raw.mor);
            }else{
                introAudio = MediaPlayer.create(this, R.raw.colors);
                firstAudio = MediaPlayer.create(this, R.raw.red);
                secondAudio = MediaPlayer.create(this, R.raw.blue);
                thirdAudio = MediaPlayer.create(this, R.raw.green);
                fourthAudio = MediaPlayer.create(this, R.raw.yellow);
                fifthAudio = MediaPlayer.create(this, R.raw.orange);
                sixthAudio = MediaPlayer.create(this, R.raw.purple);
            }
            MediaPlayer mediaPlayerColor[]={introAudio,firstAudio, secondAudio, thirdAudio, fourthAudio, fifthAudio, sixthAudio};
            mediaPlayer.add(mediaPlayerColor);

            animate(imagePlace, imagesColor, 0);
            currentArray=imagesColor;
        }
        if (type.equals("shape"))
        {
            if(language.equals("turkish")) {
                introAudio = MediaPlayer.create(this, R.raw.sekiller);
                firstAudio = MediaPlayer.create(this, R.raw.kare);
                secondAudio = MediaPlayer.create(this, R.raw.yildiz);
                thirdAudio = MediaPlayer.create(this, R.raw.ucgen);
                fourthAudio = MediaPlayer.create(this, R.raw.daire);
            }else{
                introAudio = MediaPlayer.create(this, R.raw.shapes);
                firstAudio = MediaPlayer.create(this, R.raw.square);
                secondAudio = MediaPlayer.create(this, R.raw.star);
                thirdAudio = MediaPlayer.create(this, R.raw.triangle);
                fourthAudio = MediaPlayer.create(this, R.raw.circle);
            }

            MediaPlayer mediaPlayerAnimal[]={introAudio,firstAudio, secondAudio, thirdAudio, fourthAudio};
            mediaPlayer.add(mediaPlayerAnimal);

            animate(imagePlace, imagesShape, 0);
            currentArray=imagesShape;
        }





        repeat =(FloatingActionButton)findViewById(R.id.editFab);
        pause =(FloatingActionButton)findViewById(R.id.editFab3);
        home = (FloatingActionButton)findViewById(R.id.editFab4);

        pause.setImageResource(R.drawable.pause);

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeat.setClickable(false);
                current.stop();
                try {
                    current.prepare();
                    current = mediaPlayer.get(0)[index];
                    current.start();
                }catch(IOException e){

                }
                CountDownTimer cd =new CountDownTimer(1500,1500) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        repeat.setClickable(true);
                    }
                }.start();


            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(paused){
                    paused=false;

                    pause.setImageResource(R.drawable.pause);
                    if(index<currentArray.length) {
                        index++;
                        animate(imagePlace, currentArray, index);
                    }else{
                        index=0;
                        Intent i2=new Intent(LearningActivity.this,MenuActivity.class);
                        startActivity(i2);
                        finish();
                    }
                }else{
                    paused=true;
                    current.stop();
                    if(paused){
                        imagePlace.clearAnimation();
                        imagePlace.setVisibility(View.VISIBLE);
                        pause.setImageResource(R.drawable.play);
                    }

                }
            }
        });


        animate(imagePlace, currentArray, 0);

        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                current.stop();
                index=0;
                Intent i2=new Intent(LearningActivity.this,MenuActivity.class);
                startActivity(i2);
                finish();

            }
        });

    }
        private void animate(final ImageView imageView, final int images[], final int imageIndex) {

            //imageView <-- The View which displays the images
            //images[] <-- Holds R references to the images to display
            //imageIndex <-- index of the first image to show in images[]
            //forever <-- If equals true then after the last image it starts all over again with the first image resulting in an infinite loop. You have been warned.
                int timeBetween;
                current = mediaPlayer.get(0)[imageIndex];
                current.start();
                int fadeInDuration = 500; // Configure time values here
                if(type.equals("numbers")){
                    timeBetween = 1500;
                }else {
                    timeBetween = 2500;
                }
                int fadeOutDuration = 1000;
                imageView.setVisibility(View.INVISIBLE);    //Visible or invisible by default - this will apply when the animation ends
                imageView.setImageResource(images[imageIndex]);

                Animation fadeIn = new AlphaAnimation(0, 1);
                fadeIn.setInterpolator(new DecelerateInterpolator()); // add this
                fadeIn.setDuration(fadeInDuration);


                Animation fadeOut = new AlphaAnimation(1, 0);
                fadeOut.setInterpolator(new AccelerateInterpolator()); // and this
                fadeOut.setStartOffset(fadeInDuration + timeBetween);
                fadeOut.setDuration(fadeOutDuration);

                AnimationSet animation = new AnimationSet(false); // change to false

            animation.addAnimation(fadeIn);


                if(!paused) {

                    animation.addAnimation(fadeOut);
                    animation.setRepeatCount(1);

                }
            imageView.setAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationEnd(Animation animation) {

                        if (paused){

                        }
                    else if (images.length - 1 > index ) {
                                current.stop();
                                current.release();
                                index++;
                                animate(imageView, images, index); //Calls itself until it gets to the end of the array
                        } else {
                            index=0;
                            Intent i1 = new Intent(LearningActivity.this, MenuActivity.class);
                            startActivity(i1);
                            finish();
                        }
                    }

                    public void onAnimationRepeat(Animation animation) {

                    }

                    public void onAnimationStart(Animation animation) {

                    }
                });
            }


    @Override
    public void onBackPressed() {

        current.stop();
        index=0;
        Intent i2=new Intent(LearningActivity.this,MenuActivity.class);
        startActivity(i2);
        finish();
    }

}




