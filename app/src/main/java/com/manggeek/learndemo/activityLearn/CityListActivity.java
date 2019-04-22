package com.manggeek.learndemo.activityLearn;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.manggeek.android.geek.bitmap.GeekBitmap;
import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.view.CircleImageView;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.Entity.CompanysModel;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.Util.PhotoURL;
import com.manggeek.learndemo.Util.PinYinStyle;
import com.manggeek.learndemo.Util.PinYinUtil;
import com.manggeek.learndemo.View.SideLetterBar;
import com.manggeek.learndemo.adapter.ContactAdapter;
import com.manggeek.learndemo.control.BaseActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * @Description: 类似城市选择，通讯录列表 
 * @Author: xianggu
 * @CreateDate: 2019/1/4 2:29 PM
 */
public class CityListActivity extends BaseActivity {

    private @FindViewById(id = R.id.listview) ListView listView;
    private @FindViewById(id = R.id.sideLetterBar) SideLetterBar sideLetterBar;
    private @FindViewById(id = R.id.search) EditText searchEd;

    private @FindViewById(id = R.id.tv_first_alphabet) TextView topName;
    private String[] charts = {"#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",};

    private List<CompanysModel> companysList = new ArrayList<>();
    private ContactAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        initEvent();
        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < charts.length; i++) {
            CompanysModel companysModel = new CompanysModel(charts[i]+"快递公司"+"j","kuaidi",PhotoURL.imageUrls[0],"1570011"+i);
            companysModel.setPinYinStyle(parsePinYinStyle(companysModel.getPinyin()));
            companysList.add(companysModel);
        }

        adapter = new ContactAdapter(this, companysList);
        adapter.setOnCityClickListener(new ContactAdapter.OnCityClickListener() {
            @Override
            public void onCityClick(String name) {
                PrintUtil.toastMakeText("选中了<"+name+">公司");
            }
        });
        listView.setAdapter(adapter);
    }

    private void initView() {

        listView.setAdapter(adapter);
        searchEd.addTextChangedListener(mTextWatcher);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                int section = adapter.getSectionForPosition(firstVisibleItem);
//                int nextSecPosition = adapter
//                        .getPositionForSection(section + 1);
//                if (firstVisibleItem != lastFirstVisibleItem) {
//                    ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) xuanfuLayout
//                            .getLayoutParams();
//                    params.topMargin = 0;
//                    xuanfuLayout.setLayoutParams(params);
//                    xuanfaText.setText(String.valueOf((char) section));
//                }
//                if (nextSecPosition == firstVisibleItem + 1) {
//                    View childView = view.getChildAt(0);
//                    if (childView != null) {
//                        int titleHeight = xuanfuLayout.getHeight();
//                        int bottom = childView.getBottom();
//                        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) xuanfuLayout
//                                .getLayoutParams();
//                        if (bottom < titleHeight) {
//                            float pushedDistance = bottom - titleHeight;
//                            params.topMargin = (int) pushedDistance;
//                            xuanfuLayout.setLayoutParams(params);
//                        } else {
//                            if (params.topMargin != 0) {
//                                params.topMargin = 0;
//                                xuanfuLayout.setLayoutParams(params);
//                            }
//                        }
//                    }
//                }
//                lastFirstVisibleItem = firstVisibleItem;
            }
        });
    }

    //索引栏点击监听
    private void initEvent() {
        sideLetterBar.setOnTouchLetterListener(new SideLetterBar.OnTouchLetterListener() {
            @Override
            public void onTouchLetter(String letter) {
                //				alphabetList.clear();
                //				ViewPropertyAnimator.animate(rel_notice).alpha(1f).setDuration(0).start();
                //				//根据当前触摸的字母，去集合中找那个item的首字母和letter一样，然后将对应的item放到屏幕顶端
                for (int i = 0; i < companysList.size(); i++) {
                    String firstAlphabet = companysList.get(i).getPinyin().charAt(0) + "";
                    if (letter.equals(firstAlphabet)) {
                        listView.setSelection(i);
                        break;
                    }
                }
            }
        });
    }


    public PinYinStyle parsePinYinStyle(String content) {
        PinYinStyle pinYinStyle = new PinYinStyle();
        if (content != null && content.length() > 0) {
            //其中包含的中文字符
            String[] enStrs = new String[content.length()];
            for (int i = 0; i < content.length(); i++) {
                enStrs[i] = PinYinUtil.getPinyin(String.valueOf(content.charAt(i)));
            }
            for (int i = 0, length = enStrs.length; i < length; i++) {
                if (enStrs[i].length() > 0) {
                    //拼接简拼
                    pinYinStyle.briefnessSpell += enStrs[i].charAt(0);
                }
            }
        }
        return pinYinStyle;
    }


    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String content = searchEd.getText().toString().trim();
            if (content.length() > 0){
                ArrayList<CompanysModel> fileterList = (ArrayList<CompanysModel>) search(content);
                adapter.updateListView(fileterList);
            }else {
                adapter.updateListView(companysList);
            }
        }
    };

    /**
     * 过滤数据
     * @param filterStr
     */



    /**
     * 模糊查询
     * @param str
     * @return
     */
    private List<CompanysModel> search(String str) {
        List<CompanysModel> filterList = new ArrayList<CompanysModel>();// 过滤后的list
        //if (str.matches("^([0-9]|[/+])*$")) {// 正则表达式 匹配号码
        for (CompanysModel company : companysList) {
            if (company.getName()!=null) {
                if (company.getName().contains(str)){
                    filterList.add(company);
                }
            }
        }
        return filterList;
    }


//    private BaseAdapter adapter = new BaseAdapter() {
//        @Override
//        public int getCount() {
//            return 30;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View view, ViewGroup parent) {
//            ViewHolder viewHolder;
//            if (view == null) {
//                view = mInflater.inflate(R.layout.item_data_util, null);
//                viewHolder = new ViewHolder(view);
//                view.setTag(viewHolder);
//            } else {
//                viewHolder = (ViewHolder) view.getTag();
//            }
//            viewHolder.showData.setText("position+"+position);
//
//            return view;
//        }
//        class ViewHolder{
//            TextView showData;
//            public ViewHolder(View view) {
//                showData = view.findViewById(R.id.show_data);
//
//            }
//        }
//    };
}
