package mini.minimini;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class RiddleActivity extends AppCompatActivity {

    ImageView a,b,c,d;
    FloatingActionButton repeat,shuffle,home;
    String answer;
    ArrayList<Riddle> riddles;
    SharedPreferences sharedPreferences;
    int questionIndex;
    boolean homeButtonPressed;
    String language;
    MediaPlayer firstAudio,secondAudio,thirdAudio,fourthAudio,fifthAudio,
            sixthAudio,seventhAudio,eigthAudio,ninthAudio,tenthAudio,eleventhAudio,
            twelvethAudio,thirteenthAudio,fourteenthAudio,fifteenthAudio,sixteenthAudio,
            seventeenthAudio,eightteenthAudio,nineteenthAudio,twentiethAudio,
            currentAudio,correctAudio,wrongAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        homeButtonPressed = false;
        setContentView(R.layout.activity_riddle);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        language = sharedPreferences.getString("language",null);

        if(language.equals("turkish")) {
            firstAudio = MediaPlayer.create(this, R.raw.daire);
            secondAudio = MediaPlayer.create(this, R.raw.kare);
            thirdAudio = MediaPlayer.create(this, R.raw.yildiz);
            fourthAudio = MediaPlayer.create(this, R.raw.ucgen);
            fifthAudio = MediaPlayer.create(this, R.raw.kedi);
            sixthAudio = MediaPlayer.create(this, R.raw.kopek);
            seventhAudio = MediaPlayer.create(this, R.raw.kus);
            eigthAudio = MediaPlayer.create(this, R.raw.balik);
            ninthAudio = MediaPlayer.create(this, R.raw.kanguru);
            tenthAudio = MediaPlayer.create(this, R.raw.aslan);
            eleventhAudio = MediaPlayer.create(this, R.raw.havuc);
            twelvethAudio = MediaPlayer.create(this, R.raw.cilek);
            thirteenthAudio = MediaPlayer.create(this, R.raw.elma);
            fourteenthAudio = MediaPlayer.create(this, R.raw.portakal);
            fifteenthAudio = MediaPlayer.create(this, R.raw.mavi);
            sixteenthAudio = MediaPlayer.create(this, R.raw.kirmizi);
            seventeenthAudio = MediaPlayer.create(this, R.raw.mor);
            eightteenthAudio = MediaPlayer.create(this, R.raw.yesil);
            nineteenthAudio = MediaPlayer.create(this, R.raw.sari);
            twentiethAudio = MediaPlayer.create(this, R.raw.turuncu);
            correctAudio = MediaPlayer.create(this,R.raw.dogru);
            wrongAudio =  MediaPlayer.create(this,R.raw.yanlis);
        }else{
            firstAudio = MediaPlayer.create(this, R.raw.circle);
            secondAudio = MediaPlayer.create(this, R.raw.square);
            thirdAudio = MediaPlayer.create(this, R.raw.star);
            fourthAudio = MediaPlayer.create(this, R.raw.triangle);
            fifthAudio = MediaPlayer.create(this, R.raw.cat);
            sixthAudio = MediaPlayer.create(this, R.raw.dog);
            seventhAudio = MediaPlayer.create(this, R.raw.bird);
            eigthAudio = MediaPlayer.create(this, R.raw.fish);
            ninthAudio = MediaPlayer.create(this, R.raw.kangaroo);
            tenthAudio = MediaPlayer.create(this, R.raw.lion);
            eleventhAudio = MediaPlayer.create(this, R.raw.carrot);
            twelvethAudio = MediaPlayer.create(this, R.raw.strawberry);
            thirteenthAudio = MediaPlayer.create(this, R.raw.apple);
            fourteenthAudio = MediaPlayer.create(this, R.raw.orange);
            fifteenthAudio = MediaPlayer.create(this, R.raw.blue);
            sixteenthAudio = MediaPlayer.create(this, R.raw.red);
            seventeenthAudio = MediaPlayer.create(this, R.raw.purple);
            eightteenthAudio = MediaPlayer.create(this, R.raw.green);
            nineteenthAudio = MediaPlayer.create(this, R.raw.yellow);
            twentiethAudio = MediaPlayer.create(this, R.raw.orange);
            correctAudio = MediaPlayer.create(this,R.raw.correct);
            wrongAudio =  MediaPlayer.create(this,R.raw.wrong);
        }



        Riddle one = new Riddle(firstAudio,R.drawable.circle,R.drawable.square,R.drawable.star,R.drawable.triangle,"a");
        Riddle two = new Riddle(secondAudio,R.drawable.circle,R.drawable.square,R.drawable.star,R.drawable.triangle,"b");
        Riddle three = new Riddle(thirdAudio,R.drawable.circle,R.drawable.square,R.drawable.star,R.drawable.triangle,"c");
        Riddle four = new Riddle(fourthAudio,R.drawable.circle,R.drawable.square,R.drawable.star,R.drawable.triangle,"d");
        Riddle five= new Riddle(fifthAudio,R.drawable.kedi,R.drawable.aslan,R.drawable.kopek,R.drawable.kanguru,"a");
        Riddle six = new Riddle(sixthAudio,R.drawable.tavuk,R.drawable.kus,R.drawable.kopek,R.drawable.balik,"c");
        Riddle seven = new Riddle(seventhAudio,R.drawable.kaplumbaga,R.drawable.aslan,R.drawable.at,R.drawable.kus,"d");
        Riddle eight = new Riddle(eigthAudio,R.drawable.kopek,R.drawable.kedi,R.drawable.kus,R.drawable.balik,"d");
        Riddle nine= new Riddle(ninthAudio,R.drawable.kanguru,R.drawable.kedi,R.drawable.kopek,R.drawable.kaplumbaga,"a");
        Riddle ten = new Riddle(tenthAudio,R.drawable.kus,R.drawable.kaplumbaga,R.drawable.aslan,R.drawable.at,"c");
        Riddle eleven = new Riddle(eleventhAudio,R.drawable.muz,R.drawable.havuc,R.drawable.patlican,R.drawable.domates,"b");
        Riddle twelve = new Riddle(twelvethAudio,R.drawable.elma,R.drawable.havuc,R.drawable.portakal,R.drawable.cilek,"d");
        Riddle thirteen= new Riddle(thirteenthAudio,R.drawable.elma,R.drawable.portakal,R.drawable.domates,R.drawable.patlican,"a");
        Riddle fourteen = new Riddle(fourteenthAudio,R.drawable.cilek,R.drawable.muz,R.drawable.portakal,R.drawable.domates,"c");
        Riddle fifteen = new Riddle(fifteenthAudio,R.drawable.orange,R.drawable.blue,R.drawable.green,R.drawable.red,"b");
        Riddle sixteen = new Riddle(sixteenthAudio,R.drawable.yellow,R.drawable.red,R.drawable.green,R.drawable.purple,"b");
        Riddle seventeen= new Riddle(seventeenthAudio,R.drawable.blue,R.drawable.yellow,R.drawable.orange,R.drawable.purple,"d");
        Riddle eightteen = new Riddle(eightteenthAudio,R.drawable.green,R.drawable.red,R.drawable.purple,R.drawable.yellow,"a");
        Riddle nineteen = new Riddle(nineteenthAudio,R.drawable.orange,R.drawable.yellow,R.drawable.blue,R.drawable.green,"b");
        Riddle twenty = new Riddle(twentiethAudio,R.drawable.purple,R.drawable.yellow,R.drawable.red,R.drawable.orange,"d");






        riddles =new ArrayList<Riddle>();
        riddles.add(one);riddles.add(two);riddles.add(three);riddles.add(four);
        riddles.add(five);riddles.add(six);riddles.add(seven);riddles.add(eight);
        riddles.add(nine);riddles.add(ten);riddles.add(eleven);riddles.add(twelve);
        riddles.add(thirteen);riddles.add(fourteen);riddles.add(fifteen);riddles.add(sixteen);
        riddles.add(seventeen);riddles.add(eightteen);riddles.add(nineteen);riddles.add(twenty);


        a =(ImageView)findViewById(R.id.image_a);
        b =(ImageView)findViewById(R.id.image_b);
        c =(ImageView)findViewById(R.id.image_c);
        d =(ImageView)findViewById(R.id.image_d);



        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer.equals("a")){
                    correctAudio.start();
                    b.setAlpha(50);
                    c.setAlpha(50);
                    d.setAlpha(50);
                    setButtonsUnclickable();
                    CountDownTimer cd =new CountDownTimer(2000,1000) {
                        @Override
                        public void onTick(long l) {
                        }

                        @Override
                        public void onFinish() {
                            setButtonsClickable();
                            askRiddle();
                            b.setAlpha(255);
                            c.setAlpha(255);
                            d.setAlpha(255);
                        }
                    }.start();

                }else{
                    wrongAudio.start();
                    setButtonsUnclickable();
                    a.setAlpha(50);
                    CountDownTimer cd =new CountDownTimer(1500,1000) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            a.setAlpha(255);
                            setButtonsClickable();
                        }
                    }.start();
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer.equals("b")){
                    correctAudio.start();
                    setButtonsUnclickable();
                    a.setAlpha(50);
                    c.setAlpha(50);
                    d.setAlpha(50);
                    CountDownTimer cd =new CountDownTimer(2000,1000) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            a.setAlpha(255);
                            c.setAlpha(255);
                            d.setAlpha(255);
                            setButtonsClickable();
                            askRiddle();
                        }
                    }.start();

                }else{
                    wrongAudio.start();
                    setButtonsUnclickable();
                    b.setAlpha(50);
                    CountDownTimer cd =new CountDownTimer(1500,1000) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            b.setAlpha(255);
                            setButtonsClickable();
                        }
                    }.start();
                }
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer.equals("c")){
                    correctAudio.start();
                    setButtonsUnclickable();
                    a.setAlpha(50);
                    b.setAlpha(50);
                    d.setAlpha(50);
                    CountDownTimer cd =new CountDownTimer(2000,1000) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            a.setAlpha(255);
                            b.setAlpha(255);
                            d.setAlpha(255);
                            setButtonsClickable();
                            askRiddle();
                        }
                    }.start();

                }else{
                    wrongAudio.start();
                    setButtonsUnclickable();
                    c.setAlpha(50);
                    CountDownTimer cd =new CountDownTimer(1500,1000) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            c.setAlpha(255);
                            setButtonsClickable();

                        }
                    }.start();
                }
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer.equals("d")){
                    correctAudio.start();
                    setButtonsUnclickable();
                    a.setAlpha(50);
                    b.setAlpha(50);
                    c.setAlpha(50);
                    CountDownTimer cd =new CountDownTimer(2000,1000) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            a.setAlpha(255);
                            b.setAlpha(255);
                            c.setAlpha(255);
                            setButtonsClickable();
                            askRiddle();
                        }
                    }.start();

                }else{
                    wrongAudio.start();
                    setButtonsUnclickable();
                    d.setAlpha(50);
                    CountDownTimer cd =new CountDownTimer(1500,1000) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            d.setAlpha(255);
                            setButtonsClickable();
                        }
                    }.start();

                }
            }
        });
        repeat = (FloatingActionButton)findViewById(R.id.riddle_action_button_one);
        shuffle = (FloatingActionButton)findViewById(R.id.riddle_action_button_two);
        home = (FloatingActionButton)findViewById(R.id.riddle_action_button_three);

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAudio.start();
            }
        });

        shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askRiddle();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAudio.stop();
                questionIndex=0;
                homeButtonPressed = true;
                Intent i2=new Intent(RiddleActivity.this,MenuActivity.class);
                startActivity(i2);
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        CountDownTimer cd =new CountDownTimer(500,250) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                askRiddle();
            }
        }.start();
    }

    public void askRiddle(){
        Random rnd=new Random();
        questionIndex = rnd.nextInt(riddles.size());
        Riddle currentRiddle = riddles.get(questionIndex);
        a.setImageResource(currentRiddle.getImageA());
        b.setImageResource(currentRiddle.getImageB());
        c.setImageResource(currentRiddle.getImageC());
        d.setImageResource(currentRiddle.getImageD());
        answer = currentRiddle.getAnswer();
        currentAudio = currentRiddle.getMediaPlayer();
        if(!homeButtonPressed)
            currentAudio.start();
    }
    public void setButtonsClickable(){
        a.setClickable(true);
        b.setClickable(true);
        c.setClickable(true);
        d.setClickable(true);
    }
    public void setButtonsUnclickable(){
        a.setClickable(false);
        b.setClickable(false);
        c.setClickable(false);
        d.setClickable(false);
    }

}
