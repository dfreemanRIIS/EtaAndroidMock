package com.example.dfreeman.etaandroidmock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CompanyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        String[] busNamesArray = getResources().getStringArray(R.array.busnames);
        ListView busListView = (ListView) findViewById(R.id.busses);
        busListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, busNamesArray));

        //Go to RouteActivity and pass company
        busListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CompanyActivity.this, RouteActivity.class);
                intent.putExtra(RouteActivity.EXTRA_COMPANY, position + 1);
                startActivity(intent);
            }
        });
    }
}
