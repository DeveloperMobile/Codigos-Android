package com.codigosandroid.helloservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.codigosandroid.utils.utils.LogUtil;
import com.codigosandroid.utils.utils.NotificationUtil;

/**
 * Created by Tiago on 07/02/2018.
 */

public class HelloIntentService extends IntentService {

    private static final int MAX = 10;
    private static final String TAG = "codigos_android";
    private boolean running;

    public HelloIntentService() {
        super("NomeDaThreadAqui");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        running = true;
        /* Este método executa em uma thread
         * Quando ele terminar, o método stopSelf() será chamado automaticamente */
        int count = 0;
        while (running && count < MAX) {
            fazAlgumaCoisa();
            LogUtil.debug(TAG, "ExemploServico executando... " + count);
            count++;
        }
        NotificationUtil.create(this, 1, new Intent(this, MainActivity.class), R.mipmap.ic_launcher, "Fim", "Olá");
        LogUtil.debug(TAG, "ExemploServico fim.");
    }

    private void fazAlgumaCoisa() {
        try {
            // Simula algum processamento
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Ao encerrar o serviço, altera o flag para o loop parar
        running = false;
        LogUtil.debug(TAG, "Exemploservico.onDestroy()");
    }

}
