/*
 * Copyright (C) 2006 The Android Open Source Project Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.nothingoneday.feature.base.algorithms;

import java.util.Random;

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.BaseConstant;
import com.nothingoneday.feature.base.log.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SortActivity extends Activity {

    private static final String TAG = SortActivity.class.getSimpleName();
    
    private final static int SORT_TYPE_BUBBLE = 0;
    private final static int SORT_TYPE_FAST = 1;
    private final static int SORT_TYPE_PICK = 2;
    private final static int SORT_TYPE_INSERT = 3;
    private final static int SORT_TYPE_HEAP = 4;
    private final static int SORT_TYPE_SHELL = 5;
    private final static int SORT_TYPE_MERGE = 6;

    private int mSortType;
    private final static int ARRAY_SIZE = 10;
    TextView mTitleTextView, mProcessTextView, mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getBundleExtra(BaseConstant.BUNDLE_TAG_DATA);
        mSortType = bundle.getInt(BaseConstant.TAB_BUNDLE_TYPE_INT);
        setContentView(R.layout.sort);
        mTitleTextView = (TextView)findViewById(R.id.title);
        mProcessTextView = (TextView)findViewById(R.id.process);
        mResultTextView = (TextView)findViewById(R.id.result);
        initViewBySortType(mSortType);
        Logger.getInstance().clearCache();
    }

    private int[] mArray;
    private int[] createIntArray(){
        int[] array = new int[ARRAY_SIZE];
        Random r = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(100) + 1;
        }
        return array;
    }

    private String convertArrayToString(int[] array){
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != (array.length -1)) 
                sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }

    private String mSortTypeString;
    private String mSortListString;
    private void initViewBySortType(int type){
        mArray = createIntArray();
        mSortListString = convertArrayToString(mArray);
        switch (type) {
            case SORT_TYPE_BUBBLE:
                mSortTypeString = getString(R.string.sort_activity_title_sort_type_bubble);
                bubbleSort(mArray);
                break;
            case SORT_TYPE_FAST:
                mSortTypeString = getString(R.string.sort_activity_title_sort_type_fast);
                quickSort(mArray, 0, mArray.length - 1);
                break;
            case SORT_TYPE_PICK:
                mSortTypeString = getString(R.string.sort_activity_title_sort_type_pick);
                pickSort(mArray);
                break;
            case SORT_TYPE_INSERT:
                mSortTypeString = getString(R.string.sort_activity_title_sort_type_insert);
                insertionSort(mArray);
                break;
            case SORT_TYPE_HEAP:
                mSortTypeString = getString(R.string.sort_activity_title_sort_type_heap);
                heapSort(mArray, mArray.length);
                break;
            case SORT_TYPE_SHELL:
                mSortTypeString = getString(R.string.sort_activity_title_sort_type_shell);
                shellSort(mArray);
                break;
            case SORT_TYPE_MERGE:
                mSortTypeString = getString(R.string.sort_activity_title_sort_type_merge);
                mergeSort(mArray, mArray.length);
                break;
            default:
                break;
        }
        mTitleTextView.setText(String.format("%1s\n%2s", mSortTypeString, mSortListString));
        mProcessTextView.setText(Logger.getInstance().getCache());
        mResultTextView.setText(String.format("%1s\n%2s", "Result: ", convertArrayToString(mArray)));
    }

    /*
     * 冒泡排序
     */
    private void bubbleSort(int[] array){
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            Logger.getInstance().appendCache("process: " + i + ": " + convertArrayToString(array) + "\n");
        }
    }
    
    /**
     * 选择排序
     */
    private void pickSort(int[] array){
        int index;
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }
            if (index != i) {
                temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
            Logger.getInstance().appendCache("process: " + (i + 1) + ": " + convertArrayToString(array) + "\n");
        }
    }
    
    /*
     * 插入排序
     */
    private void insertionSort(int[] array){
        int i,j,t,h;
        for (i = 1; i < array.length; i++) {
            t = array[i];
            j = i - 1;
            while (j >= 0 && t < array[j]){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = t;
            Logger.getInstance().appendCache("process: " + (i + 1) + ": " + convertArrayToString(array) + "\n");
        }
    }
    
    /**
     * shell排序
     */
    private void shellSort(int[] array){
        int i,j,h;
        int r,temp;
        int x = 0;
        for (r = array.length / 2; r >= 1; r /= 2) {
            for (i = r; i < array.length; i++) {
                temp = array[i];
                j = i - r;
                while (j > 0 && temp < array[j]) {
                    array[j + r] = array[j];
                    j -= r;
                }
                array[j + r] = temp;
            }
            x++;
            Logger.getInstance().appendCache("process: " + (i + 1) + ": " + convertArrayToString(array) + "\n");
            
        }
    }
    
    private void quickSort(int[] array, int left, int right){
        int f, t;
        int rtemp, ltemp;
        ltemp = left;
        rtemp = right;
        f = array[(left + right) / 2];
        while (ltemp < rtemp){
            while (array[ltemp] < f) {
                ++ltemp;
            }
            while (array[rtemp] > f) {
                --rtemp;
            }
            if (ltemp <= rtemp) {
                t = array[ltemp];
                array[ltemp] = array[rtemp];
                array[rtemp] = t;
                --rtemp;
                ++ltemp;
            }
        }
        if (ltemp == rtemp) {
            ltemp++;
        }
        if (left < rtemp) {
            quickSort(array, left, ltemp - 1);
        }
        if (ltemp < right) {
            quickSort(array, rtemp + 1, right);
        }
    }
    
    /**
     * 堆排序
     */
    private void heapSort(int[] a, int n){
        int i,j,h,k;
        int t;
        
        //将a[0, n -1]建成大根堆
        for (i = n / 2; i >= 0; i--) {
            //第i个结点有右子树
            while (2 * i + 1 < n){
                j = 2 * i + 1;
                if ((j + 1) < n) {
                    
                    //右左子树小于右子树，则需要比较右子树， 序号增加1，指向右子树
                    if (a[j] < a[j + 1]){
                        j++;
                    }
                }
                
                //比较i与j为序号的数据
                if (a[i] < a[j]) {
                    //交换数据
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                    //堆被破坏，需要重新调整
                    i = j;
                } else {
                    //比较左右子结点均大则堆未破坏，不再需要调整
                    break;
                }
            }
        }
        
        Log.d(TAG, "原数据构成的堆：");
        //输出构成堆
        for (h = 0; h < n; h++){
            Log.d(TAG, "" + a[h]);
        }
        
        for (i = n -1; i > 0; i--) {
            //与第i个记录交换
            t = a[0];
            a[0] = a[i];
            a[i] = t;
            k = 0;
            
            //第i个结点有右子树
            while (2 * k + 1 < i) {
                j = 2 * k + 1;
                if ((j + 1) < i) {
                    //右左子树小于右子树，则需要比较右子树
                    if (a[j] < a[j + 1]) {
                        //需要增加1，指向右子树
                        j++;
                    }
                }
              //比较i与j为序号的数据
                if (a[k] < a[j]) {
                    //交换数据
                    t = a[k];
                    a[k] = a[j];
                    a[j] = t;
                    //堆被破坏，需要重新调整
                    k=j;
                } else {
                    //比较左右子结点均大则堆未破坏，不再需要调整
                    break;
                }
            }
        }
    }
    
    private void mergeOne(int[] a, int[] b, int n, int len){
        int i,j,k,s,e;
        s = 0;
        while (s + len < n) {
            e = s + 2 * len - 1; //最后一段可能少于len个结点
            if (e >= n) {
                e = n -1;
            }
            //相邻有序段合并
            k = s;
            i = s;
            j = s + len;
            while (i < s +len && j <= e) { //如果两个有序表都未结束，循环比较
                if (a[i] <= a[j]) { //如果较小的元素复制到数组b中
                    b[k++] = a[i++];
                } else {
                    b[k++] = a[j++];
                }
            }
            while (i < s+len) { //未合并的部分复制到数组b中
                b[k++] = a[i++];
            }
            while (j <= e) {
               b[k++] = a[j++]; //未合并的部分复制到数组b中
            }
            s = e + 1; //下一对有序段中左段的开始下标
        }
        
        if (s < n) { //将剩余的一个有序段从数组A中复制到数组b中
           for (; s < n; s++){
               b[s] = a[s];
           }
            
        }
    }
    
    /*
     * 合并排序
     */
    private void mergeSort(int a[], int n){
        int h,count,len,f;
        count = 0;  //排序步骤
        len = 1;    //有序序列的长度
        f = 0;   //变量f作为标志
        int[] p = new int[n];
        while (len < n) {
            if (f == 1) {  //交替在A和P之间合并
                mergeOne(p, a, n, len); //p合并到a
            } else {
                mergeOne(a, p, n, len); //a合并到p
            }
            len = len * 2; //增加有序序列长度
            f = 1 - f; //使f值在0和1之间切换
            count++;
            Logger.getInstance().appendCache("process: " + (n + 1) + ": " + convertArrayToString(a) + "\n");
        }
        if (f == 1) { //如果进行了排序
            for (h = 0; h < n; h++) {
                a[h] = p[h];  //将内存p中的数据复制回数组a
            }
        }
    }

}
