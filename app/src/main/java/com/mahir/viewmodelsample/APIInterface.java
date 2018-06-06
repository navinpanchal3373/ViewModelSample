package com.mahir.viewmodelsample;

import com.mahir.viewmodelsample.model.CountryPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface APIInterface {

    @GET("rest/v2/")
    Call<List<CountryPojo>> getCountryListData();
}