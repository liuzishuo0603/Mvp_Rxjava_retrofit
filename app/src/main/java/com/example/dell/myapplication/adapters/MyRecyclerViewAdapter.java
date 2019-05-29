package com.example.dell.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dell.myapplication.R;
import com.example.dell.myapplication.beans.ResultsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2019/5/29.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter {
    private Context mContext;
    public List<ResultsBean> mList = new ArrayList<>();

    public MyRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.my_item_list, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        ResultsBean bean = mList.get(position);
        Glide.with(mContext).load(bean.getUrl()).apply(RequestOptions.circleCropTransform()).placeholder(R.mipmap.ic_launcher).into(viewHolder.mIv);
        viewHolder.mTv.setText(bean.getDesc());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIv;
        private TextView mTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            mIv = itemView.findViewById(R.id.iv);
            mTv = itemView.findViewById(R.id.tv);
        }
    }
}
