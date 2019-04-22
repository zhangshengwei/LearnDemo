package com.manggeek.learndemo.activityLearn;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.utils.Window;
import com.manggeek.android.geek.view.FindViewById;
import com.manggeek.learndemo.Dialog.InformDialog;
import com.manggeek.learndemo.R;
import com.manggeek.learndemo.control.BaseActivity;
import com.uuzuche.lib_zxing.ZXingUtils;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * Created by zhangshengwei
 * Time: 2018/12/20 17:20
 * describe:
 */
public class ScanPicActivity extends BaseActivity {

    private @FindViewById(id = R.id.pic_content) EditText contentEd;
    private @FindViewById(id = R.id.create_pic) TextView createPicTv;
    private @FindViewById(id = R.id.scan_pic) TextView scanPicTv;

    private @FindViewById(id = R.id.pic) ImageView picImg;              //展示二维码图片
    private @FindViewById(id = R.id.content) TextView contentTv;        //展示二维码图片内容

    private InformDialog informDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_pic);
        initView();
    }

    private void initView() {
        informDialog = new InformDialog(mActivity);
        createPicTv.setOnClickListener(click);
        scanPicTv.setOnClickListener(click);
        picImg.setOnClickListener(click);
    }


    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == createPicTv){
                createPic();
            }else if (view == scanPicTv){
                openCamear();
            }else if (view == picImg) {
                scanPic();
            }
        }
    };




    /**
     * 生成二维码图片
     */
    private void createPic() {
        String urlContent = contentEd.getText().toString().trim();
        if (TextUtils.isEmpty(urlContent)){
            informDialog.setMessageStr("二维码内容不得为空");
            informDialog.setCancelListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    informDialog.dismiss();
                }
            });
            informDialog.show();
        }else{
            Window window = new Window();
            Bitmap picture = ZXingUtils.createQRImage(urlContent,200,200);
            picImg.setImageBitmap(picture);
        }
    }

    /**
     * 识别二维码
     */
    private void scanPic() {

    }


    /**
     * 打开相机
     */
    private void openCamear() {

        startActivity(new Intent(mActivity,CaptureActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
//            String contentStr = data.getStringExtra("")
            Bundle bundle = data.getExtras();
            String contentStr = bundle.getString(CodeUtils.RESULT_STRING);
            informDialog.setMessageStr(contentStr);
            informDialog.setCancelListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    informDialog.dismiss();
                }
            });
            informDialog.show();
        }
    }


    //    private void decode(final Bitmap bitmap, final String errorTip) {
//        /*
//        这里为了偷懒，就没有处理匿名 AsyncTask 内部类导致 Activity 泄漏的问题
//        请开发在使用时自行处理匿名内部类导致Activity内存泄漏的问题，处理方式可参考 https://github
//        .com/GeniusVJR/LearningNotes/blob/master/Part1/Android/Android%E5%86%85%E5%AD%98%E6%B3%84%E6%BC%8F%E6%80%BB%E7%BB%93.md
//         */
//        new AsyncTask<Void, Void, String>() {
//            @Override
//            protected String doInBackground(Void... params) {
//                return QRCodeDecoder.syncDecodeQRCode(bitmap);
//            }
//
//            @Override
//            protected void onPostExecute(String result) {
//                if (TextUtils.isEmpty(result)) {
//                    Toast.makeText(TestGeneratectivity.this, errorTip, Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(TestGeneratectivity.this, result, Toast.LENGTH_SHORT).show();
//                }
//            }
//        }.execute();
//    }

}
