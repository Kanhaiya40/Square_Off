package com.alibi.squareoff;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibi.api_handler.ApiListener;
import com.alibi.api_handler.Controller;
import com.alibi.squareoff.adapter.LandscapeViewAdapter;
import com.alibi.squareoff.adapter.PortraitViewAdapter;
import com.alibi.squareoff.model.LandScapeData;
import com.alibi.squareoff.model.PortraitData;
import com.alibi.squareoff.model.TransResponse;
import com.alibi.squareoff.model.TransResponseData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Controller controller;
    List<TransResponseData> transResponseData;
    List<PortraitData> portraitData;
    List<LandScapeData> landScapeData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new Controller(this);
        recyclerView = findViewById(R.id.recyclerAdapter);
        portraitData = new ArrayList<>();
        landScapeData = new ArrayList<>();
        getData();

    }

    private void addLandScapeData() {
        Log.d("MainActivity", "addLandScapeData: " + transResponseData);
        for (TransResponseData data : transResponseData) {
            String noOfDashCharacter = calculate(data.getSlug());
            String year = calculateYear(data.getSlug());
            if (data.getImg() != null) {
                landScapeData.add(new LandScapeData(data.getName(), data.getImg()));
            } else {
                landScapeData.add(new LandScapeData(data.getName()));
            }

        }
    }

    private String calculateYear(String slug) {
        StringBuilder year = new StringBuilder();
        for (int i = 0; i < slug.length(); i++) {
            if (Character.isDigit(slug.charAt(i))) {
                year.append(slug.charAt(i));
            }
        }
        return year.toString();
    }

    private String calculate(String slug) {
        int noOfDashCharacter = 0;
        for (int i = 0; i < slug.length(); i++) {
            if (!Character.isLetterOrDigit(slug.charAt(i))) {
                noOfDashCharacter++;
            }
        }
        return String.valueOf(noOfDashCharacter);
    }

    private void addPortraitData() {
        for (TransResponseData data : transResponseData) {
            String noOfDashCharacter = calculate(data.getSlug());
            String year = calculateYear(data.getSlug());
            if (data.getImg() != null) {
                portraitData.add(new PortraitData(data.getName(), data.getSlug(), year, noOfDashCharacter, data.getImg()));
            } else {
                portraitData.add(new PortraitData(data.getName(), data.getSlug(), year, noOfDashCharacter));
            }

        }
    }

    public void getData() {

        controller.getUpdatedLocations(new ApiListener.OnGettingData() {
            @Override
            public void onSuccess(TransResponse transResponseListener) {
                transResponseData = transResponseListener.getTrns();
                Log.d("MainActivity", "onSuccess: " + transResponseData);
                addPortraitData();
                addLandScapeData();
                initPortraitRecycler(portraitData);
            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(MainActivity.this, "No Data Available", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            initPortraitRecycler(portraitData);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            initLandscapeRecycler(landScapeData);
        }
    }

    private void initLandscapeRecycler(List<LandScapeData> transResponseData) {
        LandscapeViewAdapter landscapeViewAdapter = new LandscapeViewAdapter(transResponseData, getApplicationContext());
        recyclerView.setAdapter(landscapeViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void initPortraitRecycler(List<PortraitData> transResponseData) {
        PortraitViewAdapter portraitViewAdapter = new PortraitViewAdapter(transResponseData, getApplicationContext());
        recyclerView.setAdapter(portraitViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}