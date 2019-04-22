package testdemo.com.mobileauthlib;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;

import org.json.JSONObject;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/1/17 11:06 AM
 */
public class TestHelper {

    private static final String TAG = "TESTHELPER---CMCC:";

    private AuthnHelper mAuthnHelper;                   //AuthnHelper是移动一键登录SDK的功能入口
    private TokenListener mListener;                    //接收SDK返回的调用结果
    private static TestHelper testHelper;
    public static TestHelper getTestHelper(){
        if (testHelper == null){
            synchronized (TestHelper.class){
                if (testHelper == null){
                    testHelper = new TestHelper();
                }
            }
        }
        return testHelper;
    }

    public void init(final Context context, final String var1, final String var2, int var4){
        mAuthnHelper = AuthnHelper.getInstance(context);

        mListener = new TokenListener() {
            @Override
            public void onGetTokenComplete(int i, JSONObject jsonObject) {
                if (jsonObject != null){
                    String mResultString = jsonObject.toString();
                    Log.i(TAG, "mResultString:"+mResultString);
                    if (jsonObject.has("token")) {
                        String mAccessToken = jsonObject.optString("token");
                        Toast.makeText(context,"Token:"+mAccessToken,Toast.LENGTH_LONG).show();
                    }

                }
            }
        };

        mAuthnHelper.loginAuth(var1,var2,mListener,var4);
    }
}
