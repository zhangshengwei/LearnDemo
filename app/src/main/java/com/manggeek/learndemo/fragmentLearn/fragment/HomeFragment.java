package com.manggeek.learndemo.fragmentLearn.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.manggeek.android.geek.GeekFragment;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.fragmentLearn.fragment.testFragment.FiveFragment;
import com.manggeek.learndemo.fragmentLearn.fragment.testFragment.FourFragment;
import com.manggeek.learndemo.fragmentLearn.fragment.testFragment.OneFragment;
import com.manggeek.learndemo.fragmentLearn.fragment.testFragment.SixFragment;
import com.manggeek.learndemo.fragmentLearn.fragment.testFragment.ThreeFragment;
import com.manggeek.learndemo.fragmentLearn.fragment.testFragment.TwoFragment;

import java.util.ArrayList;

/**
 * Created by zhangshengwei
 * Time: 2018/11/22 14:55
 * describe: Fragmnet模块测试，首页
 */
public class HomeFragment extends GeekFragment implements ViewPager.OnPageChangeListener {

    private static final String TAG = "---->>HomeFragment";

    private @FindViewById(id = R.id.one_option) RadioGroup oneOption;
    private @FindViewById(id = R.id.viewpager) ViewPager viewPager;

    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private OneFragment oneFragment;
    private TwoFragment twoFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = setContentView(inflater, R.layout.fragment_home, container, false);
        oneOption.check(R.id.firstRb);
        oneOption.setOnCheckedChangeListener(topRgChangeListener);
        initFragments();
        return view;
    }

    private void initFragments() {
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();

        fragmentArrayList.add(oneFragment);
        fragmentArrayList.add(twoFragment);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        viewPager.addOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(fragmentArrayList.size());
    }


    //第一层的RG
    private RadioGroup.OnCheckedChangeListener topRgChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.firstRb:
                    viewPager.setCurrentItem(0, true);
                    break;
                case R.id.secondRb:
                    viewPager.setCurrentItem(1, true);
                    break;
                default:
                    break;
            }
        }
    };




    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d(TAG, "onPageSelected: " + position);
        switch (position) {
            case 0:
                oneOption.check(R.id.firstRb);
                break;
            case 1:
                oneOption.check(R.id.secondRb);
                break;

            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
