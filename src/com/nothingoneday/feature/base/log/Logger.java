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
package com.nothingoneday.feature.base.log;

import android.util.Log;

public class Logger {
    
    private static final String TAG = "FEATURE";
    
    private static boolean OPEN_DEBUG = true;
    
    private static Logger mInstance;
    
    
    private StringBuffer mCache;
    
    private StringBuffer mOtherCache;
    
    private Logger(){
        mCache = new StringBuffer();
        mOtherCache = new StringBuffer();
    }
    
    public static Logger getInstance(){
        if (null == mInstance)
            mInstance = new Logger();
        return mInstance;
    }
    
    private String getCodeAddress(){
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        
        if (null == sts)
            return null;
        
        for (StackTraceElement st : sts) {
            
            if (st.isNativeMethod()) 
                continue;

            if (st.getClassName().equals(Thread.class.getClass()) || st.getClassName().equals(getInstance().getClass()))
                continue;
            
            return "[ " + st.getFileName() + ":" + st.getLineNumber() + " ]";
        }
        
        return null;
    }
    
    public void d(String tag, String msg){
        Log.d(tag, getCodeAddress() + "-" + msg);
    }

    public void d(String msg){
        Log.d(TAG, getCodeAddress() + "-" + msg);
    }

    public void i(String tag, String msg){
        Log.i(tag, getCodeAddress() + "-" + msg);
    }
    
    public void i(String msg){
        Log.i(TAG, getCodeAddress() + "-" + msg);
    }
    
    public void w(String tag, String msg){
        Log.d(tag, getCodeAddress() + "-" + msg);
    }
    
    public void w(String msg){
        Log.d(TAG, getCodeAddress() + "-" + msg);
    }
    
    public void v(String tag, String msg){
        Log.d(tag, getCodeAddress() + "-" + msg);
    }
    
    public void v(String msg){
        Log.d(TAG, getCodeAddress() + "-" + msg);
    }
    
    public void appendCache(String str){
        mCache.append(str);
    }
    
    public void clearCache(){
        mCache.delete(0, mCache.length());
    }
    
    public String getCache(){
        return mCache.toString();
    }
    
    public void appendOtherCache(String str){
        mOtherCache.append(str);
    }
    
    public void clearOtherCache(){
        mOtherCache.delete(0, mOtherCache.length());
    }
    
    public String getOtherCache(){
        return mOtherCache.toString();
    }
    
}
