package com.example.jsonbasicdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIManager {
    String SERVER_URL = "http://tommyprivateguide.com/";

    @GET("/data.json")
    Call<NewsModel> getNews();

//    @GET("/wp-json/wp/v2/posts")
//    Call<List<PostModel>> getListNews(@Query("page") String page, @Query("per_page") String per_page);



}
