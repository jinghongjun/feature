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

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * @author b690
 *
 */
public class CombinationLinearLayout extends LinearLayout {

    private static final String TAG = CombinationLinearLayout.class.getSimpleName();

    ImageView mImageView;
    TextView mTextView;
    
    public CombinationLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CombinationLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.combination_view_item, this, true);
        mImageView = (ImageView)findViewById(R.id.image);
        mTextView = (TextView)findViewById(R.id.text);
    }

    public CombinationLinearLayout(Context context) {
        super(context);
    }
    
    public void setImageForButton(int resid){
        mImageView.setBackgroundResource(resid);
    }
    
    public void setTextForTextView(String text){
        mTextView.setText(text);
    }

}
