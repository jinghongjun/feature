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

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;


/**
 * @author b690
 *
 */
public class ViewGroupLife extends ViewGroup {
    
    private static final String TAG = ViewGroupLife.class.getSimpleName();


    public ViewGroupLife(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Logger.getInstance().appendCache("ViewGroup callback: ViewGroup(Context context, AttributeSet attrs, int defStyle)\n");
    }

    public ViewGroupLife(Context context, AttributeSet attrs) {
        super(context, attrs);
        Logger.getInstance().appendCache("ViewGroup callback: ViewGroup(Context context, AttributeSet attrs)\n");
    }

    public ViewGroupLife(Context context) {
        super(context);
        Logger.getInstance().appendCache("ViewGroup callback: ViewGroup(Context context)\n");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Logger.getInstance().appendCache("ViewGroup callback: onLayout(boolean changed, int l, int t, int r, int b)\n");
    }

    @Override
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        Logger.getInstance().appendCache("ViewGroup callback: onRequestSendAccessibilityEvent(View child, AccessibilityEvent event)\n");
        return super.onRequestSendAccessibilityEvent(child, event);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        Logger.getInstance().appendCache("ViewGroup callback: onInterceptHoverEvent(MotionEvent event)\n");
        return super.onInterceptHoverEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Logger.getInstance().appendCache("ViewGroup callback: onInterceptTouchEvent(MotionEvent ev)\n");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        Logger.getInstance().appendCache("ViewGroup callback: onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect)\n");
        return super.onRequestFocusInDescendants(direction, previouslyFocusedRect);
    }

    @Override
    protected void onAnimationStart() {
        super.onAnimationStart();
        Logger.getInstance().appendCache("ViewGroup callback: onAnimationStart()\n");
    }

    @Override
    protected void onAnimationEnd() {
        super.onAnimationEnd();
        Logger.getInstance().appendCache("ViewGroup callback: onAnimationEnd()\n");
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        Logger.getInstance().appendCache("ViewGroup callback: onCreateDrawableState(int extraSpace)\n");
        return super.onCreateDrawableState(extraSpace);
    }
    
    
    
    
    

}
