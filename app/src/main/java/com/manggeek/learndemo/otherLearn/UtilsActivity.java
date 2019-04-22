package com.manggeek.learndemo.otherLearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.Dialog.SelectorDialog;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.Util.ArrayUtil;
import com.manggeek.learndemo.control.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangshengwei
 * Time: 2018/12/3 10:36
 * describe: 字符串解析
 */
public class UtilsActivity extends BaseActivity {

    private @FindViewById(id = R.id.content) EditText contentEd;

    private @FindViewById(id = R.id.select_type) TextView selectTypeTv;
    private @FindViewById(id = R.id.confirm) TextView confirmTv;
    private @FindViewById(id = R.id.show_result) TextView showResultTv;

    private String resultStr="";
    private int type;
    private SelectorDialog selectorDialog;
    private String[] content = {"List转String用逗号隔开","String字符串根据逗号分割","取出数字"};
    private List<String> selectList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utils);
        initView();
    }

    private void initView() {
        type = 0;
        selectorDialog = new SelectorDialog(mActivity);
        for (int i = 0; i < content.length; i++){
            selectList.add(content[i]);
        }

        selectTypeTv.setOnClickListener(click);
        confirmTv.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == selectTypeTv){
                selectorDialog.ShowContentListener(selectList, new SelectorDialog.SelectorListener() {
                    @Override
                    public void choose(String name, int number) {
                        selectTypeTv.setText(name+"");
                        type = number;
                    }
                });
                selectorDialog.show();
            }else if (view == confirmTv){
                confirmMethod(type);
            }
        }
    };

    private void confirmMethod(int type) {
        String content = contentEd.getText().toString().trim();
        switch (type){
            case 0:
                break;
            case 1:                     //String字符串根据逗号分割
                resultStr = "";
                List<String> strList = ArrayUtil.strToList(content);
                for (int i = 0; i<strList.size();i++){
                    resultStr = resultStr + strList.get(i)+"\n";
                }
                showResultTv.setText(resultStr);
                break;
            case 2:                     //取出数字
                resultStr = ArrayUtil.getNumStr(content);
                showResultTv.setText(resultStr);
                break;
        }
    }
}
