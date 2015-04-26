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

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


/**
 * @author b690
 *
 */
public class RemoteServiceActivity extends Activity implements OnClickListener{
    
    private final static String TAG = RemoteServiceActivity.class.getSimpleName();
    
    TextView mTextView;
    Button mBinderButton, mUnbinderButton, mGetDataButton;
    
    Intent mIntent;
    
    IRemoteCountService mRemoteCountService;

    private ServiceConnection mServiceConnection = new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder service) {
            mRemoteCountService = IRemoteCountService.Stub.asInterface(service);
        }

        public void onServiceDisconnected(ComponentName name) {
        }
        
    };
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remote_service);
        
        mTextView  = (TextView)findViewById(R.id.log);
        mBinderButton = (Button)findViewById(R.id.binder_service);
        mBinderButton.setOnClickListener(this);
        mUnbinderButton = (Button)findViewById(R.id.unbiner_service);
        mUnbinderButton.setOnClickListener(this);
        mGetDataButton = (Button)findViewById(R.id.getData);
        mGetDataButton.setOnClickListener(this);
        
        mIntent = new Intent(RemoteCountService.ACTION);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.binder_service:
                bindService(mIntent, mServiceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.unbiner_service:
                unbindService(mServiceConnection);
                break;
            case R.id.getData:
                try {
                    int count = mRemoteCountService.getCount().mCount;
                    mTextView.setText(String.valueOf(count));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

}
