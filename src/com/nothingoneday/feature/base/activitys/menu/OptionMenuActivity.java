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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


/**
 * @author b690
 *
 */
public class OptionMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option_menu);
    }

    /**
     * 第一次显示时被调用
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        //添加菜单多种方式
        //1.直接指定标题
        //menu.add("T");
        //2.通过资源指定标题
        //menu.add(R.string.menu_help);
        //3.指定菜单项的组号，ID，排序号，标题。
        /*
        menu.add(1, //组号
                Menu.FIRST, //ID号
                Menu.FIRST, //排序号 
                R.string.menu_help); //标题
        */
        //4.通过getMenuInflater()(用来实例化Menu目录下的Menu布局文件的)接口
        getMenuInflater().inflate(R.menu.option_menu, menu);
        
        //如果希望显示菜单
        return true;
        
    }

    /*
     * 动态改变菜单时被调用
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * 响应选项菜单事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String toast = "Click menu: ";
        switch (item.getItemId()) {
            case R.id.menu_1:
                toast += getString(R.string.option_menu_activity_menu_1);
                break;
            case R.id.menu_2:
                toast += getString(R.string.option_menu_activity_menu_2);
                break;
            case R.id.menu_2_1:
                toast += getString(R.string.option_menu_activity_menu_2_1);
                break;
            case R.id.menu_2_2:
                toast += getString(R.string.option_menu_activity_menu_2_2);
                break;
        }
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
    
}
