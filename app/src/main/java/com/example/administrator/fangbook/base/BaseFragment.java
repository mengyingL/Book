package com.example.administrator.fangbook.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者 ： liyinqing on 2018/10/19 0019
 * 邮箱 ：yinqing_521@163.com
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), null);
    }

    protected abstract int getLayoutId();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState==null){
            savedInstanceState=getArguments();
        }
        initView(view,savedInstanceState);
    }

    protected abstract void initView(View view,Bundle savedInstanceState);
}
