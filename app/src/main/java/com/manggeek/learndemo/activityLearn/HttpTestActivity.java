package com.manggeek.learndemo.activityLearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.manggeek.android.geek.http.HttpParams;
import com.manggeek.android.geek.http.Result;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.Bo.NewResultCallBack;
import com.manggeek.learndemo.Bo.TestBo;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.control.BaseActivity;

import org.w3c.dom.Text;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/1/29 10:20 AM
 */
public class HttpTestActivity extends BaseActivity {

    private @FindViewById(id = R.id.show_result) TextView showResultTv;
    private @FindViewById(id = R.id.python) TextView pythonTv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httptest);
        initView();
    }

    private void initView() {
        pythonTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestBo.pythonTest(new NewResultCallBack() {
                    @Override
                    public void onResultSuccess(int what, Result result) {
                        showResultTv.setText(result.toString());
                    }
                });
            }
        });
    }

}
