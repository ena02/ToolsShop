package com.example.toolsshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DrillCategoryActivity extends AppCompatActivity {

    private ListView listViewDrills;

    private List<Drill> drillList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        drillList = new ArrayList<>();
        drillList.add(new Drill(getString(R.string.drill_interskol_title), getString(R.string.drill_interskol_info), R.drawable.interskol));
        drillList.add(new Drill(getString(R.string.drill_makita_title), getString(R.string.drill_makita_info), R.drawable.makita));
        drillList.add(new Drill(getString(R.string.drill_dewalt_title), getString(R.string.drill_dewalt_info), R.drawable.dewalt));
        listViewDrills = findViewById(R.id.listViewDrills);
        ArrayAdapter<Drill> adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, drillList);
        listViewDrills.setAdapter(adapter);
        listViewDrills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Drill drill = drillList.get(i);
                Intent intent = new Intent(getApplicationContext(), DrillDetailActivity.class);
                intent.putExtra("title", drill.getTitle());
                intent.putExtra("info", drill.getInfo());
                intent.putExtra("resId", drill.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}