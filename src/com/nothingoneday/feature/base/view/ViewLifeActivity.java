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
package com.nothingoneday.feature.base.view;

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.log.Logger;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


/**
 * @author b690
 *
 */
public class ViewLifeActivity extends Activity {
    
    private static final String TAG = ViewLifeActivity.class.getSimpleName();
    
    TextView mRecordTextView, mRecord2TextView;
    Button mClearButton, mClear2Button;
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_life);
        
        mRecordTextView = (TextView)findViewById(R.id.result);
        mClearButton = (Button)findViewById(R.id.clear);
        mClearButton.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                Logger.getInstance().clearCache();
                mRecordTextView.setText("");
            }
            
        });
        
        mRecord2TextView = (TextView)findViewById(R.id.result2);
        mClear2Button = (Button)findViewById(R.id.clear2);
        mClear2Button.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                Logger.getInstance().clearOtherCache();
                mRecord2TextView.setText("");
            }
            
        });
        
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRecordTextView.setText(Logger.getInstance().getCache());
        mRecord2TextView.setText(Logger.getInstance().getOtherCache());
    }
    
    
    
    

}
