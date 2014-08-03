package com.nothingoneday.feature.base.api;

import java.io.ByteArrayOutputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class ImageConversion extends Activity {
	
	//Byte[]<--->Bitmap<--->Drawable
	private static final int BITMAP_TO_BYTE = 1;
	private static final int BYTE_TO_BITMAP = 2;
	private static final int BITMAP_TO_DRAWABLE = 3;
	private static final int DRAWABLE_TO_BITMAP = 4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	/**
	 * bitmap to byte[]
	 */
	private byte[] bitmapToByte(Bitmap bitmap){
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
		return baos.toByteArray();
		
	}
	
	/**
	 * byte[] to bitmap
	 */
	private Bitmap byteToBitmap(byte[] buffer){
		
		return BitmapFactory.decodeByteArray(buffer, 0, buffer.length);
		
	}
	
	/**
	 * bitmap to drawable
	 */
	private Drawable bitmapToDrawable(Bitmap bitmap){
		return new BitmapDrawable(bitmap);
	}
	
	/**
	 * bitmapdrawable to bitmap
	 */
	private Bitmap drawableToBitmap(BitmapDrawable drawable){
		return drawable.getBitmap();
	}
	

}
