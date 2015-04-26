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
package com.nothingoneday.feature.base.api.sync;

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.log.Logger;


import android.app.Activity;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * @author b690
 *
 */
public class AsyncQueryHandlerActivity extends Activity {
    
    private final static String TAG = AsyncQueryHandlerActivity.class.getSimpleName();

    ListView mListView;
    TextView mCallbackTextView;
    Button mButton;
    
    QueryHandler mQueryHandler;
    
    ContactCursorAdapter mContactCursorAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_query_handler);

        mListView = (ListView)findViewById(R.id.list);
        mCallbackTextView = (TextView)findViewById(R.id.callback);
        mButton = (Button)findViewById(R.id.async);
        mContactCursorAdapter = new ContactCursorAdapter(this, null);
        mListView.setAdapter(mContactCursorAdapter);
        
        mQueryHandler = new QueryHandler(getContentResolver());
        
        mButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Logger.getInstance().appendCache(Thread.currentThread().getName() +  " call back: AsyncQueryHandler.startQuery()\n");
                mQueryHandler.startQuery(0, null, ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        new String[] {ContactsContract.CommonDataKinds.Phone._ID, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME}, null, null, null);
                
            }

        });
        
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.getInstance().clearCache();
    }



    /**
     * 数据量比较大时应该考虑使用
     * 
     * AsyncQueryHandler内部实现: 封装了调用者线程与工作线程的交互过程，交互的主体是两个Handler,一个运行在调用线程中，一个
     * 运行在工作者线程中，通过提供的onXXXComplete的回调接口，实现事件的完成处理。
     * 
     * API中提供startInsert,startDelete,startUpdate,startQuery四种方法，并有响应的onXXXComplete()方法都是空实现。
     */
     class QueryHandler extends AsyncQueryHandler {

        public QueryHandler(ContentResolver cr) {
            super(cr);
        }

        @Override
        protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
            super.onQueryComplete(token, cookie, cursor);
            Logger.getInstance().appendCache(Thread.currentThread().getName() +  " call back: AsyncQueryHandler.onQueryComplete()\n");
            mCallbackTextView.setText(Logger.getInstance().getCache());
            mContactCursorAdapter.changeCursor(cursor);
        }

        @Override
        protected void onInsertComplete(int token, Object cookie, Uri uri) {
            super.onInsertComplete(token, cookie, uri);
        }

        @Override
        protected void onUpdateComplete(int token, Object cookie, int result) {
            super.onUpdateComplete(token, cookie, result);
        }

        @Override
        protected void onDeleteComplete(int token, Object cookie, int result) {
            super.onDeleteComplete(token, cookie, result);
        }
         
     }
     
    
     class ContactCursorAdapter extends CursorAdapter{

        public ContactCursorAdapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            LayoutInflater mLayoutInfater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            return mLayoutInfater.inflate(R.layout.contact_item, null);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView contact = (TextView)view.findViewById(R.id.contact);
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            contact.setText(name);
        }
         
     }
     

}
