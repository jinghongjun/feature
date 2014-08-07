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


/**
 * @author b690
 *
 */
public class TouchEventConfig {
    
    public enum TouchEventValue {
        TRUE, FALSE, DEFAULT
    }
    
    public static String getTouchEventValueString(TouchEventValue value){
        String v = null;
        switch (value){
            case TRUE:
                v = "true";
                break;
            case FALSE:
                v = "false";
                break;
            case DEFAULT:
                v = "default";
                break;
        }
        return v;
    }
    
    /**
     * Activity touch event 
     */
    private static TouchEventValue ACTIVITY_DISPATCH_TOUCH_EVENT = TouchEventValue.DEFAULT;
    private static TouchEventValue ACTIVIYT_ON_TOUCH_EVENT = TouchEventValue.DEFAULT;
    
    /**
     * GroupView1 touch event
     */
    private static TouchEventValue VIEW_GROUP_1_DISPATCH_TOUCH_EVENT = TouchEventValue.DEFAULT;
    private static TouchEventValue VIEW_GROUP_1_ON_INTERCEPT_TOUCH_EVENT = TouchEventValue.DEFAULT;
    private static TouchEventValue VIEW_GROUP_1_ON_TOUCH_EVENT = TouchEventValue.DEFAULT;
    
    /**
     * GroupView2 touch event
     */
    private static TouchEventValue VIEW_GROUP_2_DISPATCH_TOUCH_EVENT = TouchEventValue.DEFAULT;
    private static TouchEventValue VIEW_GROUP_2_ON_INTERCEPT_TOUCH_EVENT = TouchEventValue.DEFAULT;
    private static TouchEventValue VIEW_GROUP_2_ON_TOUCH_EVENT = TouchEventValue.DEFAULT;
    
    /**
     * TextView touch event
     */
    private static TouchEventValue VIEW_DISPATCH_TOUCH_EVENT = TouchEventValue.DEFAULT;
    private static TouchEventValue VIEW_ON_INTERCEPT_TOUCH_EVENT = TouchEventValue.DEFAULT;
    private static TouchEventValue VIEW_ON_TOUCH_EVENT = TouchEventValue.DEFAULT;
    
    public static void saveDispatchTouchEventForActivity(TouchEventValue value){
        ACTIVITY_DISPATCH_TOUCH_EVENT = value;
    }
    
    public static TouchEventValue getDispatchTouchEventForActivity(){
        return ACTIVITY_DISPATCH_TOUCH_EVENT;
    }
    
    public static void saveOnTouchEventForActivity(TouchEventValue value){
        ACTIVIYT_ON_TOUCH_EVENT = value;
    }
    
    public static TouchEventValue getOnTouchEventForActivity(){
        return ACTIVIYT_ON_TOUCH_EVENT;
    }
    
    public static void saveDispatchTouchEventForViewGroup1(TouchEventValue value){
        VIEW_GROUP_1_DISPATCH_TOUCH_EVENT = value;
    }
    
    public static TouchEventValue getDispatchTouchEventForViewGroup1(){
        return VIEW_GROUP_1_DISPATCH_TOUCH_EVENT;
    }
    
    public static void saveOnInterceptTouchEventForViewGroup1(TouchEventValue value){
        VIEW_GROUP_1_ON_INTERCEPT_TOUCH_EVENT = value;
    }
    
    public static TouchEventValue getOnInterceptTouchEventForViewGroup1(){
        return VIEW_GROUP_1_ON_INTERCEPT_TOUCH_EVENT;
    }
    
    public static void saveOnTouchEventForViewGroup1(TouchEventValue value){
        VIEW_GROUP_1_ON_TOUCH_EVENT = value;
    }
    
    public static TouchEventValue getOnTouchEventForViewGroup1(){
        return VIEW_GROUP_1_ON_TOUCH_EVENT;
    }
    
    public static void saveDispatchTouchEventForViewGroup2(TouchEventValue value){
        VIEW_GROUP_2_DISPATCH_TOUCH_EVENT = value;
    }
    
    public static TouchEventValue getDispatchTouchEventForViewGroup2(){
        return VIEW_GROUP_2_DISPATCH_TOUCH_EVENT;
    }
    
    public static void saveOnInterceptTouchEventForViewGroup2(TouchEventValue value){
        VIEW_GROUP_2_ON_INTERCEPT_TOUCH_EVENT = value;
    }
    
    public static TouchEventValue getOnInterceptTouchEventForViewGroup2(){
        return VIEW_GROUP_2_ON_INTERCEPT_TOUCH_EVENT;
    }
    
    public static void saveOnTouchEventForViewGroup2(TouchEventValue value){
        VIEW_GROUP_2_ON_TOUCH_EVENT = value;
    }
    
    public static TouchEventValue getOnTouchEventForViewGroup2(){
        return VIEW_GROUP_2_ON_TOUCH_EVENT;
    }
    
    public static void saveDispatchTouchEventForView(TouchEventValue value){
        VIEW_DISPATCH_TOUCH_EVENT = value;
    }
    
    public static TouchEventValue getDispatchTouchEventForView(){
        return VIEW_DISPATCH_TOUCH_EVENT;
    }
    
    public static void saveOnInterceptTouchEventForView(TouchEventValue value){
        VIEW_ON_INTERCEPT_TOUCH_EVENT = value;
    }
    
    public static TouchEventValue getOnInterceptTouchEventForView(){
        return VIEW_ON_INTERCEPT_TOUCH_EVENT;
    }
    
    public static void setOnTouchEventForView(TouchEventValue value){
        VIEW_ON_TOUCH_EVENT = value;
    }
    
    public static TouchEventValue getOnTouchEventForView(){
        return VIEW_ON_TOUCH_EVENT;
    }
    
    public static void clearTouchEvent(){
        ACTIVITY_DISPATCH_TOUCH_EVENT = TouchEventValue.DEFAULT;
        ACTIVIYT_ON_TOUCH_EVENT = TouchEventValue.DEFAULT;
        
        VIEW_GROUP_1_DISPATCH_TOUCH_EVENT = TouchEventValue.DEFAULT;
        VIEW_GROUP_1_ON_INTERCEPT_TOUCH_EVENT = TouchEventValue.DEFAULT;
        VIEW_GROUP_1_ON_TOUCH_EVENT = TouchEventValue.DEFAULT;
        
        VIEW_GROUP_2_DISPATCH_TOUCH_EVENT = TouchEventValue.DEFAULT;
        VIEW_GROUP_2_ON_INTERCEPT_TOUCH_EVENT = TouchEventValue.DEFAULT;
        VIEW_GROUP_2_ON_TOUCH_EVENT = TouchEventValue.DEFAULT;
        
        VIEW_DISPATCH_TOUCH_EVENT = TouchEventValue.DEFAULT;
        VIEW_ON_INTERCEPT_TOUCH_EVENT = TouchEventValue.DEFAULT;
        VIEW_ON_TOUCH_EVENT = TouchEventValue.DEFAULT;
    }
    
}
