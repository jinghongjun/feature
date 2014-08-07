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

import com.nothingoneday.feature.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;


/**
 * @author b690
 *
 */
public class CustomViewActivity extends Activity {
    
    private static final String TAG = CustomViewActivity.class.getSimpleName();

    private LayoutInflater mLayoutInflater;
    GridView mGridView;
    GridViewAdapter mGridViewAdapter;
    private int[] mImages = {R.drawable.panda, R.drawable.panda, R.drawable.panda, R.drawable.panda, R.drawable.panda, R.drawable.panda};

    
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view);
        
        mGridView = (GridView)findViewById(R.id.grid);
        mGridViewAdapter = new GridViewAdapter();
        mGridView.setAdapter(mGridViewAdapter);
        mLayoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    
    private class GridViewAdapter extends BaseAdapter {

        /* (non-Javadoc)
         * @see android.widget.Adapter#getCount()
         */
        public int getCount() {
            return mImages.length;
        }

        /* (non-Javadoc)
         * @see android.widget.Adapter#getItem(int)
         */
        public Object getItem(int position) {
            return mImages[position];
        }

        /* (non-Javadoc)
         * @see android.widget.Adapter#getItemId(int)
         */
        public long getItemId(int position) {
            return position;
        }

        /* (non-Javadoc)
         * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
         */
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mLayoutInflater.inflate(R.layout.item, null);
                holder.customView = (CustomView) convertView.findViewById(R.id.customview);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.customView.setImageBitmap(BitmapFactory.decodeResource(getResources(), mImages[position]));
            holder.customView.setTitleText("Title: " + position +" Panda");
            holder.customView.setSubTitleText("SubTitle:  " + position +" Panda");
            return convertView;
        }

    }
    
    static class ViewHolder {
        CustomView customView;
    }
    

}
