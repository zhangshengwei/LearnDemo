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
 * Time: 2018/11/22 13:55
 * describe: 消息通知Dialog
 */
public class MessageDialog extends GeekDialog {

    private @FindViewById(id = R.id.content) TextView contentTv;
    private @FindViewById(id = R.id.cancel) TextView cancelTv;
    private @FindViewById(id = R.id.confirm) TextView confirmTv;

    private View.OnClickListener confirmListener;           //确认按钮
    private View.OnClickListener cancelListener;            //取消按钮

    private String messageStr = "";


    public void setMessageStr(String messageStr) {
        this.messageStr = messageStr;
    }

    public MessageDialog(GeekActivity activity) {
        super(activity);
        setContentView(R.layout.dialog_message, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        setGravity(Gravity.CENTER);

    }

    private void initView() {
        contentTv.setText(messageStr);
        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cancelListener!=null){
                    cancelListener.onClick(view);
                }
                dismiss();
            }
        });
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
        this.cancelListener = cancelListener;
    }
}
