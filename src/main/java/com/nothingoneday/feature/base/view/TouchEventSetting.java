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
import com.nothingoneday.feature.base.log.Logger;
import com.nothingoneday.feature.base.view.TouchEventConfig.TouchEventValue;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;


/**
 * @author b690
 *
 */
public class TouchEventSetting extends Activity implements OnCheckedChangeListener{
    
    RadioGroup mActivityDispatchTouchEventRadioGroup;
    RadioButton mTrueADRadioButton, mFalseADRadioButton, mDefaultADRadioButton;
    RadioGroup mActivityOnTouchEventRadioGroup;
    RadioButton mTrueAOERadioButton, mFalseAOERadioButton, mDefaultAOERadioButton;
    
    RadioGroup mGroupView1DispatchTouchEventRadioGroup;
    RadioButton mG1DTTrueRadioButton, mG1DTFalseRadioButton, mG1DTDefaultRadioButton;
    RadioGroup mGroupView1OnIntercetpTouchEventRadioGroup;
    RadioButton mG1OITETrueRadioButton, mG1OITEFalseRadioButton, mG1OITEDefaultRadioButton;
    RadioGroup mGroupView1OnTouchEventRadioGroup;
    RadioButton mG1OTETrueRadioButton, mG1OTEFalseRadioButton, mG1OTEDefaultRadioButton;
    
    RadioGroup mGroupView2DispatchTouchEventRadioGroup;
    RadioButton mG2DTTrueRadioButton, mG2DTFalseRadioButton, mG2DTDefaultRadioButton;
    RadioGroup mGroupView2OnIntercetpTouchEventRadioGroup;
    RadioButton mG2OITETrueRadioButton, mG2OITEFalseRadioButton, mG2OITEDefaultRadioButton;
    RadioGroup mGroupView2OnTouchEventRadioGroup;
    RadioButton mG2OTETrueRadioButton, mG2OTEFalseRadioButton, mG2OTEDefaultRadioButton;
    
