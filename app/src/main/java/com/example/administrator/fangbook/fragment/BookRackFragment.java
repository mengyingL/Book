package com.example.administrator.fangbook.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.fangbook.R;
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
//        TextView textView = view.findViewById(R.id.tv);
//        textView.setText("书架");
    }

    public static BaseFragment getInstence() {
        return new BookRackFragment();
    }
}
