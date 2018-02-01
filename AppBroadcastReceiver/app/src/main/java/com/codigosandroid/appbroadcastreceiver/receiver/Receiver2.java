package com.codigosandroid.appbroadcastreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.codigosandroid.utils.utils.LogUtil;

/**
 * Created by Tiago on 01/02/2018.
 */

public class Receiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Receiver 2 iniciado com API!", Toast.LENGTH_SHORT).show();
    }
}