    RadioGroup mViewOnTouchEventRadioGroup;
    RadioButton mTrueViewOnTouchadioButton, mFalseViewOnTouchRadioButton, mDefaultViewOnTouchRadioButton;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_setting);
        
        mActivityDispatchTouchEventRadioGroup = (RadioGroup)findViewById(R.id.activity_radio_group_dispatch_event);
        mActivityDispatchTouchEventRadioGroup.setOnCheckedChangeListener(this);
        mTrueADRadioButton = (RadioButton)findViewById(R.id.activity_dispatch_event_true);
        mFalseADRadioButton = (RadioButton)findViewById(R.id.activity_dispatch_event_false);
        mDefaultADRadioButton = (RadioButton)findViewById(R.id.activity_dispatch_event_default);
        
        mActivityOnTouchEventRadioGroup = (RadioGroup)findViewById(R.id.activity_radio_group_ontouch_event);
        mActivityOnTouchEventRadioGroup.setOnCheckedChangeListener(this);
        mTrueAOERadioButton = (RadioButton)findViewById(R.id.activity_ontouch_event_true);
        mFalseAOERadioButton = (RadioButton)findViewById(R.id.activity_ontouch_event_false);
        mDefaultAOERadioButton = (RadioButton)findViewById(R.id.activity_ontouch_event_default);
        
        mGroupView1DispatchTouchEventRadioGroup = (RadioGroup)findViewById(R.id.viewgroup1_radio_group_dispatch_event);
        mGroupView1DispatchTouchEventRadioGroup.setOnCheckedChangeListener(this);
        mG1DTTrueRadioButton = (RadioButton)findViewById(R.id.viewgroup1_dispatch_event_true);
        mG1DTFalseRadioButton = (RadioButton)findViewById(R.id.viewgroup1_dispatch_event_false);
        mG1DTDefaultRadioButton = (RadioButton)findViewById(R.id.viewgroup1_dispatch_event_default);
        
        
        mGroupView1OnIntercetpTouchEventRadioGroup = (RadioGroup)findViewById(R.id.viewgroup1_radio_group_intercept_event);
        mGroupView1OnIntercetpTouchEventRadioGroup.setOnCheckedChangeListener(this);
        mG1OITETrueRadioButton = (RadioButton)findViewById(R.id.viewgroup1_intercept_event_true);
        mG1OITEFalseRadioButton = (RadioButton)findViewById(R.id.viewgroup1_intercept_event_false);
        mG1OITEDefaultRadioButton = (RadioButton)findViewById(R.id.viewgroup1_intercept_event_default);
        
        
        mGroupView1OnTouchEventRadioGroup = (RadioGroup)findViewById(R.id.viewgroup1_radio_group_ontouch_event);
        mGroupView1OnTouchEventRadioGroup.setOnCheckedChangeListener(this);
        mG1OTETrueRadioButton = (RadioButton)findViewById(R.id.viewgroup1_ontouch_event_true);
        mG1OTEFalseRadioButton = (RadioButton)findViewById(R.id.viewgroup1_ontouch_event_false);
        mG1OTEDefaultRadioButton = (RadioButton)findViewById(R.id.viewgroup1_ontouch_event_default);
        
        
        mGroupView2DispatchTouchEventRadioGroup = (RadioGroup)findViewById(R.id.viewgroup2_radio_group_dispatch_event);
        mGroupView2DispatchTouchEventRadioGroup.setOnCheckedChangeListener(this);
        mG2DTTrueRadioButton = (RadioButton)findViewById(R.id.viewgroup2_dispatch_event_true);
        mG2DTFalseRadioButton = (RadioButton)findViewById(R.id.viewgroup2_dispatch_event_false);
        mG2DTDefaultRadioButton = (RadioButton)findViewById(R.id.viewgroup2_dispatch_event_default);
        
        mGroupView2OnIntercetpTouchEventRadioGroup = (RadioGroup)findViewById(R.id.viewgroup2_radio_group_intercept_event);
        mGroupView2OnIntercetpTouchEventRadioGroup.setOnCheckedChangeListener(this);
        mG2OITETrueRadioButton = (RadioButton)findViewById(R.id.viewgroup2_intercept_event_true);
        mG2OITEFalseRadioButton = (RadioButton)findViewById(R.id.viewgroup2_intercept_event_false);
        mG2OITEDefaultRadioButton = (RadioButton)findViewById(R.id.viewgroup2_intercept_event_default);
        
        mGroupView2OnTouchEventRadioGroup = (RadioGroup)findViewById(R.id.viewgroup2_radio_group_ontouch_event);
        mGroupView2OnTouchEventRadioGroup.setOnCheckedChangeListener(this);
        mG2OTETrueRadioButton = (RadioButton)findViewById(R.id.viewgroup2_ontouch_event_true);
        mG2OTEFalseRadioButton = (RadioButton)findViewById(R.id.viewgroup2_ontouch_event_false);
        mG2OTEDefaultRadioButton = (RadioButton)findViewById(R.id.viewgroup2_ontouch_event_default);
        
        mViewOnTouchEventRadioGroup = (RadioGroup)findViewById(R.id.view_radio_group_ontouch_event);
        mViewOnTouchEventRadioGroup.setOnCheckedChangeListener(this);
        mTrueViewOnTouchadioButton = (RadioButton)findViewById(R.id.view_ontouch_event_true);
        mFalseViewOnTouchRadioButton = (RadioButton)findViewById(R.id.view_ontouch_event_false);
        mDefaultViewOnTouchRadioButton = (RadioButton)findViewById(R.id.view_ontouch_event_default);
    }

    @Override
    protected void onResume() {
        super.onResume();
        switch (TouchEventConfig.getDispatchTouchEventForActivity()) {
            case TRUE:
                mTrueADRadioButton.setChecked(true);
                break;
            case FALSE:
                mFalseADRadioButton.setChecked(true);
                break;
            case DEFAULT:
                mDefaultADRadioButton.setChecked(true);
        }
        switch (TouchEventConfig.getOnTouchEventForActivity()) {
            case TRUE:
                mTrueAOERadioButton.setChecked(true);
                break;
            case FALSE:
                mFalseAOERadioButton.setChecked(true);
                break;
            case DEFAULT:
                mDefaultAOERadioButton.setChecked(true);
        }
        
        switch (TouchEventConfig.getDispatchTouchEventForViewGroup1()) {
            case TRUE:
                mG1DTTrueRadioButton.setChecked(true);
                break;
            case FALSE:
                mG1DTFalseRadioButton.setChecked(true);
                break;
            case DEFAULT:
                mG1DTDefaultRadioButton.setChecked(true);
        }
        
        switch (TouchEventConfig.getOnInterceptTouchEventForViewGroup1()) {
            case TRUE:
                mG1OITETrueRadioButton.setChecked(true);
                break;
            case FALSE:
                mG1OITEFalseRadioButton.setChecked(true);
                break;
            case DEFAULT:
                mG1OITEDefaultRadioButton.setChecked(true);
        }
        
        switch (TouchEventConfig.getOnTouchEventForViewGroup1()) {
            case TRUE:
                mG1OTETrueRadioButton.setChecked(true);
                break;
            case FALSE:
                mG1OTEFalseRadioButton.setChecked(true);
                break;
            case DEFAULT:
                mG1OTEDefaultRadioButton.setChecked(true);
        }
        
        switch (TouchEventConfig.getDispatchTouchEventForViewGroup2()) {
            case TRUE:
                mG2DTTrueRadioButton.setChecked(true);
                break;
            case FALSE:
                mG2DTFalseRadioButton.setChecked(true);
                break;
            case DEFAULT:
                mG2DTDefaultRadioButton.setChecked(true);
        }
        
        switch (TouchEventConfig.getOnInterceptTouchEventForViewGroup2()) {
            case TRUE:
                mG2OITETrueRadioButton.setChecked(true);
                break;
            case FALSE:
                mG2OITEFalseRadioButton.setChecked(true);
                break;
            case DEFAULT:
                mG2OITEDefaultRadioButton.setChecked(true);
        }
        
        switch (TouchEventConfig.getOnTouchEventForViewGroup2()) {
            case TRUE:
                mG2OTETrueRadioButton.setChecked(true);
                break;
            case FALSE:
                mG2OTEFalseRadioButton.setChecked(true);
                break;
            case DEFAULT:
                mG2OTEDefaultRadioButton.setChecked(true);
        }
        
        switch (TouchEventConfig.getOnTouchEventForView()) {
            case TRUE:
                mTrueViewOnTouchadioButton.setChecked(true);
                break;
            case FALSE:
                mFalseViewOnTouchRadioButton.setChecked(true);
                break;
            case DEFAULT:
                mDefaultViewOnTouchRadioButton.setChecked(true);
        }
        
        
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()) {
            case R.id.activity_radio_group_dispatch_event:
                switch (checkedId){
                    case R.id.activity_dispatch_event_true:
                        TouchEventConfig.saveDispatchTouchEventForActivity(TouchEventValue.TRUE);
                        break;
                    case R.id.activity_dispatch_event_false:
                        TouchEventConfig.saveDispatchTouchEventForActivity(TouchEventValue.FALSE);
                        break;
                    case R.id.activity_dispatch_event_default:
                    default:
                        TouchEventConfig.saveDispatchTouchEventForActivity(TouchEventValue.DEFAULT);
                        break;
                }
                break;
            case R.id.activity_radio_group_ontouch_event:
                switch (checkedId){
                    case R.id.activity_ontouch_event_true:
                        TouchEventConfig.saveOnTouchEventForActivity(TouchEventValue.TRUE);
                        break;
                    case R.id.activity_ontouch_event_false:
                        TouchEventConfig.saveOnTouchEventForActivity(TouchEventValue.FALSE);
                        break;
                    case R.id.activity_ontouch_event_default:
                    default:
                        TouchEventConfig.saveOnTouchEventForActivity(TouchEventValue.DEFAULT);
                        break;
                }
                break;
            case R.id.viewgroup1_radio_group_dispatch_event:
                switch (checkedId){
                    case R.id.viewgroup1_dispatch_event_true:
                        TouchEventConfig.saveDispatchTouchEventForViewGroup1(TouchEventValue.TRUE);
                        break;
                    case R.id.viewgroup1_dispatch_event_false:
                        TouchEventConfig.saveDispatchTouchEventForViewGroup1(TouchEventValue.FALSE);
                        break;
                    case R.id.viewgroup1_dispatch_event_default:
                    default:
                        TouchEventConfig.saveDispatchTouchEventForViewGroup1(TouchEventValue.DEFAULT);
                        break;
                }
                break;
            case R.id.viewgroup1_radio_group_intercept_event:
                switch (checkedId){
                    case R.id.viewgroup1_intercept_event_true:
                        TouchEventConfig.saveOnInterceptTouchEventForViewGroup1(TouchEventValue.TRUE);
                        break;
                    case R.id.viewgroup1_intercept_event_false:
                        TouchEventConfig.saveOnInterceptTouchEventForViewGroup1(TouchEventValue.FALSE);
                        break;
                    case R.id.viewgroup1_intercept_event_default:
                    default:
                        TouchEventConfig.saveOnInterceptTouchEventForViewGroup1(TouchEventValue.DEFAULT);
                        break;
                }
                break;
            case R.id.viewgroup1_radio_group_ontouch_event:
                switch (checkedId){
                    case R.id.viewgroup1_ontouch_event_true:
                        TouchEventConfig.saveOnTouchEventForViewGroup1(TouchEventValue.TRUE);
                        break;
                    case R.id.viewgroup1_ontouch_event_false:
                        TouchEventConfig.saveOnTouchEventForViewGroup1(TouchEventValue.FALSE);
                        break;
                    case R.id.viewgroup1_ontouch_event_default:
                    default:
                        TouchEventConfig.saveOnTouchEventForViewGroup1(TouchEventValue.DEFAULT);
                        break;
                }
                break;
            case R.id.viewgroup2_radio_group_dispatch_event:
                switch (checkedId){
                    case R.id.viewgroup2_dispatch_event_true:
                        TouchEventConfig.saveDispatchTouchEventForViewGroup2(TouchEventValue.TRUE);
                        break;
                    case R.id.viewgroup2_dispatch_event_false:
                        TouchEventConfig.saveDispatchTouchEventForViewGroup2(TouchEventValue.FALSE);
                        break;
                    case R.id.viewgroup2_dispatch_event_default:
                    default:
                        TouchEventConfig.saveDispatchTouchEventForViewGroup2(TouchEventValue.DEFAULT);
                        break;
                }
                break;
            case R.id.viewgroup2_radio_group_intercept_event:
                switch (checkedId){
                    case R.id.viewgroup2_intercept_event_true:
                        TouchEventConfig.saveOnInterceptTouchEventForViewGroup2(TouchEventValue.TRUE);
                        break;
                    case R.id.viewgroup2_intercept_event_false:
                        TouchEventConfig.saveOnInterceptTouchEventForViewGroup2(TouchEventValue.FALSE);
                        break;
                    case R.id.viewgroup2_intercept_event_default:
                    default:
                        TouchEventConfig.saveOnInterceptTouchEventForViewGroup2(TouchEventValue.DEFAULT);
                        break;
                }
                break;
            case R.id.viewgroup2_radio_group_ontouch_event:
                switch (checkedId){
                    case R.id.viewgroup2_ontouch_event_true:
                        TouchEventConfig.saveOnTouchEventForViewGroup2(TouchEventValue.TRUE);
                        break;
                    case R.id.viewgroup2_ontouch_event_false:
                        TouchEventConfig.saveOnTouchEventForViewGroup2(TouchEventValue.FALSE);
                        break;
                    case R.id.viewgroup2_ontouch_event_default:
                    default:
                        TouchEventConfig.saveOnTouchEventForViewGroup2(TouchEventValue.DEFAULT);
                        break;
                }
                break;
            case R.id.view_radio_group_ontouch_event:
                switch (checkedId){
                    case R.id.view_ontouch_event_true:
                        TouchEventConfig.setOnTouchEventForView(TouchEventValue.TRUE);
                        break;
                    case R.id.view_ontouch_event_false:
                        TouchEventConfig.setOnTouchEventForView(TouchEventValue.FALSE);
                        break;
                    case R.id.view_ontouch_event_default:
                    default:
                        TouchEventConfig.setOnTouchEventForView(TouchEventValue.DEFAULT);
                        break;
                }
                break;
            default:
                break;
        }
        
    }

}
