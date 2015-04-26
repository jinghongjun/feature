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
public class HandleTouchEventFatherLinearLayout extends LinearLayout {

    private static final String TAG = HandleTouchEventFatherLinearLayout.class.getSimpleName();
    
    public HandleTouchEventFatherLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public HandleTouchEventFatherLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HandleTouchEventFatherLinearLayout(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        TouchEventValue value = TouchEventConfig.getDispatchTouchEventForViewGroup1();
        Logger.getInstance().d("TouchEventFather: dispatchTouchEvent--> " + TouchEventUtil.getTouchAction(ev.getAction()) + ", config: " + TouchEventConfig.getTouchEventValueString(value) + "\n");
        Logger.getInstance().appendCache("TouchEventFather: dispatchTouchEvent--> " + TouchEventUtil.getTouchAction(ev.getAction()) + "\n");
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
        TouchEventValue value = TouchEventConfig.getOnInterceptTouchEventForViewGroup1();
        Logger.getInstance().d("TouchEventFather: onInterceptTouchEvent--> " + TouchEventUtil.getTouchAction(ev.getAction()) + ", config: " + TouchEventConfig.getTouchEventValueString(value) + "\n");
        Logger.getInstance().appendCache("TouchEventFather: onInterceptTouchEvent--> " + TouchEventUtil.getTouchAction(ev.getAction()) + "\n");
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
        TouchEventValue value = TouchEventConfig.getOnTouchEventForViewGroup1();
        Logger.getInstance().d("TouchEventFather: onTouchEvent--> " + TouchEventUtil.getTouchAction(event.getAction()) + ", config: " + TouchEventConfig.getTouchEventValueString(value) + "\n");
        Logger.getInstance().appendCache("TouchEventFather: onTouchEvent--> " + TouchEventUtil.getTouchAction(event.getAction()) + "\n");
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
