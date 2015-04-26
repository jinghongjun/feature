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

import com.nothingoneday.feature.base.log.Logger;


/**
 * 1.Android中的坐标系统：
 *  屏幕的左上角是坐标系统的原点（0，0），原点向右延伸是X轴正方向，原点向下延伸是Y轴正方向
 * 2.View的坐标：View的坐标是相对父容器而言的，包括：getTop() getBottom() getLeft() getRight()
 * 3.MotionEvent类中getRowX()(触摸点相对于屏幕原点的x坐标)和getX()(触摸点相对于其所在组件的原点X坐标)
 * 4.自定义组件基本方法
 *      1)让你的类继承一个现有的View类或View的子类
 *      2)重写父类一些方法：需要重写的的父类方法一般以“on”开头，如onDraw(),onMeasure(),onKeyDown等等
 *      3)使用你的继承类
 *      4)
 */

/**
 * @author b690
 *
 */
public class ViewLife extends View {
    
    private static final String TAG = ViewLife.class.getSimpleName();
    
    public ViewLife(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Logger.getInstance().appendCache("View callbace: View(Context context, AttributeSet attrs, int defStyle)\n");
    }

    public ViewLife(Context context, AttributeSet attrs) {
        super(context, attrs);
        Logger.getInstance().appendCache("View callbace: View(Context context, AttributeSet attrs)\n");
    }

    public ViewLife(Context context) {
        super(context);
        Logger.getInstance().appendCache("View callbace: View(Context context)\n");
    }

