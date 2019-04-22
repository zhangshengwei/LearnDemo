package com.manggeek.learndemo.Bo;

import com.manggeek.android.geek.http.HttpParams;
import com.manggeek.learndemo.control.BaseApplication;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/2/20 4:50 PM
 */
public class BaseParams  extends HttpParams {

    public BaseParams() {

        if (null != BaseApplication.getPackageInfo()) {
            /**
             * /pub/**  公共接口，无需授权验证
             *
             * /usr/**  用户接口，需要授权验证
             * 所有接口带上通用参数
             * machine: 设备唯一标识符，一串md5编码的字符串
             * device: 设备类型，如 iphone8, vivo……
             * sys_version: 系统版本号
             * sys: 系统类型，ios, android
             * app: 包名，express.mango.com
             * app_version: app版本号
             */
            //接口通用参数
//            PrintUtil.log("phoneInfo--->machine:"+new GetDeviceId().getId());
//            PrintUtil.log("phoneInfo--->设备类型:"+Build.BRAND);
//            PrintUtil.log("phoneInfo--->系统版本号:"+ Build.VERSION.RELEASE);
//            PrintUtil.log("phoneInfo--->包名:"+BaseApplication.getPackageInfo().packageName);
//            PrintUtil.log("phoneInfo--->app版本号:"+BaseApplication.getPackageInfo().versionName);
//            put("machine", new GetDeviceId().getId());
//            put("device", Build.BRAND);
//            put("sys_version", Build.VERSION.RELEASE);
//            put("app", BaseApplication.getPackageInfo().packageName);
//            put("app_version", BaseApplication.getPackageInfo().versionName);
//            put("sys","android");

        }
    }

    private String session;

    public String getSession() {
//        if (UserCache.getUser() != null) {
//            byte[] sessionByte = UserCache.getUser().getSession().getBytes();
//            return "session_"+Base64.encodeToString(sessionByte, Base64.NO_WRAP);
//        }
        return "";
    }

    public void setSession(String session) {
        this.session = session;
    }

}
