package com.hdm.graphql_test;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRetRestaurantByID();

    }

    private void getRetRestaurantByID(){

        ApolloConnector.setupApollo().query(
                RestaurantsQuery.builder().restaurantID("d5a1efd6-82ee-4c3a-8ae9-c788ddc1ceb1").build()
        ).enqueue(new ApolloCall.Callback<RestaurantsQuery.Data>() {
            @Override
            public void onResponse(@NotNull Response<RestaurantsQuery.Data> response) {

                Log.d(TAG, "Response: " + response.data().getRestaurantByID);

            }

            @Override
            public void onFailure(@NotNull ApolloException e) {

                Log.d(TAG, "Exception " + e.getMessage(), e);

            }
        });
    }
}
