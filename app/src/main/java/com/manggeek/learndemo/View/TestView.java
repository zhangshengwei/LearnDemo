package com.manggeek.learndemo.View;

import android.widget.TextView;

import com.manggeek.android.geek.utils.PrintUtil;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/8/13 11:00 AM
 */
public class TestView  {

    private TextView textView2;

    public TestView(TextView textView) {
        this.textView2 = textView;
        printContent();
    }

    private void printContent() {
        textView2.setText("测试文本");
        PrintUtil.log("---->>形参地址" + textView2.toString());
    }
}
