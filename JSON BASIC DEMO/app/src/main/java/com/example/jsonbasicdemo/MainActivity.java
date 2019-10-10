package com.example.jsonbasicdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvDate;
    ImageView imgCover;
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = findViewById(R.id.tvTitle);
        tvDate = findViewById(R.id.tvDate);
        tvContent = findViewById(R.id.tvContent);
        imgCover = findViewById(R.id.imgCover);
        parserJSON();
    }

    private void parserJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIManager.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIManager service = retrofit.create(APIManager.class);

        //Call API
        service.getNews().enqueue(new Callback<NewsModel>() {

            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                    NewsModel model = response.body();
                    Log.d("NewsModel", model.getTitle());
                    tvTitle.setText(model.getTitle());
                    tvContent.setText(model.getContent());
                    tvDate.setText(model.getDate());
                    Glide.with(MainActivity.this).load(model.getImage()).into(imgCover);

            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

            }
        });


    }
}
