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
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;


/**
 * @author b690
 *
 */
public class TextViewLife extends TextView {

    public TextViewLife(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Logger.getInstance().appendOtherCache("View: TextView: TextViewLife(Context context, AttributeSet attrs, int defStyle)\n");
    }

    public TextViewLife(Context context, AttributeSet attrs) {
        super(context, attrs);
        Logger.getInstance().appendOtherCache("View: TextView: TextViewLife(Context context, AttributeSet attrs)\n");
    }

    public TextViewLife(Context context) {
        super(context);
        Logger.getInstance().appendOtherCache("View: TextView: TextViewLife(Context context)\n");
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Logger.getInstance().appendOtherCache("View: TextView: onSaveInstanceState()\n");
        return super.onSaveInstanceState();
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
        Logger.getInstance().appendOtherCache("View: TextView: onRestoreInstanceState(Parcelable state)\n");
    }

    @Override
    public void onEditorAction(int actionCode) {
        super.onEditorAction(actionCode);
        Logger.getInstance().appendOtherCache("View: TextView: onEditorAction(int actionCode)\n");
    }

    @Override
    public boolean onPreDraw() {
        Logger.getInstance().appendOtherCache("View: TextView: onPreDraw()\n");
        return super.onPreDraw();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger.getInstance().appendOtherCache("View: TextView: onAttachedToWindow()\n");
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logger.getInstance().appendOtherCache("View: TextView: onDetachedFromWindow()\n");
    }

    @Override
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        Logger.getInstance().appendOtherCache("View: TextView: onScreenStateChanged(int screenState)\n");
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        Logger.getInstance().appendOtherCache("View: TextView: onCreateDrawableState(int extraSpace)\n");
        return super.onCreateDrawableState(extraSpace);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Logger.getInstance().appendOtherCache("View: TextView: onDraw(Canvas canvas)\n");
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        Logger.getInstance().appendOtherCache("View: TextView: onKeyPreIme(int keyCode, KeyEvent event)\n");
        return super.onKeyPreIme(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Logger.getInstance().appendOtherCache("View: TextView: onKeyDown(int keyCode, KeyEvent event)\n");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        Logger.getInstance().appendOtherCache("View: TextView: onKeyMultiple(int keyCode, int repeatCount, KeyEvent event)\n");
        return super.onKeyMultiple(keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Logger.getInstance().appendOtherCache("View: TextView: onKeyUp(int keyCode, KeyEvent event)\n");
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onCheckIsTextEditor() {
        Logger.getInstance().appendOtherCache("View: TextView: onCheckIsTextEditor()\n");
        return super.onCheckIsTextEditor();
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Logger.getInstance().appendOtherCache("View: TextView: onCreateInputConnection(EditorInfo outAttrs)\n");
        return super.onCreateInputConnection(outAttrs);
    }

    @Override
    public void onCommitCompletion(CompletionInfo text) {
        super.onCommitCompletion(text);
        Logger.getInstance().appendOtherCache("View: TextView: onCommitCompletion(CompletionInfo text)\n");
    }

    @Override
    public void onCommitCorrection(CorrectionInfo info) {
        super.onCommitCorrection(info);
        Logger.getInstance().appendOtherCache("View: TextView: onCommitCorrection(CorrectionInfo info)\n");
    }

    @Override
    public void onBeginBatchEdit() {
        super.onBeginBatchEdit();
        Logger.getInstance().appendOtherCache("View: TextView: onBeginBatchEdit()\n");
    }

    @Override
    public void onEndBatchEdit() {
        super.onEndBatchEdit();
        Logger.getInstance().appendOtherCache("View: TextView: onEndBatchEdit()\n");
    }

    @Override
    public boolean onPrivateIMECommand(String action, Bundle data) {
        Logger.getInstance().appendOtherCache("View: TextView: onPrivateIMECommand(String action, Bundle data)\n");
        return super.onPrivateIMECommand(action, data);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Logger.getInstance().appendOtherCache("View: TextView: onMeasure(int widthMeasureSpec, int heightMeasureSpec)\n");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Logger.getInstance().appendOtherCache("View: TextView: onLayout(boolean changed, int left, int top, int right, int bottom)\n");
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        Logger.getInstance().appendOtherCache("View: TextView: onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter)\n");
    }

    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        Logger.getInstance().appendOtherCache("View: TextView: onSelectionChanged(int selStart, int selEnd)\n");
    }

    @Override
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        Logger.getInstance().appendOtherCache("View: TextView: onStartTemporaryDetach()\n");
    }

