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
import com.nothingoneday.feature.base.activity.ViewLogActivity;
import com.nothingoneday.feature.base.log.Logger;
import com.nothingoneday.feature.base.view.TouchEventConfig.TouchEventValue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;


/**
 * @author b690
 *
 */
public class HandleTouchEventActivity extends Activity {

    TextView mResultTextView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handle_touch_event);
        mResultTextView = (TextView)findViewById(R.id.result);
        mResultTextView.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                Toast.makeText(HandleTouchEventActivity.this, R.string.handle_touch_event_activity_toast, Toast.LENGTH_SHORT).show();
                Logger.getInstance().clearCache();
            }
            
        });
        Logger.getInstance().clearCache();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        TouchEventValue value =  TouchEventConfig.getOnTouchEventForActivity();
        Logger.getInstance().d("TouchEventActiviyt: onTouchEvent--> " + TouchEventUtil.getTouchAction(event.getAction()) + ", config: " + TouchEventConfig.getTouchEventValueString(value) + "\n");
        Logger.getInstance().appendCache("TouchEventActiviyt: onTouchEvent--> " + TouchEventUtil.getTouchAction(event.getAction()) + "\n");
        switch (value) {
            case TRUE:
                return true;
            case FALSE:
                return false;
            case DEFAULT:
                return super.onTouchEvent(event);
            default:
                return super.onTouchEvent(event);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        TouchEventValue value =  TouchEventConfig.getDispatchTouchEventForActivity();
        Logger.getInstance().d("TouchEventActiviyt: dispatchTouchEvent--> " + TouchEventUtil.getTouchAction(ev.getAction()) + ", config: " + TouchEventConfig.getTouchEventValueString(value) + "\n");
        Logger.getInstance().appendCache("TouchEventActiviyt: dispatchTouchEvent--> " + TouchEventUtil.getTouchAction(ev.getAction()) + "\n");
        switch (value) {
            case TRUE:
                return true;
            case FALSE:
                return false;
            case DEFAULT:
                return super.dispatchTouchEvent(ev);
            default:
                return super.dispatchTouchEvent(ev);
        }
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        TouchEventConfig.clearTouchEvent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.touch_menu, menu);
        return true;
    }
    
    

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                startActivity(new Intent(this, TouchEventSetting.class));
                break;
            case R.id.log:
                startActivity(new Intent(this, ViewLogActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    
}
