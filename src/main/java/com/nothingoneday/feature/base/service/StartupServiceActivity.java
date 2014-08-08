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

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.log.Logger;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


/**
 * @author b690
 *
 */
public class StartupServiceActivity extends Activity implements OnClickListener{

    private final static String TAG = StartupServiceActivity.class.getSimpleName();

    TextView mTextView;
    Button mStartServiceButton, mStopServiceButton, mBinderServiceButton, mUnbinderServiceButton;
    
    private boolean isBinder;
    private ICountService mCountService;
    
    Intent mIntent = new Intent(ServiceForStartup.ACTION);
    ServiceConnection mServiceConnection = new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder service) {
            mCountService = (ICountService)service;
            int count = mCountService.getCount();
            Logger.getInstance().appendCache("StartupServiceActivity: onServiceConnected(): count: " + count + "\n");
        }

        public void onServiceDisconnected(ComponentName name) {
            Logger.getInstance().appendCache("StartupServiceActivity: onServiceDisconnected(): count:" + mCountService.getCount() + "\n");
        }
        
    };
    
    ServiceDestroyBroadcastReceiver mServiceDestroyBroadcastReceiver;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup_service);
        
        mTextView = (TextView)findViewById(R.id.log);
        
        mStartServiceButton = (Button)findViewById(R.id.start_service);
        mStartServiceButton.setOnClickListener(this);
        mStopServiceButton = (Button)findViewById(R.id.stop_service);
        mStopServiceButton.setOnClickListener(this);
        mBinderServiceButton = (Button)findViewById(R.id.binder_service); 
        mBinderServiceButton.setOnClickListener(this);
        mUnbinderServiceButton = (Button)findViewById(R.id.unbiner_service);
        mUnbinderServiceButton.setOnClickListener(this);
        
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        
        mServiceDestroyBroadcastReceiver = new ServiceDestroyBroadcastReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ServiceForStartup.DETROY);
        registerReceiver(mServiceDestroyBroadcastReceiver, filter);
        
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mServiceDestroyBroadcastReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.getInstance().clearCache();
        stopService(mIntent);
        if (isBinder)
            unbindService(mServiceConnection);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_service:
                startService(mIntent);
                break;
            case R.id.stop_service:
                stopService(mIntent);
                break;
            case R.id.binder_service:
                isBinder = true;
                bindService(mIntent, mServiceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.unbiner_service:
                Logger.getInstance().appendCache("StartupServiceActivity: count: " + mCountService.getCount() + "\n");
                isBinder = false;
                unbindService(mServiceConnection);
                break;
        }
    }
    
    class ServiceDestroyBroadcastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            mTextView.setText(Logger.getInstance().getCache());
        }
        
    }
    
}
