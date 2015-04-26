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
package com.nothingoneday.feature.base.activitys.actionbar;

import com.nothingoneday.feature.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


/**
 * @author b690
 *
 */
public class ActionBarBottomActivity extends Activity {
    
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_bar);
        mTextView = (TextView)findViewById(R.id.txt);
        mTextView.setText(R.string.action_bar_activity_1);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String toast = "Click actionbar: ";
        switch (item.getItemId()) {
            case R.id.actionbar_1:
                toast += getString(R.string.actionbar_1);
                break;
            case R.id.actionbar_2:
                toast += getString(R.string.actionbar_2);
                break;
            case R.id.actionbar_2_1:
                toast += getString(R.string.actionbar_2_1);
                break;
            case R.id.actionbar_2_2:
                toast += getString(R.string.actionbar_2_2);
                break;
            default:
                break;
        }
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
        return true;
    }

}
