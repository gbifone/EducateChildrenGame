package mini.minimini;

import android.media.MediaPlayer;
import android.widget.ImageView;

/**
 * Created by ABRA A5 on 22.10.2017.
 */

public class Riddle {


    MediaPlayer  mediaPlayer;
    int    imageA;
    int    imageB;
    int    imageC;
    int    imageD;
    String answer;




    public Riddle(MediaPlayer mediaPlayer, int imageA, int imageB, int imageC, int imageD, String answer) {
        this.mediaPlayer = mediaPlayer;
        this.imageA = imageA;
        this.imageB = imageB;
        this.imageC = imageC;
        this.imageD = imageD;
        this.answer = answer;
    }



    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public int getImageA() {
        return imageA;
    }

    public void setImageA(int imageA) {
        this.imageA = imageA;
    }

    public int getImageB() {
        return imageB;
    }

    public void setImageB(int imageB) {
        this.imageB = imageB;
    }

    public int getImageC() {
        return imageC;
    }

    public void setImageC(int imageC) {
        this.imageC = imageC;
    }

    public int getImageD() {
        return imageD;
    }

    public void setImageD(int imageD) {
        this.imageD = imageD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    @Override
    public String toString() {
        return "Riddle{" +
                "mediaPlayer=" + mediaPlayer +
                ", imageA=" + imageA +
                ", imageB=" + imageB +
                ", imageC=" + imageC +
                ", imageD=" + imageD +
                ", answer='" + answer + '\'' +
                '}';
    }


}
