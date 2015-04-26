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
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 * @author b690
 *
 */
public class ContextMenuActivity extends Activity {
    
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.context_menu);
        mTextView = (TextView)findViewById(R.id.txt);
        registerForContextMenu(mTextView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String toast = "Click context menu: ";
        switch (item.getItemId()) {
            case R.id.context_menu_1:
                toast += getString(R.string.context_menu_activity_menu_1);
                break;
            case R.id.context_menu_2:
                toast += getString(R.string.context_menu_activity_menu_2);
                break;
            case R.id.context_menu_2_1:
                toast += getString(R.string.context_menu_activity_menu_2_1);
                break;
            case R.id.context_menu_2_2:
                toast += getString(R.string.context_menu_activity_menu_2_2);
                break;
            default:
                break;
        }
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
        
        return super.onContextItemSelected(item);
    }

    @Override
    public void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }

}
