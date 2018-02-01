package com.codigosandroid.appbroadcastabriraplicacao.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.codigosandroid.appbroadcastabriraplicacao.R;

/**
 * Created by Tiago on 01/02/2018.
 */

public class ReceiverAbrirApp extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, context.getString(R.string.msg_receiver), Toast.LENGTH_SHORT).show();
        Intent it = new Intent(Intent.ACTION_MAIN);
        it.addCategory(Intent.CATEGORY_DEFAULT);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
    }
}
