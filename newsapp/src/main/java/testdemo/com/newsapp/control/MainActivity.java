package testdemo.com.newsapp.control;

import android.os.Bundle;

import testdemo.com.newsapp.R;
import testdemo.com.newsapp.base.BaseActivity;

/**
 * @Description:
 * @Author: xianggu
 * @CreateDate: 2019/1/30 3:21 PM
 */
public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
