package com.so.myrv.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.so.myrv.R;
import com.so.myrv.utils.UIUtil;

import java.util.ArrayList;

public class MyRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private final ArrayList<String> mData;

    public enum ITEM_TYPE {
        ITEM_TYPE_IMAGE,
        ITEM_TYPE_TEXT
    }

    public MyRVAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;

        mData = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            mData.add("hello " + i);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal()) {
            return new MyIVHolder(mLayoutInflater.inflate(R.layout.rv_img_item, parent, false));
        } else {
            return new MyTVHolder(mLayoutInflater.inflate(R.layout.rv_txt_item, parent, false));
        }
//        return new MyTVHolder(mLayoutInflater.inflate(R.layout.rv_cv_txt_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyTVHolder) {
            ((MyTVHolder) holder).mTextView.setText(mData.get(position));
        } else if (holder instanceof MyIVHolder) {
            ((MyIVHolder) holder).mImageView.setImageDrawable(UIUtil.getDrawable(R.mipmap.ic_launcher));
        }

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
//        if (position == 0
//                || position == (getItemCount() - 1) / 2
//                || position == (getItemCount() - 1)) {
//            return ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal();
//        } else {
//            return ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
//        }
        return ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
    }

    public class MyTVHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        private MyTVHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_txt);
        }
    }

    public class MyIVHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        MyIVHolder(View view) {
            super(view);
            mImageView = (ImageView) view.findViewById(R.id.iv_img);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void addData(int position) {
        mData.add(position, "hello x");
        notifyItemInserted(position);
    }

    public void removeData(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }
}