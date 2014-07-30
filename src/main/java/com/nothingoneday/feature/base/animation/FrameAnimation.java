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
package com.nothingoneday.feature.base.animation;

import java.lang.reflect.Field;

import com.nothingoneday.feature.R;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

public class FrameAnimation extends Activity {
    
    private static final String TAG = FrameAnimation.class.getSimpleName();
    
    AnimationDrawable mAnimationDrawable, mRepeatPlayAnimationDrawable, mHardAnimationDrawable;
    ImageView mSampleImageView, mSampleRepeatPlayImageView, mHardImageView;
    
    HardAnimationDrawable mCustomHardAnimationDrawable;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_animation);

        //帧动画播放一次
        mAnimationDrawable = (AnimationDrawable)getResources().getDrawable(R.drawable.frame_animation);
        mSampleImageView = (ImageView)findViewById(R.id.sample_image);
        mSampleImageView.setBackground(mAnimationDrawable);
        mAnimationDrawable.start();
        
        //帧动画重复播放
        mRepeatPlayAnimationDrawable = (AnimationDrawable)getResources().getDrawable(R.drawable.frame_repeat_play_animation);
        mSampleRepeatPlayImageView = (ImageView)findViewById(R.id.sample_repeat_play_image);
        mSampleRepeatPlayImageView.setBackground(mRepeatPlayAnimationDrawable);
        mRepeatPlayAnimationDrawable.start();
        
        //复杂使用
        mHardAnimationDrawable = (AnimationDrawable)getResources().getDrawable(R.drawable.frame_hard_animation);
        mHardImageView = (ImageView)findViewById(R.id.hard_image);
        mCustomHardAnimationDrawable = new HardAnimationDrawable(mHardAnimationDrawable);
        mCustomHardAnimationDrawable.setAnimaitonListener(new HardAnimationListener(){

            public void onAnimationStart() {
                Log.d(TAG, "call back onAnimationStart");
            }

            public void onAnimationEnd() {
                Log.d(TAG, "call back onAnimationEnd");
            }
            
        });
        mHardImageView.setBackground(mHardAnimationDrawable);
        mCustomHardAnimationDrawable.start();
          
    }
    
    
    class HardAnimationDrawable extends AnimationDrawable {

        protected boolean mStart;
        protected HardAnimationListener mListener;
        protected AnimationDrawable mOriginAnimationDrawable;
        protected Handler mHandler;
        protected Runnable mRunnbel = new Runnable() {

            
            public void run() {
                
                if (!mStart)
                    return;
                
                if (!isAnimationEnd()) {
                    mHandler.postDelayed(this, 1000);
                    return;
                }
                
                if (mListener != null){
                    mStart = false;
                    mListener.onAnimationEnd();
                }
                
            }
            
        };
        
        public HardAnimationDrawable(AnimationDrawable animation){
            mOriginAnimationDrawable = animation;
            mHandler = new Handler();
            mStart = false;
        }
        
        @Override
        public void start() {
            mStart = true;
            mOriginAnimationDrawable.start();
            mHandler.post(mRunnbel);
            if (mListener != null)
                mListener.onAnimationStart();
        }
        
        public void setAnimaitonListener (HardAnimationListener listener) {
            mListener = listener;
        }
        
        private boolean isAnimationEnd(){
            Class<AnimationDrawable> animClass = AnimationDrawable.class;
            try{  
                
                Field field = animClass.getDeclaredField("mCurFrame");
                field.setAccessible(true);
                
                int currFrameNum = field.getInt(mOriginAnimationDrawable);
                int totalFrameNum = mOriginAnimationDrawable.getNumberOfFrames();
                if((currFrameNum == totalFrameNum - 1) ||
                   (currFrameNum == -1)){
                    return true;
                }
            }
            catch (Exception e) {
            }
            
            return false;
        }
       
    }
    
    public interface HardAnimationListener {
        public void onAnimationStart();
        public void onAnimationEnd();
    }
    
}
