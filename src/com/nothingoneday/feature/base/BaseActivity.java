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
package com.nothingoneday.feature.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.log.Logger;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public abstract class BaseActivity extends Activity implements OnItemClickListener, BaseConstant{
    
    private static final String TAG = BaseActivity.class.getSimpleName();
    
    /**
     * The following view user loads an error message
     */
    private LinearLayout mPromptLinearLayout;
    private TextView mPromptTextView;
    
    /**
     * The following list shows the view for
     */
    private ListView mListView;
    private List<Item> mItems;
    private ItemAdapter mItemAdpater;
    
    /**
     * Used to display user help
     */
    protected String mWebPath;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDataByIntent();
    }
    
    /**
     * Load subclass specified menu
     */
    public abstract int getMenuRes();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (0 != getMenuRes())
            getMenuInflater().inflate(getMenuRes(), menu);
        return true;
    }
    
    /**
     * Implemented by subclasses handle the corresponding menu
     * 
     */
    public abstract boolean handleOptionsItemSelectedBySubclasses(MenuItem item);

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return handleOptionsItemSelectedBySubclasses(item);
    }
    
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
        Item item = mItems.get(position);
        String action = item.mAction;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getPackageName(), action));
        Bundle data = new Bundle();
        //Get Help page position
        data.putString(EXTRA_TAG_HELP_WEB, item.mHelpWeb);
        if (item.mBundle == null) {
            intent.putExtra(BUNDLE_TAG_DATA, data);
        } else {
            if (!item.mBundle.isEmpty()) {
                intent.putExtra(BUNDLE_TAG_DATA, item.mBundle);
            }
        }
        com.nothingoneday.feature.base.log.Logger.getInstance().d(TAG, "start activity: " + intent.getComponent());
        startActivity(intent);
    }
    
    private void initDataByIntent(){
        if (null != getIntent()) {
            Bundle data = getIntent().getBundleExtra(BUNDLE_TAG_DATA);
            if (null != data) {
                mWebPath = data.getString(EXTRA_TAG_HELP_WEB); 
            }
        }
    }
    
    private void initView(){
        
        mPromptLinearLayout = (LinearLayout)findViewById(R.id.prompt_panel);
        mPromptTextView = (TextView)findViewById(R.id.prompt);
        
        mListView = (ListView)findViewById(R.id.list);
        mListView.setOnItemClickListener(this);
        mItems = createAdapter(getCreateItemRes());
        if (mItems != null) {
            mItemAdpater = new ItemAdapter(mItems);
            mListView.setAdapter(mItemAdpater);
        } else {
            mPromptLinearLayout.setVisibility(View.VISIBLE);
            mPromptTextView.setText(R.string.base_activity_txv_tips);
        }
    }
    
    /**
     * Get a list of resources displayed by subclass. Resources are stored in the res / xml
     * @return: Resource id
     */
    public abstract int getCreateItemRes();
    
    private List<Item> createAdapter(int res){
        List<Item> items = null;
        Item item = null;
        if (0 != res) {
            XmlPullParser parser = getResources().getXml(res);
            try {
                int eventType = parser.getEventType();
                while (XmlPullParser.END_DOCUMENT != eventType){
                    switch (eventType) {
                        case XmlPullParser.START_DOCUMENT:
                            items = new ArrayList<Item>();
                        break;
                        case XmlPullParser.START_TAG:
                            if (TAG_ITEM.equals(parser.getName())) {
                                item = new Item();
                            } else if (TAG_MAIN_TITLE.equals(parser.getName())) {
                                item.mMainTitle = parser.nextText();
                            } else if (TAG_ATTCHAED.equals(parser.getName())){
                                item.mAttachedTitle = parser.nextText();
                            } else if (TAG_ACTION.equals(parser.getName())) {
                                item.mAction = parser.nextText();
                            } else if (TAG_WEB.equals(parser.getName())){
                                item.mHelpWeb = parser.nextText();
                            } else if (TAB_BUNDLE.equals(parser.getName())) {
                                String type = parser.getAttributeValue(null, TAB_BUNDLE_TYPE);
                                String bundle = parser.nextText();
                                if (!TextUtils.isEmpty(type) && !TextUtils.isEmpty(bundle)) {
                                    if (item.mBundle == null) {
                                        item.mBundle = new Bundle();
                                    }
                                    if (TAB_BUNDLE_TYPE_INT.equals(type)) {
                                        item.mBundle.putInt(TAB_BUNDLE_TYPE_INT, Integer.parseInt(bundle));
                                    } else if (TAB_BUNDLE_TYPE_BOOLEAN.equals(type)) {
                                        item.mBundle.putBoolean(TAB_BUNDLE_TYPE_BOOLEAN, Boolean.parseBoolean(bundle));
                                    } else if (TAB_BUNDLE_TYPE_LONG.equals(type)) {
                                        item.mBundle.putLong(TAB_BUNDLE_TYPE_LONG, Long.parseLong(bundle));
                                    }
                                }
                                
                            }
                            break;
                        case XmlPullParser.END_TAG:
                            if (TAG_ITEM.equals(parser.getName())) {
                                items.add(item);
                            }
                            break;
                    }
                    eventType = parser.next();
                        
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            
        }
        return items;
    }
    
    /**
     * List item data
     */
    class Item {
        

        String mMainTitle;   //item name

        String mAttachedTitle;   //Subheadings used to explain the main title

        String mAction;  //Action content for display
        
        String mHelpWeb;  //Open help to explain the
        
        Bundle mBundle;
    }
    
    /**
     * use to list 
     *
     */
    class ItemAdapter extends BaseAdapter {
        
        private List<Item> mList;
        
        public ItemAdapter(List<Item> list) {
            mList = list;
        }

        public int getCount() {
            return mList.size();
        }

        public Object getItem(int position) {
            return mList.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            Item item = (Item) getItem(position);
            if (null == convertView) {
                LayoutInflater inflater =
                        (LayoutInflater) BaseActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.activity_main_item, null);
            }
            TextView mainTitle = (TextView) convertView.findViewById(R.id.main_title);
            mainTitle.setText(item.mMainTitle);
            TextView attachedTitle = (TextView) convertView.findViewById(R.id.attached_title);
            attachedTitle.setText(item.mAttachedTitle);
            return convertView;
        }
        
    }
    
}
 