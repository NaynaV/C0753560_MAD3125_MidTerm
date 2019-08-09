package com.example.c0753560_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.util.ArrayList;

import com.android.volley.RequestQueue;

import com.android.volley.toolbox.Volley;
import com.example.c0753560_mad3125_midterm.JavaClass.FlightMain;
import com.example.c0753560_mad3125_midterm.JavaClass.Launch_Site;
import com.example.c0753560_mad3125_midterm.JavaClass.Links;
import com.example.c0753560_mad3125_midterm.JavaClass.Rocket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private FlightListAdaptor mflightAdapter;
    private ArrayList<FlightMain> mflightList;
    private RequestQueue mRequestQueue;


    Context context;


    public ArrayList<FlightMain> getmSpaceXFlightList() {
        return mflightList;
    }

    public MainActivity(Context context)
    {
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView FlightListRecycleView = findViewById(R.id.flightListRecyclerView);
        FlightListRecycleView.setLayoutManager(new LinearLayoutManager(this));

        mRequestQueue = Volley.newRequestQueue(this);
        processJSON();
        Log.d("Size of List : ",String.valueOf(mflightList.size()));
    }

   /* public void parseJSON()
    {
        String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String flightName = hit.getString("mission_name");
                                String flightImage = hit.getString("mission_patch_small");
                                String launchYear = hit.getString("launch_year");

                                mflightList.add(new FlightMain(flightName, flightImage, launchYear));
                            }

                            mflightAdapter = new FlightListAdaptor(MainActivity.this, mflightList);
                            mRecyclerView.setAdapter(mExampleAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }*/

    public String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = context.getAssets().open("Flight.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            int count = is.read(buffer);
            is.close();
            //Log.d("-- COUNT --", String.format("%d Bytes",count));
            json = new String(buffer, "UTF8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void processJSON()
    {
        String jsonString = this.loadJSONFromAsset();
        if (jsonString != null)
        {
            try {
                JSONArray mJSONArray = new JSONArray(jsonString);
                mflightList = new ArrayList<FlightMain>();

                for (int i = 0; i < mJSONArray.length(); i++) {

                    FlightMain mFlightMain = getFlightObjectFromJSON(mJSONArray.getJSONObject(i));
                    mflightList.add(mFlightMain);
                    //Log.d("-- JSON -- ", mSpaceXFlight.toString());

                }
            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }
        }
    }

    public FlightMain getFlightObjectFromJSON(JSONObject userJsonObject) throws JSONException
    {
        String flight_number = userJsonObject.getString("flight_number");
        String mission_name = userJsonObject.getString("mission_name");
        String upcoming = userJsonObject.getString("upcoming");
        String launch_year = userJsonObject.getString("launch_year");
        String launch_window = userJsonObject.getString("launch_window");
        String details = userJsonObject.getString("details");

        //Read Rocket
        JSONObject rocket = new JSONObject(userJsonObject.getJSONObject("rocket").toString());
        String rocket_id = rocket.getString("rocket_id");
        String rocket_name = rocket.getString("rocket_name");
        String rocket_type = rocket.getString("rocket_type");

        //Read Launch Site
        JSONObject launchSite = new JSONObject(userJsonObject.getJSONObject("launch_site").toString());
        String site_id = launchSite.getString("site_id");
        String site_name = launchSite.getString("site_name");
        String site_name_long = launchSite.getString("site_name_long");

        //Read Links
        JSONObject links = new JSONObject(userJsonObject.getJSONObject("links").toString());
        String mission_patch = links.getString("mission_patch");
        String mission_patch_small = links.getString("mission_patch_small");
        String article_link = links.getString("article_link");
        String wikipedia = links.getString("wikipedia");
        String video_link = links.getString("video_link");

        //start creating User object
        FlightMain mFlightMain = new FlightMain();
        mFlightMain.setFilghtNumber(flight_number);
        mFlightMain.setMissionName(mission_name);
        mFlightMain.setUpcoming(upcoming);
        mFlightMain.setLaunchYear(launch_year);
        mFlightMain.setLaunchWindow(launch_window);
        mFlightMain.setDetails(details);

        Rocket mRocket = new Rocket();
        mRocket.setRocketId(rocket_id);
        mRocket.setRocketName(rocket_name);
        mRocket.setRocketType(rocket_type);
        mFlightMain.setRocket(mRocket);

        Launch_Site mLaunchSite = new Launch_Site();
        mLaunchSite.setSiteID(site_id);
        mLaunchSite.setSiteName(site_name);
        mLaunchSite.setSiteNameLong(site_name_long);
        mFlightMain.setLaunchSite(mLaunchSite);

        Links mLinks = new Links();

        mLinks.setMissionPatchSmall(mission_patch_small);
        mLinks.setArticleLink(article_link);
        mLinks.setWikipedia(wikipedia);
        mLinks.setVideoLink(video_link);
        mFlightMain.setLinks(mLinks);

        return mFlightMain;
    }


}
