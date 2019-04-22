package com.manggeek.learndemo.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Environment;

import com.manggeek.android.geek.utils.PrintUtil;
import com.manggeek.android.geek.utils.Window;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by zhangshengwei
 * Time: 2018/11/21 11:21
 * describe: 为图片添加水印
 */
public class ImageUtilRemark {


    /**
     * 给一张Bitmap添加水印文字。
     *
     * @param content  水印文本
     * @param textSize 水印字体大小 ，单位pix。
     * @param color    水印字体颜色。
     * @param x        起始坐标x
     * @param y        起始坐标y
     * @param recycle  是否回收
     * @return 已经添加水印后的Bitmap。
     */
    public static Bitmap addTextWatermark(String filePath, String content, int textSize, int color, float x, float y, boolean recycle) {
        if (content == null)
            return null;
        Bitmap src = BitmapFactory.decodeFile(filePath.toString());//filePath

        Bitmap ret = src.copy(src.getConfig(), true);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Canvas canvas = new Canvas(ret);
        paint.setColor(color);
        paint.setTextSize(textSize);
        Rect bounds = new Rect();
        paint.getTextBounds(content, 0, content.length(), bounds);
        canvas.drawText(content, x, y, paint);
        if (recycle && !src.isRecycled())
            src.recycle();
        return ret;
    }

    /**
     * 添加水印  不改变原图大小  根据比例修改水印字体大小
     * @param filePath
     * @param remark
     * @return
     */
    public static Bitmap createWatermark(String filePath, String remark) {
        Bitmap bitmap = BitmapFactory.decodeFile(filePath.toString());            // 将本地地址转为bitmap图片
        //获取图片的宽高
        int w = bitmap.getWidth();                                                // 获取图片宽高
        int h = bitmap.getHeight();
        PrintUtil.log("photo:图片宽高：w:"+w+"    h:"+h);
        //手机像素的宽高
        float newWidth = Window.getWidth();
        float newHeight = Window.getHeight();
        PrintUtil.log("photo:手机像素宽高：newWidth:"+newWidth+"    newHeight:"+newHeight);
        // 计算缩放比例   屏幕宽高/原图宽高
        float scaleWidth = ( newWidth) / w;
        float scaleHeight = (newHeight) / h;
        PrintUtil.log("photo:图片缩放比例：scaleWidth:"+scaleWidth+"    scaleHeight:"+scaleHeight);
        //Matrix对一个Bitmap对象进行处理，包括：缩放、旋转、位移、倾斜等
        //根据bitmap缩放水印图片
//        Matrix matrix = new Matrix();
//        matrix.postScale(scaleWidth, scaleHeight,newWidth/2,newHeight/2);
//        bitmap = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
//        PrintUtil.log("photo:缩放后的图片宽高：newW:"+bitmap.getWidth()+"    newH:"+bitmap.getHeight());


        /**
         * ALPHA_8 代表8位Alpha位图
         * ARGB_4444 代表16位ARGB位图
         * ARGB_8888 代表32位ARGB位图
         * RGB_565 代表8位RGB位图
         * 位图位数越高代表其可以存储的颜色信息越多，当然图像也就越逼真
         */
        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.RGB_565);
//        Canvas canvas = new Canvas(bmp);
        Canvas canvas = new Canvas(bmp);
        Paint p = new Paint();
        // 水印颜色
        p.setColor(Color.parseColor("#2ec55b"));                      //绿色，项目默认颜色;
        // 水印字体大小
        p.setTextSize((50/scaleWidth));
        //抗锯齿
        p.setAntiAlias(true);
        //绘制图像  在画布上添加画笔工具 paint   图片绘画的起点位置
        canvas.drawBitmap(bitmap, 0, 0, p);
        //绘制文字
        float textW = p.measureText(remark);
        PrintUtil.log("photo:字符串原宽度");
        textW = textW*scaleWidth;
        PrintUtil.log("photo: 字符串原宽度*变换比例后宽度:"+textW);
        //画文字
        canvas.drawText(remark, (newWidth-textW-20)/scaleWidth, (newHeight-100)/scaleHeight, p);
//        canvas.drawText(remark, 0, 0, p);
        PrintUtil.log("photo: 字符串起始X:"+(newWidth-textW)+"   起始Y:"+(newHeight-100));
//        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.save();
        canvas.restore();
        return bmp;
    }



    /**
     * 添加水印 水印大小随图片像素变动
     * @param filePath
     * @param mark
     * @return
     */
//    public static Bitmap createWatermark(String filePath, String mark) {
//        Bitmap bitmap = BitmapFactory.decodeFile(filePath.toString());//filePath
//        int w = bitmap.getWidth();
//        int h = bitmap.getHeight();
////        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
//        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.RGB_565);
//        Canvas canvas = new Canvas(bmp);
//        Paint p = new Paint();
//        // 水印颜色
//        p.setColor(Color.parseColor("#2ec55b"));
//        // 水印字体大小
//        p.setTextSize(60);
//        //抗锯齿
//        p.setAntiAlias(true);
//        //绘制图像
//        canvas.drawBitmap(bitmap, 0, 0, p);
//        //绘制文字
//        canvas.drawText(mark, 10, 50, p);
//        canvas.save(Canvas.ALL_SAVE_FLAG);
//        canvas.restore();
//        return bmp;
//    }



    private static final String SD_PATH = "/sdcard/dskqxt/pic/";
    private static final String IN_PATH = "/dskqxt/pic/";               //图片存储路径
    /**
     *  * 保存bitmap到本地
     * @param context
     * @param mBitmap
     * @return
     */
    public static String saveBitmap(Context context, Bitmap mBitmap) {
        String savePath;
        File filePic;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            savePath = SD_PATH;
        } else {
            savePath = context.getApplicationContext().getFilesDir().getAbsolutePath() + IN_PATH;
        }
        try {
            //png它是无损压缩格式，jpg是有损
            filePic = new File(savePath + generateFileName() + ".jpg");     //生成jpg图片
            if (!filePic.exists()) {
                filePic.getParentFile().mkdirs();
                filePic.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(filePic);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return filePic.getAbsolutePath();
    }


    /**
     * 随机生产图片文件名称
     *
     * @return
     */
    private static String generateFileName() {
        return UUID.randomUUID().toString();
    }

    /** 删除单个文件
     * @param filePath$Name 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteSingleFile(String filePath$Name) {
        File file = new File(filePath$Name);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                PrintUtil.log("--Method--", "Copy_Delete.deleteSingleFile: 删除单个文件" + filePath$Name + "成功！");
                return true;
            } else {
//                Toast.makeText(getApplicationContext(), "删除单个文件" + filePath$Name + "失败！", Toast.LENGTH_SHORT).show();
                PrintUtil.log("文件删除失败");
                return false;
            }
        } else {
//            Toast.makeText(getApplicationContext(), "删除单个文件失败：" + filePath$Name + "不存在！", Toast.LENGTH_SHORT).show();
            PrintUtil.log("删除单个文件失败  文件不存在");
            return false;
        }
//        return false;
    }

}
