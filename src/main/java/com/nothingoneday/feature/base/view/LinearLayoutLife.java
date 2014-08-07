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
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.LinearLayout;


/**
 * @author b690
 *
 */
public class LinearLayoutLife extends LinearLayout {

    public LinearLayoutLife(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: LinearLayoutLife(Context context, AttributeSet attrs, int defStyle)\n");
    }

    public LinearLayoutLife(Context context, AttributeSet attrs) {
        super(context, attrs);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: LinearLayoutLife(Context context, AttributeSet attrs)\n");
    }

    public LinearLayoutLife(Context context) {
        super(context);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: LinearLayoutLife(Context context)\n");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onDraw(Canvas canvas)\n");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onMeasure(int widthMeasureSpec, int heightMeasureSpec)\n");
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onLayout(boolean changed, int l, int t, int r, int b)\n");
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onInitializeAccessibilityEvent(AccessibilityEvent event)\n");
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info)\n");
    }

    @Override
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onRequestSendAccessibilityEvent(View child, AccessibilityEvent event)\n");
        return super.onRequestSendAccessibilityEvent(child, event);
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onInterceptHoverEvent(MotionEvent event)\n");
        return super.onInterceptHoverEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onInterceptTouchEvent(MotionEvent ev)\n");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    protected boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect)\n");
        return super.onRequestFocusInDescendants(direction, previouslyFocusedRect);
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onCreateDrawableState(int extraSpace)\n");
        return super.onCreateDrawableState(extraSpace);
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect)\n");
    }

    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onPopulateAccessibilityEvent(AccessibilityEvent event)\n");
    }

    @Override
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onStartTemporaryDetach()\n");
    }

    @Override
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onFinishTemporaryDetach()\n");
    }

    @Override
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onFilterTouchEventForSecurity(MotionEvent event)\n");
        return super.onFilterTouchEventForSecurity(event);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onWindowFocusChanged(boolean hasWindowFocus)\n");
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onVisibilityChanged(View changedView, int visibility\n");
    }

    @Override
    protected void onDisplayHint(int hint) {
        super.onDisplayHint(hint);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onDisplayHint(int hint)\n");
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onWindowVisibilityChanged(int visibility)\n");
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onConfigurationChanged(Configuration newConfig)\n");
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onKeyPreIme(int keyCode, KeyEvent event)\n");
        return super.onKeyPreIme(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onKeyDown(int keyCode, KeyEvent event)\n");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onKeyLongPress(int keyCode, KeyEvent event)\n");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onKeyUp(int keyCode, KeyEvent event)\n");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onKeyMultiple(int keyCode, int repeatCount, KeyEvent event)\n");
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onKeyShortcut(int keyCode, KeyEvent event)\n");
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onCheckIsTextEditor() {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onCheckIsTextEditor()\n");
        return super.onCheckIsTextEditor();
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onCreateInputConnection(EditorInfo outAttrs)\n");
        return super.onCreateInputConnection(outAttrs);
    }

    @Override
    protected void onCreateContextMenu(ContextMenu menu) {
        super.onCreateContextMenu(menu);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onCreateContextMenu(ContextMenu menu)\n");
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onTrackballEvent(MotionEvent event)\n");
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onGenericMotionEvent(MotionEvent event)\n");
        return super.onGenericMotionEvent(event);
    }

    @Override
    public boolean onHoverEvent(MotionEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onHoverEvent(MotionEvent event)\n");
        return super.onHoverEvent(event);
    }

    @Override
    public void onHoverChanged(boolean hovered) {
        super.onHoverChanged(hovered);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onHoverChanged(boolean hovered)\n");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onTouchEvent(MotionEvent event)\n");
        return super.onTouchEvent(event);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onScrollChanged(int l, int t, int oldl, int oldt)\n");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onSizeChanged(int w, int h, int oldw, int oldh)\n");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onAttachedToWindow()\n");
    }

    @Override
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onScreenStateChanged(int screenState)\n");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onDetachedFromWindow()\n");
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onSaveInstanceState()\n");
        return super.onSaveInstanceState();
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onRestoreInstanceState(Parcelable state)\n");
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onFinishInflate()\n");
    }

    @Override
    protected boolean onSetAlpha(int alpha) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onSetAlpha(int alpha)\n");
        return super.onSetAlpha(alpha);
    }

    @Override
    public void onWindowSystemUiVisibilityChanged(int visible) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onWindowSystemUiVisibilityChanged(int visible)\n");
        super.onWindowSystemUiVisibilityChanged(visible);
    }

    @Override
    public boolean onDragEvent(DragEvent event) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onDragEvent(DragEvent event)\n");
        return super.onDragEvent(event);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX,
            int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX,int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent)\n");
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY,
                isTouchEvent);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        Logger.getInstance().appendOtherCache("ViewGroup: LinearLayout: onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY)\n");
    }
    
}
