package com.example.dell.myapplication.mvp.model;

import android.util.Log;

import com.example.dell.myapplication.beans.ResultsBean;
import com.example.dell.myapplication.beans.RootBean;
import com.example.dell.myapplication.mvp.persenter.ICallBask;
import com.example.dell.myapplication.mvp.view.ApiSerivce;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 2019/5/29.
 */

public class Model implements Imodel {
    private static final String TAG = "Model";

    @Override
    public void getData(final ICallBask iCallBask) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiSerivce.mUrl)
                .build();
        retrofit.create(ApiSerivce.class).Data().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RootBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG, "onSubscribe: ");
                    }

                    @Override
                    public void onNext(RootBean rootBean) {
                        List<ResultsBean> results = rootBean.getResults();
                        iCallBask.Success(results);
                        Log.e(TAG, "onNext: " + results.size());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.getCause().getMessage());
                        iCallBask.Error(e.getCause().getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
