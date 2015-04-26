/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nothingoneday.feature.base.api.sync;


import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import com.nothingoneday.feature.base.log.Logger;


/**
 * @author b690
 * IntentService内部有一个工作线程来处理耗时操作，启动IntentService的方式和启动传统Service一样，同时，当任务执行完后，
 * IntentService会自动停止，而不许要我们手动控制。另外可以启动IntentService多次，而每一个耗时操作会以工作队列的方式在Intent
 * Service的onHandleIntent回调方法执行，并且，每次只会执行一个工作线程。
 */
public class AsyncIntentService extends IntentService {

    private final static String TAG = AsyncIntentService.class.getSimpleName();
    
    public static final String ACTION = "com.nothingoneday.feature.AsyncIntentService";
    
    public static final String DATA = "data";
    public static final int TASK_1 = 0;
    public static final int TASK_2 = 2;
    
    public AsyncIntentService() {
        super(null);
        Logger.getInstance().appendCache("AsyncIntentService: AsyncIntentService()\n");
        Logger.getInstance().d("AsyncIntentService: AsyncIntentService()");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Logger.getInstance().appendCache("AsyncIntentService: onHandleIntent(Intent intent)\n");
        Logger.getInstance().d("AsyncIntentService: onHandleIntent(Intent intent)");
        int taskId = intent.getBundleExtra(DATA).getInt(DATA);
        switch (taskId) {
            case TASK_1:
                new Thread(new Task1Runnable()).start();
                break;
            case TASK_2:
                new Thread(new Task2Runnable()).start();
                break;
        }
    }

    @Override
    public void setIntentRedelivery(boolean enabled) {
        super.setIntentRedelivery(enabled);
        Logger.getInstance().appendCache("AsyncIntentService: setIntentRedelivery(boolean enabled)\n");
        Logger.getInstance().d("AsyncIntentService: setIntentRedelivery(boolean enabled)");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.getInstance().appendCache("AsyncIntentService: onCreate()\n");
        Logger.getInstance().d("AsyncIntentService: onCreate()");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Logger.getInstance().appendCache("AsyncIntentService: onStart(Intent intent, int startId)\n");
        Logger.getInstance().d("AsyncIntentService: onStart(Intent intent, int startId)");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger.getInstance().appendCache("AsyncIntentService: onStartCommand(Intent intent, int flags, int startId)\n");
        Logger.getInstance().d("AsyncIntentService: onStartCommand(Intent intent, int flags, int startId)");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Logger.getInstance().appendCache("AsyncIntentService: onBind(Intent intent)\n");
        Logger.getInstance().d("AsyncIntentService: onBind(Intent intent)");
        return super.onBind(intent);
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.getInstance().appendCache("AsyncIntentService: onDestroy()\n");
        Logger.getInstance().d("AsyncIntentService: onDestroy()");
    }

    class Task1Runnable implements Runnable {

        public void run() {
            try {
                Thread.sleep(12000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(IntentServiceActivity.TASK_1_ACTION);
            AsyncIntentService.this.sendBroadcast(intent);
        }
        
    }
    
    class Task2Runnable implements Runnable {

        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(IntentServiceActivity.TASK_2_ACTION);
            AsyncIntentService.this.sendBroadcast(intent);
        }
        
    }

}
