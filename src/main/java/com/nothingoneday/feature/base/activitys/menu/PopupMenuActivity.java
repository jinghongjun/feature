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
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;


/**
 * @author b690
 *
 */
public class PopupMenuActivity extends Activity implements OnMenuItemClickListener, OnClickListener{

    TextView mTextView;
    PopupMenu mPopupMenu;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_menu);
        mTextView = (TextView)findViewById(R.id.txt); 
        mTextView.setOnClickListener(this);
    }

    public boolean onMenuItemClick(MenuItem item) {
        String toast = "Click popup menu: ";
        switch (item.getItemId()) {
            case R.id.popup_menu_1:
                toast += getString(R.string.popup_activity_menu_1);
                break;
            case R.id.popup_menu_2:
                toast += getString(R.string.popup_activity_menu_2);
                break;
            case R.id.popup_menu_2_1:
                toast += getString(R.string.popup_activity_menu_2_1);
                break;
            case R.id.popup_menu_2_2:
                toast += getString(R.string.popup_activity_menu_2_2);
                break;
            default:
                break;
        }
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
        return true;
    }

    public void onClick(View v) {
        
        mPopupMenu = new PopupMenu(this, v); 
        mPopupMenu.getMenuInflater().inflate(R.menu.popup_menu, mPopupMenu.getMenu());
        mPopupMenu.setOnMenuItemClickListener(this);
        mPopupMenu.show();
    }
    
}
