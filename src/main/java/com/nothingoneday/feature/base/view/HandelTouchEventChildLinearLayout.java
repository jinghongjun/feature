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

import com.nothingoneday.feature.base.log.Logger;
import com.nothingoneday.feature.base.view.TouchEventConfig.TouchEventValue;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;


/**
 * @author b690
 *
 */
public class HandelTouchEventChildLinearLayout extends LinearLayout {

    private final static String TAG = HandelTouchEventChildLinearLayout.class.getSimpleName();
    
    public HandelTouchEventChildLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public HandelTouchEventChildLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HandelTouchEventChildLinearLayout(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        TouchEventValue value = TouchEventConfig.getDispatchTouchEventForViewGroup2();
        Logger.getInstance().d("TouchEventChild: dispatchTouchEvent--> " + TouchEventUtil.getTouchAction(ev.getAction()) + ", config: " + TouchEventConfig.getTouchEventValueString(value) + "\n");
        Logger.getInstance().appendCache("TouchEventChild: dispatchTouchEvent--> " + TouchEventUtil.getTouchAction(ev.getAction()) + "\n");
        switch (value) {
            case TRUE:
                return true;
            case FALSE:
                return false;
            case DEFAULT:
            default:
                return super.dispatchTouchEvent(ev);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        TouchEventValue value = TouchEventConfig.getOnInterceptTouchEventForViewGroup2();
        Logger.getInstance().d("TouchEventChild: onInterceptTouchEvent--> " + TouchEventUtil.getTouchAction(ev.getAction()) + ", config: " + TouchEventConfig.getTouchEventValueString(value) + "\n");
        Logger.getInstance().appendCache("TouchEventChild: onInterceptTouchEvent--> " + TouchEventUtil.getTouchAction(ev.getAction()) + "\n");
        switch (value) {
            case TRUE:
                return true;
            case FALSE:
                return false;
            case DEFAULT:
            default:
                return super.onInterceptTouchEvent(ev);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        TouchEventValue value = TouchEventConfig.getOnTouchEventForViewGroup2();
        Logger.getInstance().d("TouchEventChild: onTouchEvent--> " + TouchEventUtil.getTouchAction(event.getAction()) + ", config: " + TouchEventConfig.getTouchEventValueString(value) + "\n");
        Logger.getInstance().appendCache("TouchEventChild: onTouchEvent--> " + TouchEventUtil.getTouchAction(event.getAction()) + "\n");
        switch (value) {
            case TRUE:
                return true;
            case FALSE:
                return false;
            case DEFAULT:
            default:
                return super.onTouchEvent(event);
        }
        
    }
    
}
