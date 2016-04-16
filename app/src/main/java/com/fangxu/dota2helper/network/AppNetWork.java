package com.fangxu.dota2helper.network;



import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Xuf on 2016/4/6.
 */
public enum AppNetWork {
    INSTANCE;

    private NewsApi mNewsApi;
    private NewsDetailApi mNewsDetailApi;

    AppNetWork() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dota2server.applinzi.com")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mNewsApi = retrofit.create(NewsApi.class);

        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("http://dota2server.applinzi.com")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        mNewsDetailApi = retrofit1.create(NewsDetailApi.class);
    }

    public NewsApi getNewsApi() {
        return mNewsApi;
    }

    public NewsDetailApi getNewsDetailApi() {
        return mNewsDetailApi;
    }
}
