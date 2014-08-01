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
package com.nothingoneday.feature.base.activitys;

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.log.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityLife extends Activity implements OnClickListener{

    private static final String TAG = ActivityLife.class.getSimpleName();
    
    TextView mTextView;
    Button mClearButton, mShowButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        
        mTextView = (TextView)findViewById(R.id.log);
        mClearButton = (Button)findViewById(R.id.clear);
        mClearButton.setOnClickListener(this);
        mShowButton = (Button)findViewById(R.id.show);
        mShowButton.setOnClickListener(this);

        Log.d(TAG, "onCreate()");
        Logger.getInstance().appendCache(getString(R.string.activity_life_log_oncreate));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
        Logger.getInstance().appendCache(getString(R.string.activity_life_log_onstart));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
        Logger.getInstance().appendCache(getString(R.string.activity_life_log_onrestart));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
        Logger.getInstance().appendCache(getString(R.string.activity_life_log_onresume));
        
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
        Logger.getInstance().appendCache(getString(R.string.activity_life_log_onpause));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
        Logger.getInstance().appendCache(getString(R.string.activity_life_log_onstop));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
        Logger.getInstance().appendCache(getString(R.string.activity_life_log_ondestroy));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState()");
        Logger.getInstance().appendCache(getString(R.string.activity_life_log_onrestoreinstancestate));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState()");
        Logger.getInstance().appendCache(getString(R.string.activity_life_log_onsaveinstancestate));
    }

    public void onClick(View v) {
        switch(v.getId()){
            case R.id.clear:
                Logger.getInstance().clearCache();
                mTextView.setText("");
                break;
            case R.id.show:
                mTextView.setText(Logger.getInstance().getCache());
                break;
            default:
                break;
        }
        
    }

}
