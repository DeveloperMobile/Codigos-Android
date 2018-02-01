package com.codigosandroid.appbroadcastreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.codigosandroid.utils.utils.LogUtil;

/**
 * Created by Tiago on 01/02/2018.
 */

public class ReceiverBoot extends BroadcastReceiver {

    private static final String TAG = ReceiverBoot.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.debug(TAG, "OS inicializado com sucesso!");
        Toast.makeText(context, "OS inicializado com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
