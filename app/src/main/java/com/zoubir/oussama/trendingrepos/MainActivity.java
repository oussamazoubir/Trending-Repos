package com.zoubir.oussama.trendingrepos;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by OussamaZoubir on 2/20/2018.
 */

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;
    int current_page = 1;
    private String URL;

    // URL to get contacts JSON
    private  static String url = "https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc&";

    ArrayList<HashMap<String, String>> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList = new ArrayList<>();

        lv = (ListView) findViewById(R.id.list);

        new GetItemlist().execute();
        // LoadMore button
        Button btnLoadMore = new Button(this);
        btnLoadMore.setText("Load More");

        // Adding Load More button to lisview at bottom
        lv.addFooterView(btnLoadMore);

        // Getting adapter

        /**
         * Listening to Load More button click event
         * */
        btnLoadMore.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Starting a new async task
                new GetMore().execute();
            }
        });
    }

    private class GetMore extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            current_page += 1;
            URL ="https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc&page="+current_page;

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(URL);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array
                    JSONArray items = jsonObj.getJSONArray("items");

                    // looping All Items
                    for (int i = 0; i < items.length(); i++) {
                        JSONObject c = items.getJSONObject(i);

                        String id = c.getString("id");
                        String name = c.getString("name");
                        String stargazers_count = c.getString("stargazers_count");
                        String description = c.getString("description");

                        // owner is JSON Object
                        JSONObject owner = c.getJSONObject("owner");
                        String login = owner.getString("login");

                        // hash map for single item
                        HashMap<String, String> item = new HashMap<>();

                        // adding to HashMap key => value
                        item.put("id", id);
                        item.put("name", name);
                        item.put("login", login);
                        item.put("stargazers_count", stargazers_count);
                        item.put("description", description);

                        // adding item to item list
                        itemList.add(item);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, itemList,
                    R.layout.list_item, new String[]{"name", "description", "login",
                    "stargazers_count"}, new int[]{R.id.name, R.id.description,
                    R.id.login, R.id.stargazers_count});

            lv.setAdapter(adapter);
        }

    }

    /**
     * Async task class to get json by making HTTP call
     */


    private class GetItemlist extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array
                    JSONArray items = jsonObj.getJSONArray("items");

                    // looping All Items
                    for (int i = 0; i < items.length(); i++) {
                        JSONObject c = items.getJSONObject(i);

                        String id = c.getString("id");
                        String name = c.getString("name");
                        String stargazers_count = c.getString("stargazers_count");
                        String description = c.getString("description");



                        // owner is JSON Object
                        JSONObject owner = c.getJSONObject("owner");
                        String login = owner.getString("login");

                        // hash map for single item
                        HashMap<String, String> item = new HashMap<>();

                        // adding  to HashMap key => value
                        item.put("id", id);
                        item.put("name", name);
                        item.put("login", login);
                        item.put("stargazers_count", stargazers_count);
                        item.put("description", description);
                        // adding item to item list
                        itemList.add(item);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, itemList,
                    R.layout.list_item, new String[]{"name", "description", "login",
                    "stargazers_count"}, new int[]{R.id.name, R.id.description,
                    R.id.login, R.id.stargazers_count});

            lv.setAdapter(adapter);
            url = "https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc&";
        }

    }

}