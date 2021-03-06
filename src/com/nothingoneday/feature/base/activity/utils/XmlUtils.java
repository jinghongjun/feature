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
package com.nothingoneday.feature.base.activity.utils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.BaseActivity;
import com.nothingoneday.feature.base.HelpActivity;

public class XmlUtils extends BaseActivity {

    @Override
    public int getMenuRes() {
        return R.menu.android_common_tools_xml_tools;
    }

    @Override
    public boolean handleOptionsItemSelectedBySubclasses(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_help:
                Intent intent = new Intent(this, HelpActivity.class);
                Bundle data = new Bundle();
                data.putString(BaseActivity.EXTRA_TAG_HELP_WEB, mWebPath);
                intent.putExtra(BaseActivity.BUNDLE_TAG_DATA, data);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    public int getCreateItemRes() {
        return R.xml.android_common_tools_xml_utils;
    }

}
