package com.jools625.the_stanley_parable_text_game.museum_ending;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.jools625.the_stanley_parable_text_game.AudioPlayer;
import com.jools625.the_stanley_parable_text_game.R;

public class StanleyInMuseum extends AppCompatActivity {

    int[] audioIDs = {R.raw.femnarr_3_00, R.raw.femnarr_3_01};
    ImageButton nextButton, prevButton;
    Button option1;
    AudioPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stanley_in_museum);
        nextButton = findViewById(R.id.buttonNext);
        prevButton = findViewById(R.id.buttonPrev);
        option1 = findViewById(R.id.buttonOption1);

        audio = new AudioPlayer(audioIDs, getApplicationContext());
        audio.playAudio();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.stopAudio();
                audio.nextTrack();
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.stopAudio();
                audio.prevTrack();
            }
        });
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audio.stopAudio();
                Intent nextScreen = new Intent(StanleyInMuseum.this, DarkRoom.class);
                startActivity(nextScreen);
                finish();
            }
        });

    }
    @Override
    protected void onPause() {
        super.onPause();
        if ((audio!= null) && (audio.isPlaying()))
        {
            audio.pause();
        }
    }
}
