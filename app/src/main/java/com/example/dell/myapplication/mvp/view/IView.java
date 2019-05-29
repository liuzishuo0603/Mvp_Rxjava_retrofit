package com.example.dell.myapplication.mvp.view;

import com.example.dell.myapplication.beans.ResultsBean;

import java.util.List;

/**
 * Created by DELL on 2019/5/29.
 */

public interface IView {
    void Success(List<ResultsBean> list);

    void Error(String error);
}
