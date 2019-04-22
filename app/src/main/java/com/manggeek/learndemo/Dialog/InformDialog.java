package com.manggeek.learndemo.Dialog;

import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.manggeek.android.geek.GeekActivity;
import com.manggeek.android.geek.GeekDialog;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.R;

/**
 * Created by zhangshengwei
 * Time: 2018/12/12 10:44
 * describe: 消息确认的弹窗 ，代替Toast   仅仅显示确认按钮
 */
public class InformDialog extends GeekDialog {

    private @FindViewById(id = R.id.content) TextView contentTv;
    private @FindViewById(id = R.id.cancel) TextView cancelTv;
    private @FindViewById(id = R.id.confirm) TextView confirmTv;
    private @FindViewById(id = R.id.line) View line;

    private View.OnClickListener confirmListener;           //确认按钮
    private View.OnClickListener cancelListener;            //取消按钮

    private String messageStr = "";


    public void setMessageStr(String messageStr) {
        this.messageStr = messageStr;
    }

    public InformDialog(GeekActivity activity) {
        super(activity);
        setContentView(R.layout.dialog_message, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        setGravity(Gravity.CENTER);

    }

    private void initView() {
        contentTv.setText(messageStr);
//        cancelTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (cancelListener!=null){
//                    cancelListener.onClick(view);
//                }
//                dismiss();
//            }
//        });
        line.setVisibility(View.GONE);
        cancelTv.setVisibility(View.GONE);
        confirmTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (confirmListener!=null){
                    confirmListener.onClick(view);
                }
                dismiss();
            }
        });

    }




    public void setConfirmListener(View.OnClickListener confirmListener) {
        initView();
        this.confirmListener = confirmListener;
    }

    //取消按钮执行内容
    public void setCancelListener(View.OnClickListener cancelListener){
        initView();
        this.cancelListener = cancelListener;
    }
}
