package com.nothingoneday.feature.base.activity;

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.R.layout;
import com.nothingoneday.feature.R.menu;
import com.nothingoneday.feature.base.BaseActivity;
import com.nothingoneday.feature.base.HelpActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends BaseActivity {
    
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    public int getMenuRes() {
        return R.menu.main;
    }

    @Override
    public boolean handleOptionsItemSelectedBySubclasses(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_help:
                Intent intent = new Intent(this, HelpActivity.class);
                Bundle data = new Bundle();
                data.putString(BaseActivity.EXTRA_TAG_HELP_WEB, "file:///android_asset/main/main.html");
                intent.putExtra(BaseActivity.BUNDLE_TAG_DATA, data);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    public int getCreateItemRes() {
        return R.xml.main_content;
    }


}
