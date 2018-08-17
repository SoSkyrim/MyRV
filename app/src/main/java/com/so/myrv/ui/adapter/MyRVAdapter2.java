package com.so.myrv.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.so.myrv.R;

import java.util.ArrayList;

public class MyRVAdapter2 extends RecyclerView.Adapter<MyRVAdapter2.MyTVHolder> {

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private final ArrayList<String> mData;

    public MyRVAdapter2(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;

        mData = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            mData.add("hello " + i);
        }
    }

    @Override
    public MyRVAdapter2.MyTVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyRVAdapter2.MyTVHolder(mLayoutInflater.inflate(R.layout.rv_txt_item, parent, false));

    }

    @Override
    public void onBindViewHolder(MyRVAdapter2.MyTVHolder holder, int pos) {
        holder.mTextView.setText(mData.get(pos));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    class MyTVHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        MyTVHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_txt);
        }
    }
}


