package com.codigosandroid.appbroadcastreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.codigosandroid.utils.utils.LogUtil;

/**
 * Created by Tiago on 01/02/2018.
 */

public class Receiver1 extends BroadcastReceiver {

    private static final String TAG = Receiver1.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.debug(TAG, "onReceive()");
        Toast.makeText(context, "Receiver 1", Toast.LENGTH_SHORT).show();
    }
}
