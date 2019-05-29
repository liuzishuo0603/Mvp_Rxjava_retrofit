package com.example.dell.myapplication;
//刘子硕/2019/5/29/18:52

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.dell.myapplication.adapters.MyRecyclerViewAdapter;
import com.example.dell.myapplication.beans.ResultsBean;
import com.example.dell.myapplication.mvp.persenter.Persenter;
import com.example.dell.myapplication.mvp.view.IView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {

    private RecyclerView mRlv;
    private MyRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        Persenter persenter = new Persenter(this);
        persenter.setData();
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mRlv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new MyRecyclerViewAdapter(this);
        mRlv.setAdapter(mAdapter);
    }

    @Override
    public void Success(List<ResultsBean> list) {
        mAdapter.mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void Error(String error) {
        Toast.makeText(this, "加载数据时出错" + error, Toast.LENGTH_SHORT).show();
    }
}
