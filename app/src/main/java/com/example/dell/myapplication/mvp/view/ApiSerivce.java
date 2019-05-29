package com.example.dell.myapplication.mvp.view;

import com.example.dell.myapplication.beans.RootBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by DELL on 2019/5/29.
 */

public interface ApiSerivce {
    String mUrl = "http://gank.io/";

    @GET("api/data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<RootBean> Data();
}
