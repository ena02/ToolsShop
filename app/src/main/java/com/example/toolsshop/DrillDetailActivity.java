package com.example.toolsshop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DrillDetailActivity extends AppCompatActivity {

    private ImageView imageViewDrill;
    private TextView textViewTitle;
    private TextView textViewInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        imageViewDrill = findViewById(R.id.imageViewDrillIm);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewInfo = findViewById(R.id.textViewInfo);

        Intent intent = getIntent();

        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            int resId = intent.getIntExtra("resId", 0);
            imageViewDrill.setImageResource(resId);
            textViewTitle.setText(intent.getStringExtra("title"));
            textViewInfo.setText(intent.getStringExtra("info"));
        } else {
            Intent backToCategory = new Intent(this, DrillCategoryActivity.class);
            startActivity(backToCategory);
        }


    }
}