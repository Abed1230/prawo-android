package com.abed.prawo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        List<Item> items = new ArrayList<>();
        items.add(new Item("", "Hello", "", "", ""));
        items.add(new Item("", "Bye", "", "", ""));

        ItemsPagerAdapter adapter = new ItemsPagerAdapter(getSupportFragmentManager(), items);
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(adapter);
    }
}
