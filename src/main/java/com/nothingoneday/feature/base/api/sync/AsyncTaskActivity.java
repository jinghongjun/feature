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

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.log.Logger;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * @author b690
 *
 */
public class AsyncTaskActivity extends Activity {

    private final static String TAG = AsyncTaskActivity.class.getSimpleName();
    
    private final static String IMAGE_PATH = "http://developer.android.com/images/home/kk-hero.jpg";
    
    ImageView mImageView;
    Button mButton;
    ProgressDialog mProgressDialog;
    
    TextView mTextView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_task);
        
        Logger.getInstance().clearCache();
        
        mImageView = (ImageView)findViewById(R.id.image);
        mButton = (Button)findViewById(R.id.button);
        mButton.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
                new LoadAsyncTask().execute(IMAGE_PATH);
            }
            
        });
        
        mTextView = (TextView)findViewById(R.id.callback);
        
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("当前进度");
        mProgressDialog.setMessage("正在下载中，请稍后....");
        mProgressDialog.setCancelable(false);
        mProgressDialog.setProgress(ProgressDialog.STYLE_SPINNER);
        
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.getInstance().clearCache();
    }



    /**
     * AsyncTask
     *         1.<Params, Progress, Result>参数含义：
     *              1）Params：传递给异步任务执行时的参数
     *              2）Progress：异步任务执行时返回给UI线程的进度
     *              3）Result：异步任务执行完成后返回给UI线程的结果
     *  
     *         2.执行步骤
     *              1）onPreExecute()--UI Thread：执行异步任务之前，并且在UI线程中执行一些UI控件初始化工作
     *              2）doInBackground(Params... params)--Worker Thread：处理异步任务的方法，android会在后台线程中开启一个工作线程来执行这个方法
     *              3）onProgressUpdate(Progess... values)--UI Thread：后台任务执行的进度，这个方法调用之前，我们需要在doInBackground（)方法中调用一个publishProgress(Progress)时时刻刻传递给当前方法
     *              4）onPostExecute(Result... result)--UI Thread：异步任务执行完成后，将结果显示在UI控件上
     * 
     */
    class LoadAsyncTask extends AsyncTask<String, Integer, byte[]> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Logger.getInstance().appendCache(Thread.currentThread().getName() +  ": callback: onPreExecute()\n");
            mProgressDialog.show();
        }

        @Override
        protected byte[] doInBackground(String... params) {
            Logger.getInstance().appendCache(Thread.currentThread().getName() +  ": callback: doInBackground(String... params)\n");
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(params[0]);
            byte[] image =  new byte[]{};
            try {
                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                if (httpEntity != null && httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    image = EntityUtils.toByteArray(httpEntity);
                }
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                httpClient.getConnectionManager().shutdown();
            }
            return image;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Logger.getInstance().appendCache(Thread.currentThread().getName() +  ": callback: onProgressUpdate(Integer... values)\n");
        }

        @Override
        protected void onPostExecute(byte[] result) {
            super.onPostExecute(result);
            Logger.getInstance().appendCache(Thread.currentThread().getName() +  ": callback: onPostExecute(byte[] result)\n");
            Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
            mImageView.setImageBitmap(bitmap);
            mProgressDialog.dismiss();
            mTextView.setText(Logger.getInstance().getCache());
        }

    }
    
}
