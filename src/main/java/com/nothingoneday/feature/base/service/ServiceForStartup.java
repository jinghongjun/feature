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
package com.nothingoneday.feature.base.service;

import java.io.FileDescriptor;
import java.io.PrintWriter;

import com.nothingoneday.feature.base.log.Logger;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;


/**
 * @author b690
 *
 */
public class ServiceForStartup extends Service implements ICountService {
    
    private static final String TAG = ServiceForStartup.class.getSimpleName();
    
    public final static String ACTION = "com.nothingoneday.feature.ServiceForStartup";
    public final static String DETROY = "com.nothingoneday.feature.ServiceForStartup_DETROY";
    
    private boolean isDestroy;
    
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "ServiceForStartup: onCreate()");
        Logger.getInstance().appendCache("ServiceForStartup: onCreate()\n");
        
        new Thread(){

            @Override
            public void run() {
                while (!isDestroy) {
                    try {
                        Thread.sleep(1000);
                        mCount++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Logger.getInstance().appendCache("ServiceForStartup thread: Count: " + mCount + "\n");
                }
            }
            
        }.start();
        
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "ServiceForStartup: onStartCommand()");
        Logger.getInstance().appendCache("ServiceForStartup: onStartCommand()\n");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    @Deprecated
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Logger.getInstance().appendCache("ServiceForStartup: onStart()\n");
        Log.d(TAG, "ServiceForStartup: onStart()");
    }

    
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "ServiceForStartup: onBind()");
        Logger.getInstance().appendCache("ServiceForStartup: onBind()\n");
        return mServiceBinder;
    }
    
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "ServiceForStartup: onUnbind()");
        Logger.getInstance().appendCache("ServiceForStartup: onUnbind()\n");
        return super.onUnbind(intent);
    }
    

    @Override
    public void onDestroy() {
        super.onDestroy();
        isDestroy = true;
        Log.d(TAG, "ServiceForStartup: onDestroy()");
        Logger.getInstance().appendCache("ServiceForStartup: onDestroy()\n");
        sendBroadcast(new Intent(DETROY));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "ServiceForStartup: onConfigurationChanged()");
        Logger.getInstance().appendCache("ServiceForStartup: onConfigurationChanged()\n");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d(TAG, "ServiceForStartup: onLowMemory()");
        Logger.getInstance().appendCache("ServiceForStartup: onLowMemory()\n");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.d(TAG, "ServiceForStartup: onTrimMemory()");
        Logger.getInstance().appendCache("ServiceForStartup: onTrimMemory()\n");
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "ServiceForStartup: onRebind()");
        Logger.getInstance().appendCache("ServiceForStartup: onRebind()\n");
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Log.d(TAG, "ServiceForStartup: onTaskRemoved()");
        Logger.getInstance().appendCache("ServiceForStartup: onTaskRemoved()\n");
    }

    @Override
    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(fd, writer, args);
        Log.d(TAG, "ServiceForStartup: dump()");
        Logger.getInstance().appendCache("ServiceForStartup: dump()\n");
    }
    
    private int mCount;
    
    private ServiceBinder mServiceBinder = new ServiceBinder();
    
    public class ServiceBinder extends Binder implements ICountService {

        public int getCount() {
            return mCount;
        }
        
    }

    public int getCount() {
        return mCount;
    }
    
}
