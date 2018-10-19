package com.example.administrator.fangbook;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.fangbook.base.BaseActivity;
import com.example.administrator.fangbook.base.BaseFragment;
import com.example.administrator.fangbook.fragment.BookRackFragment;
import com.example.administrator.fangbook.fragment.ClassifiedFragment;
import com.example.administrator.fangbook.view.CircleImageView;
import com.example.administrator.fangbook.view.ResideLayout;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private ResideLayout mResideLayout;
    private CircleImageView mMain_icon;
    private TextView mMain_login;
    private TextView mMain_classified;
    private TextView mMain_bookrack;
    private TextView mMain_scan;
    private TextView mMain_feedback;
    private TextView mMain_author;
    private TextView mMain_theme;
    private TextView mMain_button_login;
    private TextView mTitle;
    private FrameLayout mFl_content;
    private ArrayList<BaseFragment> fragments;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mResideLayout = (ResideLayout) findViewById(R.id.resideLayout);
        mMain_icon = (CircleImageView) findViewById(R.id.main_icon);
        mMain_login = (TextView) findViewById(R.id.main_login);
        mMain_classified = (TextView) findViewById(R.id.main_classified);
        mMain_bookrack = (TextView) findViewById(R.id.main_bookrack);
        mMain_scan = (TextView) findViewById(R.id.main_scan);
        mMain_feedback = (TextView) findViewById(R.id.main_feedback);
        mMain_author = (TextView) findViewById(R.id.main_author);
        mMain_theme = (TextView) findViewById(R.id.main_theme);
        mMain_button_login = (TextView) findViewById(R.id.main_button_login);
        mTitle = (TextView) findViewById(R.id.title);
        mFl_content = (FrameLayout) findViewById(R.id.fl_content);
        mMain_icon.setOnClickListener(this);
        mMain_login.setOnClickListener(this);
        mMain_classified.setOnClickListener(this);
        mMain_bookrack.setOnClickListener(this);
        mMain_scan.setOnClickListener(this);
        mMain_feedback.setOnClickListener(this);
        mMain_author.setOnClickListener(this);
        mMain_theme.setOnClickListener(this);
        mMain_button_login.setOnClickListener(this);
        initFragment();
        selectFragment(1);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(ClassifiedFragment.getInstence());
        fragments.add(BookRackFragment.getInstence());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.main_icon) {
            //头像
        } else if (v.getId() == R.id.main_login) {
            //未登录
        } else if (v.getId() == R.id.main_scan) {
            //扫描书籍
        } else if (v.getId() == R.id.main_feedback) {
            //意见反馈
        } else if (v.getId() == R.id.main_author) {
            //关于作者
        } else if (v.getId() == R.id.main_theme) {
            //样式
        } else if (v.getId() == R.id.main_button_login) {
            //登陆
        } else if (v.getId() == R.id.main_classified || v.getId() == R.id.main_bookrack) {
            int position = 0;
            if (v.getId() == R.id.main_classified) {
                //分类
                position = 0;
                mTitle.setText("分类");
            }
            if (v.getId() == R.id.main_bookrack) {
                //书架
                position = 1;
                mTitle.setText("书架");
            }
            selectFragment(position);
            mResideLayout.closePane();
        }
    }

    private BaseFragment currentFragment;

    private void selectFragment(int position) {
        BaseFragment baseFragment = fragments.get(position);
        if (currentFragment == baseFragment) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }
        if (baseFragment.isAdded()) {
            transaction.show(baseFragment);
        } else {
            transaction.add(R.id.fl_content, baseFragment);
        }
        transaction.commitAllowingStateLoss();
        currentFragment = baseFragment;
    }
}
