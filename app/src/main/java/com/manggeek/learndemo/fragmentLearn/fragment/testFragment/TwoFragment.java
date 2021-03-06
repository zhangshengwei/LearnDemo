package com.manggeek.learndemo.fragmentLearn.fragment.testFragment;

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
import android.widget.TextView;

import com.manggeek.android.geek.GeekFragment;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.Entity.Student;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.View.ChildViewPager;

import java.util.ArrayList;

/**
 * Created by zhangshengwei
 * Time: 2018/11/22 15:20
 * describe:
 */
public class TwoFragment extends GeekFragment implements ViewPager.OnPageChangeListener{

    private static final String TAG = "---->>OneFragment";

    private @FindViewById(id = R.id.two_option) RadioGroup towOption;
    private @FindViewById(id = R.id.viewpager_second) ChildViewPager viewPager;


    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;
    private FiveFragment fiveFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = setContentView(inflater, R.layout.fragment_second, container, false);
        towOption.check(R.id._2firstRb);
        towOption.setOnCheckedChangeListener(twoRadioGroupListener);

        initFragments();
        return view;
    }

    private void initFragments() {

        threeFragment = new ThreeFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putString("data","2-1");
        threeFragment.setArguments(bundle3);

        fourFragment = new FourFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putString("data","2-2");
        fourFragment.setArguments(bundle4);

        fiveFragment = new FiveFragment();
        Bundle bundle5 = new Bundle();
        bundle5.putString("data","2-3");
        fiveFragment.setArguments(bundle5);

        fragmentArrayList.add(threeFragment);
        fragmentArrayList.add(fourFragment);
        fragmentArrayList.add(fiveFragment);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        viewPager.addOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(fragmentArrayList.size());


    }


    //第一层的RG
    private RadioGroup.OnCheckedChangeListener twoRadioGroupListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id._2firstRb:
                    viewPager.setCurrentItem(0, true);
                    break;
                case R.id._2secondRb:
                    viewPager.setCurrentItem(1, true);
                    break;
                case R.id._3thirdRb:
                    viewPager.setCurrentItem(2, true);
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
                towOption.check(R.id._2firstRb);
                break;
            case 1:
                towOption.check(R.id._2secondRb);
                break;
            case 2:
                towOption.check(R.id._3thirdRb);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
