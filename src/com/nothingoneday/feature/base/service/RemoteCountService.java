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

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;


/**
 * @author b690
 *
 */
public class RemoteCountService extends Service {
    
    private static final String TAG = RemoteCountService.class.getSimpleName();
    
    public static final String ACTION = "com.nothingoneday.feature_RemoteCountService";
    
    private boolean isDestroy;
    
    private int mCount;
    private CountBean mCountBean;
    
    private IRemoteCountService.Stub mServiceBinder = new IRemoteCountService.Stub() {

        public CountBean getCount() throws RemoteException {
            return mCountBean;
        }
    };
    
    @Override
    public void onCreate() {
        super.onCreate();
        mCountBean = new CountBean();
        new Thread (){
            public void run(){
                while (!isDestroy) {
                    mCount++;
                    try {
                        Thread.sleep(1000);
                         
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mCountBean.mCount = mCount; 
                }
            }
        }.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isDestroy = true;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mServiceBinder;
    }

}
