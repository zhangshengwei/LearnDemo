package com.manggeek.learndemo.activityLearn.UI;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.View.MySmartRefreshLayout;
import com.manggeek.learndemo.adapter.RecyclerviewAdapter;
import com.manggeek.learndemo.control.BaseActivity;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/2/1 10:39 AM
 */
public class SmartRefreshActivity extends BaseActivity implements OnRefreshLoadMoreListener {

    private @FindViewById(id =  R.id.my_smart_refresh) MySmartRefreshLayout refreshLayout;
    private @FindViewById(id = R.id.recyclerView) RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private List<Object> mDataList = new ArrayList<>();
    private RecyclerviewAdapter adapter;
    private int loadType;                       //区分加载刷新

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_refresh);
        initView();//111
        initData();

    }

    private void initData() {
        mDataList.clear();
        for (int i = 0;i<10;i++){
            mDataList.add("aaa+"+i);
        }
        adapter.notifyDataSetChanged();
        finishLoad(mDataList);
    }

    /**
     * 获取更多数据
     */
    private void loadData() {
        for (int i = 0; i < 10; ++i) {
            mDataList.add("No." + i + " Normal Data");
        }
        adapter.notifyDataSetChanged();
        finishLoad(mDataList);
    }


    private void initView() {
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerviewAdapter(mActivity,mDataList);
        recyclerView.setAdapter(adapter);
        refreshLayout.setOnRefreshLoadMoreListener(this);
        refreshLayout.autoRefresh();
    }



    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        loadType = MySmartRefreshLayout.TYPE_LOAD_MORE;
        loadData();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        loadType = MySmartRefreshLayout.TYPE_FRESH;
        initData();

    }


    /**
     * 获取结束
     */
    private void finishLoad(List<Object> nativeAdList) {
        refreshLayout.finish(loadType, nativeAdList != null && nativeAdList.size() > 0, false);
        if (nativeAdList != null && nativeAdList.size() > 0) {
            mDataList.addAll(nativeAdList);
        }
        adapter.notifyDataSetChanged();
    }

//    private RecyAda
}