    @Override
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        Logger.getInstance().appendOtherCache("View: TextView: onFinishTemporaryDetach()\n");
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        Logger.getInstance().appendOtherCache("View: TextView: onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect)\n");
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Logger.getInstance().appendOtherCache("View: TextView: onWindowFocusChanged(boolean hasWindowFocus)\n");
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        Logger.getInstance().appendOtherCache("View: TextView: onVisibilityChanged(View changedView, int visibility)\n");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.getInstance().appendOtherCache("View: TextView: onTouchEvent(MotionEvent event)\n");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        Logger.getInstance().appendOtherCache("View: TextView: onGenericMotionEvent(MotionEvent event)\n");
        return super.onGenericMotionEvent(event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        Logger.getInstance().appendOtherCache("View: TextView: onTrackballEvent(MotionEvent event)\n");
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        Logger.getInstance().appendOtherCache("View: TextView: onKeyShortcut(int keyCode, KeyEvent event)\n");
        return super.onKeyShortcut(keyCode, event);
    }

    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        Logger.getInstance().appendOtherCache("View: TextView: onPopulateAccessibilityEvent(AccessibilityEvent event)\n");
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        Logger.getInstance().appendOtherCache("View: TextView: onInitializeAccessibilityEvent(AccessibilityEvent event)\n");
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        Logger.getInstance().appendOtherCache("View: TextView: onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info)\n");
    }

    @Override
    public boolean onTextContextMenuItem(int id) {
        Logger.getInstance().appendOtherCache("View: TextView: onTextContextMenuItem(int id)\n");
        return super.onTextContextMenuItem(id);
    }

    @Override
    protected void onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert) {
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert);
        Logger.getInstance().appendOtherCache("View: TextView: onScrollChanged(int horiz, int vert, int oldHoriz, int oldVert)\n");
    }

    @Override
    public boolean onDragEvent(DragEvent event) {
        Logger.getInstance().appendOtherCache("View: TextView: onDragEvent(DragEvent event)\n");
        return super.onDragEvent(event);
    }

    @Override
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        Logger.getInstance().appendOtherCache("View: TextView: onFilterTouchEventForSecurity(MotionEvent event)\n");
        return super.onFilterTouchEventForSecurity(event);
    }

    @Override
    protected void onDisplayHint(int hint) {
        super.onDisplayHint(hint);
        Logger.getInstance().appendOtherCache("View: TextView: onDisplayHint(int hint)\n");
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        Logger.getInstance().appendOtherCache("View: TextView: \n");
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Logger.getInstance().appendOtherCache("View: TextView: onConfigurationChanged(Configuration newConfig)\n");
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Logger.getInstance().appendOtherCache("View: TextView: onKeyLongPress(int keyCode, KeyEvent event)\n");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    protected void onCreateContextMenu(ContextMenu menu) {
        super.onCreateContextMenu(menu);
        Logger.getInstance().appendOtherCache("View: TextView: onCreateContextMenu(ContextMenu menu)\n");
    }

    @Override
    public boolean onHoverEvent(MotionEvent event) {
        Logger.getInstance().appendOtherCache("View: TextView: onHoverEvent(MotionEvent event)\n");
        return super.onHoverEvent(event);
    }

    @Override
    public void onHoverChanged(boolean hovered) {
        super.onHoverChanged(hovered);
        Logger.getInstance().appendOtherCache("View: TextView: onHoverChanged(boolean hovered)\n");
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Logger.getInstance().appendOtherCache("View: TextView:  onSizeChanged(int w, int h, int oldw, int oldh)\n");
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Logger.getInstance().appendOtherCache("View: TextView: onFinishInflate()\n");
    }

    @Override
    protected void onAnimationStart() {
        super.onAnimationStart();
        Logger.getInstance().appendOtherCache("View: TextView: onAnimationStart()\n");
    }

    @Override
    protected void onAnimationEnd() {
        super.onAnimationEnd();
        Logger.getInstance().appendOtherCache("View: TextView: onAnimationEnd()\n");
    }

    @Override
    protected boolean onSetAlpha(int alpha) {
        Logger.getInstance().appendOtherCache("View: TextView: onSetAlpha(int alpha)\n");
        return super.onSetAlpha(alpha);
    }

    @Override
    public void onWindowSystemUiVisibilityChanged(int visible) {
        super.onWindowSystemUiVisibilityChanged(visible);
        Logger.getInstance().appendOtherCache("View: TextView: onWindowSystemUiVisibilityChanged(int visible)\n");
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        Logger.getInstance().appendOtherCache("View: TextView: onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY)\n");
    }
    
    
    

}
