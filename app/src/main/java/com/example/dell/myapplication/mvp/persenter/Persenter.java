package com.example.dell.myapplication.mvp.persenter;

import com.example.dell.myapplication.beans.ResultsBean;
import com.example.dell.myapplication.mvp.model.Model;
import com.example.dell.myapplication.mvp.view.IView;

import java.util.List;

/**
 * Created by DELL on 2019/5/29.
 */

public class Persenter implements Ipersenter {
    private IView mIView;
    private final Model mModel;

    public Persenter(IView iView) {
        mIView = iView;
        mModel = new Model();
    }

    @Override
    public void setData() {
        if (mModel != null) {
            mModel.getData(new ICallBask() {
                @Override
                public void Success(List<ResultsBean> list) {
                    mIView.Success(list);
                }

                @Override
                public void Error(String error) {
                    mIView.equals(error);
                }
            });
        }
    }
}
