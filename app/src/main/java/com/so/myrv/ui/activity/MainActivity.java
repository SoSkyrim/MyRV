package com.so.myrv.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.so.myrv.R;
import com.so.myrv.ui.adapter.MyRVAdapter;
import com.so.myrv.utils.UIUtil;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRvMain;
    private MyRVAdapter mAdapter;
    private ArrayList<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRvMain = (RecyclerView) findViewById(R.id.rv_main);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        mRvMain.setLayoutManager(linearLayoutManager);
//        final GridLayoutManager gridLayoutManager
//                = new GridLayoutManager(this, 2);
//        mRvMain.setLayoutManager(gridLayoutManager);

        StaggeredGridLayoutManager staggeredGridLayoutManager
                = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mRvMain.setLayoutManager(staggeredGridLayoutManager);
//        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
//        linearLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
//        staggeredGridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);

        mAdapter = new MyRVAdapter(this);

        // 指定item宽度
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                if (position == 0
//                        || position == (mAdapter.getItemCount() - 1) / 2
//                        || position == (mAdapter.getItemCount() - 1)) {
//                    return gridLayoutManager.getSpanCount();
//                } else {
//                    return 1;
//                }
//            }
//        });

        mAdapter.setOnItemClickListener(new MyRVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(UIUtil.getContext(), "click" + position, Toast.LENGTH_SHORT).show();
                mAdapter.addData(1);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(UIUtil.getContext(), "long click" + position, Toast.LENGTH_SHORT).show();
                mAdapter.removeData(position);
            }
        });

        mRvMain.setAdapter(mAdapter);

        // 添加分割线
//        mRvMain.addItemDecoration(
//                new HorizontalDividerItemDecoration.Builder(this).build());
        mRvMain.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(this)
                        .color(Color.BLUE)
                        .sizeResId(R.dimen.two_dp)
                        .marginResId(R.dimen.eight_dp, R.dimen.eight_dp)
                        .build());

        mRvMain.addItemDecoration(
                new VerticalDividerItemDecoration.Builder(this).build());

//        mRvMain.setItemAnimator(new DefaultItemAnimator());
        mRvMain.setItemAnimator(new SlideInLeftAnimator());

        // 添加头尾
        HeaderAndFooterWrapper mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(mAdapter);

        TextView t1 = new TextView(this);
        t1.setText("Header 1");
        TextView t2 = new TextView(this);
        t2.setText("Header 2");
        mHeaderAndFooterWrapper.addHeaderView(t1);
        mHeaderAndFooterWrapper.addFootView(t2);

        mRvMain.setAdapter(mHeaderAndFooterWrapper);
        mHeaderAndFooterWrapper.notifyDataSetChanged();

//        // 添加数据
//        ArrayList<String> mDatas = new ArrayList<>();
//        for (int i = 0; i < 60; i++) {
//            mDatas.add("hello " + i);
//        }
//
//        mRvMain.setAdapter(new CommonAdapter<String>(this, R.layout.rv_txt_item, mDatas) {
//            @Override
//            protected void convert(ViewHolder holder, String s, int position) {
//                holder.setText(R.id.tv_txt, mDatas.get(position));
//            }
//        });

//        LoadMoreWrapper mLoadMoreWrapper = new LoadMoreWrapper(mAdapter);
//        mLoadMoreWrapper.setLoadMoreView(R.layout.rv_img_item);
//        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//            }
//        });
//
//        mRvMain.setAdapter(mLoadMoreWrapper);
    }
}
