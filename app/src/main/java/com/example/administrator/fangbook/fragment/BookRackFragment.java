package com.example.administrator.fangbook.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.fangbook.R;
import com.example.administrator.fangbook.adapter.BookRackAdapter;
import com.example.administrator.fangbook.base.BaseFragment;

/**
 * 作者 ： liyinqing on 2018/10/19 0019
 * 邮箱 ：yinqing_521@163.com
 * 书架
 */
public class BookRackFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.book_rack_fragment_layout;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new BookRackAdapter(this));
    }

    public static BaseFragment getInstence() {
        return new BookRackFragment();
    }
}
