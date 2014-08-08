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
package com.nothingoneday.feature.base.service;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * @author b690
 *
 */
public class CountBean implements Parcelable {
    
    public int mCount;
    
    public static final Parcelable.Creator<CountBean> CREATOR = new Creator<CountBean>(){

        public CountBean createFromParcel(Parcel source) {
            CountBean bean = new CountBean();
            bean.mCount = source.readInt();
            return bean;
        }

        public CountBean[] newArray(int size) {
            return new CountBean[size];
        }
        
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mCount);
    }

}