    /* 
     * 当系统解析XML完成，并且将子View全部完成之后调用这个方法，我们通常重写这个方法，在这个方法中查找并获得子View
     * 的引用。
     * 
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Logger.getInstance().appendCache("View callbace: onFinishInflate()\n");
    }

    /* 
     * 测试这个View的高和宽，通过调用这个方法来设置View的测量后的宽和高
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Logger.getInstance().appendCache("View callbace: onMeasure(int widthMeasureSpec, int heightMeasureSpec)\n");
    }

    /* 
     * 用来指定各个子View的位置
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Logger.getInstance().appendCache("View callbace: onLayout(boolean changed, int left, int top, int right, int bottom)\n");
    }

    /* 
     * 当View大小改变时调用
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Logger.getInstance().appendCache("View callbace: onSizeChanged(int w, int h, int oldw, int oldh)\n");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Logger.getInstance().appendCache("View callbace: onDraw(Canvas canvas)\n");
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Logger.getInstance().appendCache("View callbace: dispatchDraw(Canvas canvas)\n");
    }

    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        Logger.getInstance().appendCache("View callbace: onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect)\n");
    }

    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        Logger.getInstance().appendCache("View callbace: onPopulateAccessibilityEvent(AccessibilityEvent event)\n");
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        Logger.getInstance().appendCache("View callbace: onInitializeAccessibilityEvent(AccessibilityEvent event)\n");
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        Logger.getInstance().appendCache("View callbace: onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info)\n");
    }

    @Override
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Logger.getInstance().appendCache("View callbace: onStartTemporaryDetach()\n");
    }

    @Override
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        Logger.getInstance().appendCache("View callbace: onFinishTemporaryDetach()\n");
    }

    @Override
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        Logger.getInstance().appendCache("View callbace: onFilterTouchEventForSecurity(MotionEvent event)\n");
        return super.onFilterTouchEventForSecurity(event);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Logger.getInstance().appendCache("View callbace: onWindowFocusChanged(boolean hasWindowFocus)\n");
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        Logger.getInstance().appendCache("View callbace: onVisibilityChanged(View changedView, int visibility)\n");
    }

    @Override
    protected void onDisplayHint(int hint) {
        super.onDisplayHint(hint);
        Logger.getInstance().appendCache("View callbace: onDisplayHint(int hint)\n");
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        Logger.getInstance().appendCache("View callbace: onWindowVisibilityChanged(int visibility)\n");
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Logger.getInstance().appendCache("View callbace: onConfigurationChanged(Configuration newConfig)\n");
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        Logger.getInstance().appendCache("View callbace: onKeyPreIme(int keyCode, KeyEvent event)\n");
        return super.onKeyPreIme(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Logger.getInstance().appendCache("View callbace: onKeyDown(int keyCode, KeyEvent event)\n");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Logger.getInstance().appendCache("View callbace: onKeyLongPress(int keyCode, KeyEvent event)\n");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Logger.getInstance().appendCache("View callbace: onKeyUp(int keyCode, KeyEvent event)\n");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        Logger.getInstance().appendCache("View callbace: onKeyMultiple(int keyCode, int repeatCount, KeyEvent event)\n");
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Logger.getInstance().appendCache("View callbace: onKeyShortcut(int keyCode, KeyEvent event)\n");
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onCheckIsTextEditor() {
        Logger.getInstance().appendCache("View callbace: onCheckIsTextEditor()\n");
        return super.onCheckIsTextEditor();
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Logger.getInstance().appendCache("View callbace: onCreateInputConnection(EditorInfo outAttrs)\n");
        return super.onCreateInputConnection(outAttrs);
    }

    @Override
    protected void onCreateContextMenu(ContextMenu menu) {
        Logger.getInstance().appendCache("View callbace: onCreateContextMenu(ContextMenu menu) \n");
        super.onCreateContextMenu(menu);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        Logger.getInstance().appendCache("View callbace: onTrackballEvent(MotionEvent event)\n");
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        Logger.getInstance().appendCache("View callbace: onGenericMotionEvent(MotionEvent event)\n");
        return super.onGenericMotionEvent(event);
    }

    @Override
    public boolean onHoverEvent(MotionEvent event) {
        Logger.getInstance().appendCache("View callbace: onHoverEvent(MotionEvent event)\n");
        return super.onHoverEvent(event);
    }

    @Override
    public void onHoverChanged(boolean hovered) {
        super.onHoverChanged(hovered);
        Logger.getInstance().appendCache("View callbace: onHoverChanged(boolean hovered)\n");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.getInstance().appendCache("View callbace: onTouchEvent(MotionEvent event)\n");
        return super.onTouchEvent(event);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        Logger.getInstance().appendCache("View callbace: onScrollChanged(int l, int t, int oldl, int oldt)\n");
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger.getInstance().appendCache("View callbace: onAttachedToWindow()\n");
    }

    @Override
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        Logger.getInstance().appendCache("View callbace: onScreenStateChanged(int screenState)\n");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logger.getInstance().appendCache("View callbace: onDetachedFromWindow()\n");
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Logger.getInstance().appendCache("View callbace: onSaveInstanceState()\n");
        return super.onSaveInstanceState();
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        Logger.getInstance().appendCache("View callbace: onRestoreInstanceState(Parcelable state)\n");
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        Logger.getInstance().appendCache("View callbace: onCreateDrawableState(int extraSpace)\n");
        return super.onCreateDrawableState(extraSpace);
    }

    @Override
    protected void onAnimationStart() {
        super.onAnimationStart();
        Logger.getInstance().appendCache("View callbace: onAnimationStart()\n");
    }

    @Override
    protected void onAnimationEnd() {
        super.onAnimationEnd();
        Logger.getInstance().appendCache("View callbace: onAnimationEnd()\n");
    }

    @Override
    protected boolean onSetAlpha(int alpha) {
        Logger.getInstance().appendCache("View callbace: onSetAlpha(int alpha)\n");
        return super.onSetAlpha(alpha);
    }

    @Override
    public void onWindowSystemUiVisibilityChanged(int visible) {
        super.onWindowSystemUiVisibilityChanged(visible);
        Logger.getInstance().appendCache("View callbace: onWindowSystemUiVisibilityChanged(int visible)\n");
    }

    @Override
    public boolean onDragEvent(DragEvent event) {
        Logger.getInstance().appendCache("View callbace: onDragEvent(DragEvent event)\n");
        return super.onDragEvent(event);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        Logger.getInstance().appendCache("View callbace: onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY)\n");
    }

    

}
