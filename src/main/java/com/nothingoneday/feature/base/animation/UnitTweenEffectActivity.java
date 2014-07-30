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

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.BaseConstant;
import com.nothingoneday.feature.base.log.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


/**
 * @author b690
 *
 */
public class UnitTweenEffectActivity extends Activity {
    
    private static final String TAG = UnitTweenEffectActivity.class.getSimpleName();
    
    private int mType;
    TextView mTextView;
    private AnimationListener mAnimationListener = new AnimationListener(){

        public void onAnimationStart(Animation animation) {
            Logger.getInstance().d(TAG, "onAnimationStart");
        }

        public void onAnimationEnd(Animation animation) {
            Logger.getInstance().d(TAG, "onAnimationEnd");
        }

        public void onAnimationRepeat(Animation animation) {
            Logger.getInstance().d(TAG, "onAnimationRepeat");
        }
        
    };

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_tween_effect);
        
        mTextView = (TextView)findViewById(R.id.text_widget);
    }
    
    
    /* (non-Javadoc)
     * @see android.app.Activity#onStart()
     */
    @Override
    protected void onStart() {
        super.onStart();
        handleAnimationEffect();
    }

    private void handleAnimationEffect(){
        Bundle data = getIntent().getBundleExtra(BaseConstant.BUNDLE_TAG_DATA);
        if (data != null) {
            mType = data.getInt("int");
            Logger.getInstance().d(TAG, "type: " + mType);
        }
        switch (mType) {
            case 0:
                handleAlphaEffect();
                break;
            case 1:
                handleRotateEffect();
                break;
            case 2:
                handleScaleEffect();
                break;
            case 3:
                handleTransEffect();
                break;
            case 4:
                handleAlphaScaleEffect();
                break;
            case 5:
                handleAlphaTranslateEffect();
                break;
            case 6:
                handleAlphaRotateEffect();
                break;
            case 7:
                handleScaleRotateEffect();
                break;
            case 8:
                handleScaleRotateEffect();
                break;
            case 9:
                handleTranslateRotateEffect();
                break;
            case 10:
                handleAlphaScaleTranslateEffect();
                break;
            case 11:
                handleAlphaScaleRotateEffect();
                break;
            case 12:
                handleAlphaTranslateRotateEffect();
                break;
            case 13:
                handleScaleTranslateRotate();
            case 14:
                handleAlphaScaleTranslateRotate();
                break;
            default:
                break;
        }
        
    }
    
    private void handleAlphaEffect() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.unit_tween_animation_alpha);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_alpha);
        mTextView.startAnimation(anim);
    }

    private void handleTransEffect() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.unit_tween_animation_trans);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_trans);
        mTextView.startAnimation(anim);
    }

    private void handleScaleEffect() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.unit_tween_animation_scale);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_scale);
        mTextView.startAnimation(anim);
    }

    private void handleRotateEffect() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.unit_tween_animation_rotate);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_rotate);
        mTextView.startAnimation(anim);
    }
 
    private void handleAlphaScaleEffect() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.combination_tween_alpha_scale);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_4);
        mTextView.startAnimation(anim);
    }
    
    private void handleAlphaTranslateEffect() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.combination_tween_alpha_translate);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_5);
        mTextView.startAnimation(anim);
    }
    
    private void handleAlphaRotateEffect() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.combination_tween_alpha_rotate);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_6);
        mTextView.startAnimation(anim);
    }
    
    private void handleScaleRotateEffect() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.combination_tween_scale_rotate);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_7);
        mTextView.startAnimation(anim);
    }
    
    private void handleTranslateRotateEffect() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.combination_tween_translate_rotate);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_8);
        mTextView.startAnimation(anim);
    }
    
    private void handleAlphaScaleTranslateEffect() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.combination_tween_alpha_scale_translate);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_9);
        mTextView.startAnimation(anim);
    }
    
    private void handleAlphaScaleRotateEffect() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.combination_tween_alpha_scale_rotate);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_10);
        mTextView.startAnimation(anim);
    }
    
    private void handleAlphaTranslateRotateEffect() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.combination_tween_alpha_translate_rotate);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_11);
        mTextView.startAnimation(anim);
    }
    
    private void handleScaleTranslateRotate(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.combination_tween_scale_translate_rotate);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_12);
        mTextView.startAnimation(anim);
    }
    
    private void handleAlphaScaleTranslateRotate(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.combination_tween_alpha_scale_translate_rotate);
        anim.setAnimationListener(mAnimationListener);
        mTextView.setText(R.string.unit_tween_effect_13);
        mTextView.startAnimation(anim);
    }
}
