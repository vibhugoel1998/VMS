package com.example.vibhu.vms;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface customapi {
    @GET("/meow.php")
    Call<List<heirarchynew>> checkapi();

    @GET("/sih/public/parameters")
    Call<List<paramobj>> fetchdata();

    @GET("/sih/public/output")
    Call<List<outobj>> fetchout();

}
