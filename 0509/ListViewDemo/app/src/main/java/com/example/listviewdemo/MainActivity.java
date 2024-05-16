package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    private String[] cities;
    private Spinner spCities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities=getResources().getStringArray(R.array.cities);
        lv =(ListView) findViewById(R.id.listview);

        /*ArrayAdapter<String> adpcities =new ArrayAdapter<>(this,
                android.R.layout.simple_selectable_list_item,cities);
        spCities.setAdapter(adpcities);*/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView output =(TextView) findViewById(R.id.lblOutput);
                output.setText("你是住在:"+cities[position]);
                Toast.makeText(MainActivity.this,"你是住在:"+cities[position],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}