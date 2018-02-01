package com.codigosandroid.appbroadcastreceiver.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.codigosandroid.appbroadcastreceiver.activity.ActivityTeste;

/**
 * Created by Tiago on 01/02/2018.
 */

public class Receiver4 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent it = new Intent(context, ActivityTeste.class);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
    }
}
