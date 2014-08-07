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
import com.nothingoneday.feature.base.BaseConstant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


/**
 * @author b690
 *
 */
public class ActionBarActivity extends Activity {
    
    private final static String TAG = ActionBarActivity.class.getSimpleName();
    
    //Style:normal
    private static final int ACTION_BAR_STYLE_NORMAL = 0;
    //Style:Split Action Bar
    private static final int ACTION_BAR_STYLE_SPLIT = 1;
    //Style:Up Navigation<
    private static final int ACTION_BAR_STYLE_UP_NAVIGATION = 2;
    //Style:Theme.Holo
    private static final int ACTION_BAR_STYLE_THEME_HOLO = 3;
    //Style:Theme.Holo.Light
    private static final int ACTION_BAR_STYLE_THEME_HOLO_LIGHT = 4;
    //Style:Theme.Holo.Light.DarkActionBar
    private static final int ACTION_BAR_STYLE_THEME_HOLO_LIGHT_DARK = 5;
    //Style:Custom
    private static final int ACTION_BAR_STYLE_CUSTOM = 6;

    TextView mTextView;
    private int mActionBarThemeType = ACTION_BAR_STYLE_NORMAL;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle data = getIntent().getBundleExtra(BaseConstant.BUNDLE_TAG_DATA);
        mActionBarThemeType = data.getInt("int");
        initActivityTheme();
        
        super.onCreate(savedInstanceState);

        setContentView(R.layout.action_bar);
        mTextView = (TextView)findViewById(R.id.txt);
        initTextView();
        
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
    
    private void initActivityTheme(){
        switch (mActionBarThemeType) {
            case ACTION_BAR_STYLE_NORMAL:
                break;
/*            case ACTION_BAR_STYLE_SPLIT:
                break;*/
            case ACTION_BAR_STYLE_UP_NAVIGATION:
                getActionBar().setDisplayHomeAsUpEnabled(true);  
                getActionBar().setHomeButtonEnabled(true);  
                break;
            case ACTION_BAR_STYLE_THEME_HOLO:
                setTheme(android.R.style.Theme_Holo);
                break;
            case ACTION_BAR_STYLE_THEME_HOLO_LIGHT:
                setTheme(android.R.style.Theme_Holo_Light);
                break;
            case ACTION_BAR_STYLE_THEME_HOLO_LIGHT_DARK:
                setTheme(android.R.style.Theme_Holo_Light_DarkActionBar);
                break;
            case ACTION_BAR_STYLE_CUSTOM:
                setTheme(R.style.Theme_Custom);
                break;
            default:
                break;
        }
    }
    
    private void initTextView(){
        switch (mActionBarThemeType) {
            case ACTION_BAR_STYLE_NORMAL:
                mTextView.setText(R.string.action_bar_activity_0);
                break;
/*            case ACTION_BAR_STYLE_SPLIT:
                mTextView.setText(R.string.action_bar_activity_1);
                break;*/
            case ACTION_BAR_STYLE_UP_NAVIGATION:
                mTextView.setText(R.string.action_bar_activity_2);
                break;
            case ACTION_BAR_STYLE_THEME_HOLO:
                mTextView.setText(R.string.action_bar_activity_3);
                break;
            case ACTION_BAR_STYLE_THEME_HOLO_LIGHT:
                mTextView.setText(R.string.action_bar_activity_4);
                break;
            case ACTION_BAR_STYLE_THEME_HOLO_LIGHT_DARK:
                mTextView.setText(R.string.action_bar_activity_5);
                break;
            case ACTION_BAR_STYLE_CUSTOM:
                mTextView.setText(R.string.action_bar_activity_6);
                break;
            default:
                break;
        }
    }
    
    
}
