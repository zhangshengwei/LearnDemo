package com.manggeek.learndemo.activityLearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.manggeek.android.geek.dialog.WaitDialog;
import com.manggeek.android.geek.http.Result;
import com.manggeek.android.geek.http.ResultCallBack;
import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.Bo.NewResultCallBack;
import com.manggeek.learndemo.Bo.TestBo;
import com.manggeek.learndemo.Entity.Student;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.control.BaseActivity;

/**
 * Created by zhangshengwei
 * Time: 2018/11/20 14:17
 * describe: Activity 模块
 */
public class MainActivity extends BaseActivity {

    private @FindViewById(id = R.id.avtivity1) TextView activity1Tv;
    private @FindViewById(id = R.id.activity2) TextView activity2Tv;

    private WaitDialog waitDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        Student student = new Student.Builder("小明","18").address("天街").phone("110").build();
    }

    private void initView() {
        activity1Tv.setOnClickListener(click);
        activity2Tv.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == activity1Tv){
                TestBo.gainVersion(new NewResultCallBack() {
                    @Override
                    public void onResultSuccess(int what, Result result) {
//                        PrintUtil.log("http--->"+result.getData().toString());
//                        Log.i("BBB", "onClick: ");
                    }
                });
            }else if (view == activity2Tv){

            }
        }
    };
}
