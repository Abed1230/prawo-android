package com.abed.prawo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class ItemsPagerAdapter extends FragmentStatePagerAdapter {
    private List<Item> data;

    public ItemsPagerAdapter(FragmentManager fm, List<Item> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt(ItemFragment.ARG_ITEMS_COUNT, getCount());
        args.putInt(ItemFragment.ARG_ITEM_INDEX, i);
        args.putString(ItemFragment.ARG_IMAGE_PATH, data.get(i).getImageFilePath());
        args.putString(ItemFragment.ARG_WORD, data.get(i).getWord());
        args.putString(ItemFragment.ARG_TRANSLATED_WORD, data.get(i).getTranslatedWord());
        args.putString(ItemFragment.ARG_SOUND_PATH, data.get(i).getSoundFilePath());
        args.putString(ItemFragment.ARG_TRANSLATED_SOUND_PATH, data.get(i).getTranslatedSoundFilePath());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
