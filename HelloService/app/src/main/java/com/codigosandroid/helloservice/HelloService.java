package com.codigosandroid.helloservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.codigosandroid.utils.utils.LogUtil;
import com.codigosandroid.utils.utils.NotificationUtil;

/**
 * Created by Tiago on 07/02/2018.
 */

public class HelloService extends Service {

    private static final int MAX = 10;
    private static final String TAG = "codigos_android";
    protected int count;
    private boolean running;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // null aqui porque não queremos interagir com o serviço(veremos um exemplo disso depois)
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.debug(TAG, "HelloService.onCreate() - Service criado");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.debug(TAG, "HelloService.onStartCommand() - Service iniciado: " + startId);
        count = 0;
        /* Método chamado depois do onCreate(), logo depois de iniciaro serviço
         * O parâmetro startId representa o identificador deste serviço */
        running = true;
        // Deleta para uma thread
        new WorkerThread().start();
        // Chama a implementação da superclasse
        return super.onStartCommand(intent, flags, startId);
    }

    // Thread que faz o trabalho pesado
    class WorkerThread extends Thread {
        @Override
        public void run() {
            try {
                while (running && count < MAX){
                    // Simula algum processamento
                    Thread.sleep(1000);
                    LogUtil.debug(TAG, "HelloService executando... " + count);
                    count++;
                }
                LogUtil.debug(TAG, "HelloService fim.");
            } catch (InterruptedException e) {
                LogUtil.error(TAG, e.getMessage(), e);
            } finally {
                // Auto-Encerra o serviço se o contador chegou a 10
                stopSelf();
                // Cria uma notificação para avisar o usuário que terminou.
                Context context = HelloService.this;
                Intent intent = new Intent(context, MainActivity.class);
                NotificationUtil.create(context, 1, intent, R.mipmap.ic_launcher, "HelloService", "Fim do serviço.");
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        /* Ao encerrar o serviço, altere o flag para a thread parar (isto é importante para encerrar
        a thread caso alguém tenha chamado o stopService(intent) */
        running = false;
        LogUtil.debug(TAG, "HelloService.onDestroy() - Service destruído");
    }
}
