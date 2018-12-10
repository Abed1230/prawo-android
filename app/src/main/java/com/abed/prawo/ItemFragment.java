package com.abed.prawo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ItemFragment extends Fragment {
    public static final String ARG_ITEMS_COUNT = "items_count";
    public static final String ARG_ITEM_INDEX = "item_index";
    public static final String ARG_IMAGE_PATH = "image_path";
    public static final String ARG_WORD = "word";
    public static final String ARG_TRANSLATED_WORD = "translated_word";
    public static final String ARG_SOUND_PATH = "sound_path";
    public static final String ARG_TRANSLATED_SOUND_PATH = "translated_sound_path";


    public ItemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item, container, false);
        Bundle args = getArguments();

        // Set image

        // Set words

        // Set sounds

        return rootView;
    }

}
