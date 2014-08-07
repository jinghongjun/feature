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

import android.view.MenuItem;

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.BaseActivity;


/**
 * @author b690
 *
 */
public class ViewFeatureList extends BaseActivity {

    /* (non-Javadoc)
     * @see com.nothingoneday.feature.base.BaseActivity#getMenuRes()
     */
    @Override
    public int getMenuRes() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see com.nothingoneday.feature.base.BaseActivity#handleOptionsItemSelectedBySubclasses(android.view.MenuItem)
     */
    @Override
    public boolean handleOptionsItemSelectedBySubclasses(MenuItem item) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.nothingoneday.feature.base.BaseActivity#getCreateItemRes()
     */
    @Override
    public int getCreateItemRes() {
        // TODO Auto-generated method stub
        return R.xml.view_main;
    }

}
