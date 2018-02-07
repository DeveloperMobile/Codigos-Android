package com.codigosandroid.helloservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.codigosandroid.utils.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiago on 07/02/2018.
 */

public class HelloService_WorkerThread extends Service {
    private static int MAX = 10;
    private static String TAG = "codigos_android";
    private List<WorkerThread> threads = new ArrayList<WorkerThread>();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtil.debug(TAG, "HelloService_WorkerThread.onBind()");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Chamado todas as vezes que é chamado o startService(intent)
        LogUtil.debug(TAG, "HelloService_WorkerThread.onStartCommand(): " + startId);
        // Delega para uma thread
        WorkerThread workerThread = new WorkerThread(startId);
        threads.add(workerThread);
        workerThread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    class WorkerThread extends Thread {
        private boolean running;
        private int startId;
        private int count;

        public WorkerThread(int startId) {
            super("Helloservice-" + startId);
            this.startId = startId;
            running = true;
        }

        @Override
        public void run() {
            while (running && this.count < MAX) {
                try {
                    // Simula algum processamento (chamada para um web service ou banco de ados)
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LogUtil.debug(TAG, startId + ": HelloService executando... " + this.count);
                this.count++;
            }
            LogUtil.debug(TAG, "HelloService fim (" + startId + ")");
            // Auto-Encerra o service quando o processamento terminar
            stopSelf(startId); // Encerra pelo startId
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        /* Esta chamada é única para todas as threads (cada chamado ao startService)
         * Ao encerrar o serviço, altera o flag para as threads pararem */
        for (WorkerThread workerThread : threads) {
            workerThread.running = false;
        }
        threads.clear();
        LogUtil.debug(TAG, "HelloService_WorkerThread.onDestroy()");
    }

}
