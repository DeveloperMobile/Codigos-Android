package com.codigosandroid.helloservice;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.codigosandroid.utils.activity.BaseActivity;
import com.codigosandroid.utils.utils.NotificationUtil;

public class MainActivity extends BaseActivity {

    public static final Class<? extends Service> CLS = HelloService_WorkerThread.class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStart(View view) {
        startService(new Intent(this, CLS));
    }

    public void onClickStop(View view) {
        stopService(new Intent(this, CLS));
        NotificationUtil.cancell(this, 1);
    }

}
