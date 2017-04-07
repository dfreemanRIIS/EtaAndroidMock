package com.example.dfreeman.etaandroidmock;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonParser {

    public ArrayList<String> parseRoutes(String jsonString) throws JSONException {
        //Create jsonArray for routeIDs
        final JSONArray routeID = new JSONArray(jsonString);

        //Get number of routes
        final int n = routeID.length();

        //for each route enter it into an array
        ArrayList<String> returnArray = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            final JSONObject instance = routeID.getJSONObject(i);
            returnArray.add(instance.getString("routeID"));
        }
        return returnArray;
    }
}