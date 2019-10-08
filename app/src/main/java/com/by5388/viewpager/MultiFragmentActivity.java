package com.by5388.viewpager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.by5388.viewpager.adapter.FragmentAdapter;

import java.util.Arrays;

public class MultiFragmentActivity extends AppCompatActivity
        implements BaseFragment.FragmentCallBack, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private View mRootView;

    public static Intent newIntent(Context context) {
        return new Intent(context, MultiFragmentActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_fragment);
        mViewPager = findViewById(R.id.view_pager_multi);
        mRootView = findViewById(R.id.rootView);


        final int limit = 3;
        final String[] titles = getResources().getStringArray(R.array.array_titles);
        final FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), Arrays.asList(titles));


        mViewPager.setOffscreenPageLimit(limit);
        // TODO: 2019/10/8   dp 转化成像素值，而不是数值的上dp值
        mViewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.view_pager_margin));
        mViewPager.setAdapter(fragmentAdapter);
        mViewPager.addOnPageChangeListener(this);
        // TODO: 2019/10/8 点击事件的事件分发过程
        // 参考 https://blog.csdn.net/ouyang_peng/article/details/82563779
        mRootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, final MotionEvent event) {
                if (false) {
                    // TODO: 2019/10/8 规避警告：如果执行就会去执行onClick的回调(前提是已注册了事件响应)
                    mRootView.performClick();
                }
                return mViewPager.dispatchTouchEvent(event);
            }
        });
    }


    @Override
    public void setTitleByFragment(String title) {
        // TODO: 2019/10/8 这里的设置标题并没有效果
        setTitle(title);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void temp() {
    }
}
