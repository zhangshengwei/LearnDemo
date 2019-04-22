package com.manggeek.learndemo.activityLearn;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.Util.ApplicationUtils;
import com.manggeek.learndemo.control.BaseActivity;

import java.util.List;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/2/19 9:59 AM
 */
public class MobileInfoActivity extends BaseActivity {

    private @FindViewById(id = R.id.applications) TextView applicationsTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_info);
        initView();
    }

    private void initView() {

        applicationsTv.setOnClickListener(click);
    }



    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == applicationsTv){
                List<Application> applications = ApplicationUtils.newInstance(mActivity).loadAllApplication();
//                for (Application item : applications) {
//                    PrintUtil.log("******** " + "包名:" + item.getPackageName() + "  ");
//                }
                for (int i = 0;i<applications.size();i++){
//                    PrintUtil.log("******** " + "包名:" + applications.get(i).getPackageName() + "  ");
                }
            }
        }
    };
}
