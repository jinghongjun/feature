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
package com.nothingoneday.feature.base.activitys.menu;

import com.nothingoneday.feature.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import android.widget.Toast;


/**
 * @author b690
 *
 */
public class ActionModeMenuActivity extends Activity implements OnLongClickListener {
    
    TextView mTextView;
    ActionMode mActionMode;
    ActionModeCallBack mActionModeCallBack = new ActionModeCallBack();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_mode_menu);
        mTextView = (TextView)findViewById(R.id.action_mode);
        
        mTextView.setOnLongClickListener(this);
    }

    
    class ActionModeCallBack implements ActionMode.Callback {

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.action_mode_menu, menu);
            return true;
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            String toast = "Click action mode menu: ";
            switch (item.getItemId()) {
                case R.id.action_mode_menu_1:
                    toast += getString(R.string.action_mode_activity_menu_1);
                    break;
                case R.id.action_mode_menu_2:
                    toast += getString(R.string.action_mode_activity_menu_2);
                    break;
                case R.id.action_mode_menu_2_1:
                    toast += getString(R.string.action_mode_activity_menu_2_1);
                    break;
                case R.id.action_mode_menu_2_2:
                    toast += getString(R.string.action_mode_activity_menu_2_2);
                    break;
                default:
                    break;
            }
            Toast.makeText(ActionModeMenuActivity.this, toast, Toast.LENGTH_SHORT).show();
            return true;
        }

        public void onDestroyActionMode(ActionMode mode) {
        }
        
    }

    public boolean onLongClick(View v) {
        if (mActionMode != null) {
            return false;
        }
        mActionMode = startActionMode(mActionModeCallBack);
        v.setSelected(true);
        return true;
    } 
    

}
