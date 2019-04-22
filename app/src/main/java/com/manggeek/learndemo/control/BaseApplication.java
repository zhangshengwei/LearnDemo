package com.manggeek.learndemo.control;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.ciba.datagather.common.DataGatherManager;
import com.ciba.datagather.listener.DeviceDataGatherListener;
import com.ciba.datagather.manager.MachineManager;
import com.ciba.datagather.util.DataGatherUtil;
import com.ciba.datasynchronize.coder.PublicKey;
import com.ciba.datasynchronize.entity.CustomPackageInfo;
import com.ciba.datasynchronize.entity.DeviceData;
import com.ciba.datasynchronize.entity.ProcessData;
import com.ciba.datasynchronize.manager.LoaderUploaderManager;
import com.ciba.datasynchronize.sample.uploader.SampleDeviceDataUploader;
import com.manggeek.android.geek.GeekApplication;
import com.manggeek.android.geek.utils.PrintUtil;

import java.util.List;

/**
 * @Description:
 * @Author: zsw
 * @CreateDate: 2018/12/29 12:22 PM
 */
public class BaseApplication extends GeekApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        DataGatherManager.getInstance().init(this); //检查root  默认不检查
        DataGatherUtil.gatherDeviceData(false, true, true, true, new DeviceDataGatherListener() {
            @Override
            public void onDeviceDataGather(String crashData,
                                           DeviceData deviceData,
                                           List<CustomPackageInfo> installPackageList,
                                           List<ProcessData> appProcessList) {

                PrintUtil.log(">>>>>>>>设备数据信息收集完成>>>>>>>>>>>>");
                PrintUtil.log(">>>>>>>>DeviceData:"+deviceData.getBtmac());
                for (CustomPackageInfo itemPackInfo : installPackageList){
                    PrintUtil.log(">>>>>>>>:"+itemPackInfo.getApplyName());
                }



//                final LoaderUploaderManager manager = LoaderUploaderManager.getInstance();
////                manager.setDeviceDataUploader();
//                SampleDeviceDataUploader sampleDeviceDataUploader = new SampleDeviceDataUploader();
//                manager.setDeviceDataUploader(sampleDeviceDataUploader);



            }
        });
        // 获取设备唯一标识，以及其他设备信息获取的工具类
        String machine = MachineManager.getInstance().getMachine();
        PrintUtil.log(">>>>>>>>Machine:"+machine);

        PrintUtil.log("---->AES:加密后的测试文本:"+PublicKey.keyboards("AES加密测试文本"));

    }

    public static PackageInfo getPackageInfo() {
        PackageInfo pi = null;

        try {
            PackageManager pm = getContext().getPackageManager();
            pi = pm.getPackageInfo(getContext().getPackageName(), PackageManager.GET_CONFIGURATIONS);

            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pi;
    }
}
