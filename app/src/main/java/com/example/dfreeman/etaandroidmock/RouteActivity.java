package com.example.dfreeman.etaandroidmock;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class RouteActivity extends AppCompatActivity {

    public static final String EXTRA_COMPANY = "company";
    private ListView routeList;
    private String jsonString;
    private int companyNumber;
    private ArrayList<String> routeNumbersArray;
    private JsonParser jsonParser;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        Intent intent = getIntent();
        companyNumber = intent.getIntExtra(EXTRA_COMPANY, -1);
        jsonParser = new JsonParser();
        context = this;

        routeList = (ListView) findViewById(R.id.routes);

        new AsyncCaller().execute();
    }

    private class AsyncCaller extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            JsonFetcher jsonFetcher = new JsonFetcher();
            UrlStringBuilder urlStringBuilder = new UrlStringBuilder();
            try {
                jsonString = jsonFetcher.fetchUrl(urlStringBuilder.getRoutesUrl(companyNumber));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            try {
                routeNumbersArray = jsonParser.parseRoutes(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }
            routeList.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, routeNumbersArray));
        }
    }
}

