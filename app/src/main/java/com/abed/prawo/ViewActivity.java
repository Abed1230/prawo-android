package com.abed.prawo;

import android.content.res.AssetFileDescriptor;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ViewActivity extends AppCompatActivity {

    private static final String TAG = ViewActivity.class.getSimpleName();

    private List<Item> items;
    private int index;

    private ImageView imv;
    private TextView tvWord;
    private TextView tvTranslatedWord;
    private TextView tvCount;
    private Button btnPrev;
    private Button btnNext;
    private Button btnDone;

    private MediaPlayer mpOriginalSound;
    private MediaPlayer mpTranslatedSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        initViews();

        if (items == null)
            items = new ArrayList<>();

        // TODO save and retrieve from saved instance state
        index = 0;

        if (mpOriginalSound == null)
            mpOriginalSound = new MediaPlayer();
        if (mpTranslatedSound == null)
            mpTranslatedSound = new MediaPlayer();

        createTestData();
        updateView();

        tvWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpOriginalSound.start();
            }
        });

        tvTranslatedWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpTranslatedSound.start();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index--;
                updateView();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                updateView();
            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initViews() {
        imv = findViewById(R.id.imageView);
        tvWord = findViewById(R.id.tv_word);
        tvTranslatedWord = findViewById(R.id.tv_translated_word);
        tvCount = findViewById(R.id.tv_count);
        btnPrev =  findViewById(R.id.btn_previous);
        btnNext =  findViewById(R.id.btn_next);
        btnDone = findViewById(R.id.btn_done);

        btnPrev.setVisibility(View.GONE);
    }

    private void updateView() {
        // set visibility
        if (index < 1)
            btnPrev.setVisibility(View.GONE);
        else
            btnPrev.setVisibility(View.VISIBLE);

        if (index == items.size()-1) {
            btnNext.setVisibility(View.GONE);
            btnDone.setVisibility(View.VISIBLE);
        } else {
            btnNext.setVisibility(View.VISIBLE);
            btnDone.setVisibility(View.GONE);
        }

        //set image
        try {
            InputStream in = getAssets().open(items.get(index).getImageUrl());
            Drawable d = Drawable.createFromStream(in, null);
            imv.setImageDrawable(d);
        } catch (Exception e) {
            Log.e(TAG, "error loading image: " + e);
            imv.setImageDrawable(null);
        }

        //set words
        tvWord.setText(capitalizeFirstLetter(items.get(index).getWord()));
        tvTranslatedWord.setText(capitalizeFirstLetter(items.get(index).getTranslatedWord()));

        //set audio
        try {
            AssetFileDescriptor afd = getAssets().openFd(items.get(index).getSoundUrl());
            mpOriginalSound.reset();
            mpOriginalSound.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mpOriginalSound.prepare();
        } catch (Exception e) {
            Log.e(TAG, "error loading sound: " + e);
        }

        try {
            AssetFileDescriptor afd = getAssets().openFd(items.get(index).getTranslatedSoundUrl());
            mpTranslatedSound.reset();
            mpTranslatedSound.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mpTranslatedSound.prepare();

        } catch (Exception e) {
            Log.e(TAG, "error loading sound: " + e);
        }

        //set count text
        String t = index+1 + "/" + items.size();
        tvCount.setText(t);
    }

    private String capitalizeFirstLetter(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }

    private void createTestData() {
        Item item1 = new Item("item1_image.jpg", "hej", "hi", "item1_sound1.mp3", "item1_sound2.mp3");
        Item item2 = new Item("", "hur mår du idag brorsan haha?", "how are you today brother haha?", "item1_sound1.mp3", "item1_sound2.mp3");
        Item item3 = new Item("item3_image.png", "hejdå", "bye", "item3_sound.mp3", "item3_sound2.mp3");

        items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
    }

}
