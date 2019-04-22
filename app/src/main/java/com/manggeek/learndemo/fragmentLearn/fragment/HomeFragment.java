package com.manggeek.learndemo.fragmentLearn.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.manggeek.android.geek.GeekFragment;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.fragmentLearn.fragment.testFragment.FourFragment;
import com.manggeek.learndemo.fragmentLearn.fragment.testFragment.OneFragment;
import com.manggeek.learndemo.fragmentLearn.fragment.testFragment.ThreeFragment;
import com.manggeek.learndemo.fragmentLearn.fragment.testFragment.TwoFragment;

import java.util.ArrayList;

/**
 * Created by zhangshengwei
 * Time: 2018/11/22 14:55
 * describe:
 */
public class HomeFragment extends GeekFragment implements ViewPager.OnPageChangeListener {

    private @FindViewById(id = R.id.option) RadioGroup radioGroup;
    private @FindViewById(id = R.id.viewpager) ViewPager viewPager;

    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private OneFragment oneFragment;                 //全部----》修改为已取消
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = setContentView(inflater, R.layout.fragment_home, container, false);
        initData();
        radioGroup.check(R.id.firstRb);
        radioGroup.setOnCheckedChangeListener(mCheckChangedListener);
        initFragments();
        return view;
    }

    private void initFragments() {
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        fourFragment = new FourFragment();

        fragmentArrayList.add(oneFragment);
        fragmentArrayList.add(twoFragment);
        fragmentArrayList.add(threeFragment);
        fragmentArrayList.add(fourFragment);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        viewPager.addOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(radioGroup.getChildCount());


    }


    private RadioGroup.OnCheckedChangeListener mCheckChangedListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.firstRb:
                    viewPager.setCurrentItem(0, true);
                    break;
                case R.id.secondRb:
                    viewPager.setCurrentItem(1, true);
                    break;
                case R.id.thirdRb:
                    viewPager.setCurrentItem(2, true);
                    break;
                case R.id.fourthRb:
                    viewPager.setCurrentItem(3, true);
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



    public void initData() {
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                radioGroup.check(R.id.firstRb);
                break;
            case 1:
                radioGroup.check(R.id.secondRb);
                break;
            case 2:
                radioGroup.check(R.id.thirdRb);
                break;
            case 3:
                radioGroup.check(R.id.fourthRb);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
