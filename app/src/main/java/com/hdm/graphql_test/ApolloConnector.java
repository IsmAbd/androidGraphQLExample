package com.hdm.graphql_test;

import com.apollographql.apollo.ApolloClient;

import okhttp3.OkHttpClient;

public class ApolloConnector {

    private static final String BASE_URL = "http://10.0.2.2:5000/graphql";

    public static ApolloClient setupApollo(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        return ApolloClient.builder().serverUrl(BASE_URL).okHttpClient(okHttpClient).build();
    }

}
