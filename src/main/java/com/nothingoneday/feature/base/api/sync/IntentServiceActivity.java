/*
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

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.log.Logger;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


/**
 * @author b690
 *
 */
public class IntentServiceActivity extends Activity implements OnClickListener{
    
    private final static String TAG = IntentServiceActivity.class.getSimpleName();
    
    public static final String TASK_1_ACTION = "com.nothingoneday.feature.TASK_1_ACTION";
    public static final String TASK_2_ACTION = "com.nothingoneday.feature.TASK_2_ACTION";

    Button btn1, btn2;
    TextView btn1Log, btn2Log;
    
    TaskBroadcastReceiver mTaskBroadcastReceiver;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_service);
        
        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button)findViewById(R.id.btn2);
        btn2.setVisibility(View.GONE);
        btn2.setOnClickListener(this);
        btn1Log = (TextView)findViewById(R.id.btn1_log);
        btn2Log = (TextView)findViewById(R.id.btn2_log);
        btn2Log.setVisibility(View.GONE);
        mTaskBroadcastReceiver = new TaskBroadcastReceiver();

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(TASK_1_ACTION);
        mIntentFilter.addAction(TASK_2_ACTION);
        registerReceiver(mTaskBroadcastReceiver, mIntentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mTaskBroadcastReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.getInstance().clearCache();
    }

    public void onClick(View v) {
        Intent intent = new Intent(AsyncIntentService.ACTION);
        Bundle data = new Bundle();
        intent.putExtra(AsyncIntentService.DATA, data);
        switch (v.getId()){
            case R.id.btn1:
                data.putInt(AsyncIntentService.DATA, AsyncIntentService.TASK_1);
                break;
            case R.id.btn2:
                data.putInt(AsyncIntentService.DATA, AsyncIntentService.TASK_2);
                break;
            default:
                break;
        }
        startService(intent);
    }
    

    class TaskBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (TASK_1_ACTION.equals(action)) {
                btn1Log.setText(Logger.getInstance().getCache());
            } else if (TASK_2_ACTION.equals(action)) {
                btn2Log.setText(Logger.getInstance().getCache());
            }
        }
        
    }
}
