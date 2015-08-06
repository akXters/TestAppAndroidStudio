package com.example.xters.testapp.interfaces;

import com.example.xters.testapp.model.Flower;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * @author Aleksandar Karafilovski
 *         Created on 8/5/15.
 */
public interface FlowersAPI {
    @GET("/feeds/flowers.json")
    void getFeed(Callback<List<Flower>> response);
}
