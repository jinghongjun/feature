package com.nothingoneday.feature.base.api;

import java.util.Random;

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.log.Logger;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class CanvasList extends Activity {
	
	private static final String TAG = CanvasList.class.getSimpleName();
	
	public static enum BITMAP{
		CIRCLE, //绘制圆
		ARC, //绘制弧
		ARC_1,
		COLOR, //绘制颜色
		LINE, //绘制线
		OVAL, //绘制椭圆
	    TEXT, //绘制文本
	    RECT, //绘制矩形
	    ROUND_RECT, //绘制圆角矩形
	    PATH_LINE, //绘制路径直线
	    PATH_TEXT, //绘制路径文字
	    PATH_COMBINATION, //绘制复杂图像
	    IMAGE,
	    FILLET_DEAL, //图像圆角处理
	    GRAY_HANDLE, //图像灰白处理
	    BACK_WHITE_PROCESSING, //图像黑白处理
	    MIRRORING, //图像镜像处理
	    OLD_DEAL, //图像加旧处理
	    DISTORING_MIRROR_HANDLE, //图像哈哈镜处理
	    MAGNIFYING_GLASS_PROCESSING, //图像放大处理
	    RELIEF_DEAL, //图像浮雕处理
	    FILM_PROCESSING, //图像底片处理
	    PAINTING_PROCESS, //图像油画处理
	    OBFUSCATION, //图像模糊处理
	};
	
	ListView mListView;
	ImageAdatper mImageAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.canvas_list);
		
		mListView = (ListView)findViewById(R.id.images);
		mImageAdapter = new ImageAdatper();
		mListView.setAdapter(mImageAdapter);
		
	}
	
	private Bitmap createBitmap(BITMAP type){
		Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.BLUE);
		switch (type){
		case CIRCLE:
			canvas.drawCircle(50, 50, 30, paint);
			break;
		case ARC:
			canvas.drawArc(new RectF(0, 0, 50, 50), 
					0, //开始角度
					90, //扫过角度
					false,//是否使用中心
					paint);
			break;
		case ARC_1:
			canvas.drawArc(new RectF(0, 0, 50, 50), 
					0, //开始角度
					90, //扫过角度
					true,//是否使用中心
					paint);
			break;
		case COLOR:
			canvas.drawColor(Color.BLUE);
			break;
		case LINE:
			canvas.drawLine(0, 0, 50, 50, paint);
			break;
		case OVAL:
			canvas.drawOval(new RectF(0, 0, 100, 100), paint);
			break;
		case TEXT:
			canvas.drawPosText("android", new float[]{
					10,10,
					20,20,
					30,30,
					40,40,
					50,50,
					60,60,
					70,70,
					80,80
			}, paint);
			break;
		case RECT:
			canvas.drawRect(new RectF(0,0, 50, 50), paint);
			break;
		case ROUND_RECT:
			canvas.drawRoundRect(new RectF(0,0, 50, 50), 
					10, //x轴的半径
					10, //y轴的半径
					paint);
			break;
		case PATH_LINE:
		    Path path1 = new Path(); //定义一条路径
		    path1.moveTo(10, 10); //移动坐标到10，10
		    path1.lineTo(20, 30);
		    path1.lineTo(80, 70);
		    path1.lineTo(10, 10);
		    canvas.drawPath(path1, paint);
			break;
		case PATH_TEXT:
			Path path2 = new Path();
		    path2.moveTo(10, 10); //移动坐标到10，10
		    path2.lineTo(20, 30);
		    path2.lineTo(80, 70);
		    path2.lineTo(10, 10);
		    canvas.drawTextOnPath("android论坛", path2, 10, 10, paint);
			break;
		case PATH_COMBINATION:
			canvas.translate(canvas.getWidth()/2, 100); //将位置移动画纸的坐标点：150，150
			canvas.drawCircle(0, 0, 100, paint); //画圆
			canvas.save();
			//使用path绘制路径文字   
		    canvas.save();   
		    canvas.translate(-75, -75);   
		    Path path = new Path();   
		    path.addArc(new RectF(0,0,150,150), -180, 180);   
		    Paint citePaint = new Paint(paint);   
		    citePaint.setTextSize(14);   
		    citePaint.setStrokeWidth(1);   
		    canvas.drawTextOnPath("http://www.android777.com", path, 28, 0, citePaint);   
		    canvas.restore();   
		          
		    Paint tmpPaint = new Paint(paint); //小刻度画笔对象   
		    tmpPaint.setStrokeWidth(1);  
		    float  y=100;   
		    int count = 60; //总刻度数   
		          
		    for(int i=0 ; i <count ; i++){   
		        if(i%5 == 0){   
		            canvas.drawLine(0f, y, 0, y+12f, paint);   
		            canvas.drawText(String.valueOf(i/5+1), -4f, y+25f, tmpPaint);   
		          
		        }else{   
		            canvas.drawLine(0f, y, 0f, y +5f, tmpPaint);   
		        }   
		        canvas.rotate(360/count,0f,0f); //旋转画纸   
		    }   
		          
		    //绘制指针   
		    tmpPaint.setColor(Color.GRAY);   
		    tmpPaint.setStrokeWidth(4);   
		    canvas.drawCircle(0, 0, 7, tmpPaint);   
		    tmpPaint.setStyle(Style.FILL);   
		    tmpPaint.setColor(Color.YELLOW);   
		    canvas.drawCircle(0, 0, 5, tmpPaint);   
		    canvas.drawLine(0, 10, 0, -65, paint); 
			break;
			
		case IMAGE:
		    bitmap = getBitmapFromDrawable();
			break;
		case FILLET_DEAL:
			bitmap = getRoundedCornerBitmap(getBitmapFromDrawable(), 20);
			break;
		case GRAY_HANDLE:
			bitmap = toGrayscale(getBitmapFromDrawable());
			break;
		case BACK_WHITE_PROCESSING:
			bitmap = toHeibai(getBitmapFromDrawable());
			break;
		case MIRRORING:
			bitmap = createReflectionImageWithOrigin(getBitmapFromDrawable());
			break;
		case OLD_DEAL:
			bitmap = testBitmap(getBitmapFromDrawable());
			break;
		case DISTORING_MIRROR_HANDLE:
			break;
		case MAGNIFYING_GLASS_PROCESSING:
			break;
		case RELIEF_DEAL:
			bitmap = toFuDiao(getBitmapFromDrawable());
			break;
		case FILM_PROCESSING:
			break;
		case PAINTING_PROCESS:
			bitmap = toYouHua(getBitmapFromDrawable());
			break;
		case OBFUSCATION:
			bitmap = toMohu(getBitmapFromDrawable(), 5);
			break;
		default:
			break;
		}
		
		return bitmap;
	}
	
	class ImageAdatper extends BaseAdapter {

		public int getCount() {
			return BITMAP.values().length;
		}

		public Object getItem(int arg0) {
			return arg0;
		}

		public long getItemId(int arg0) {
			return arg0;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.canvas_item, null);
			}
			ImageView image = (ImageView)convertView.findViewById(R.id.image);
			
			Bitmap bitmap = createBitmap(BITMAP.values()[position]);
			Logger.getInstance().d(TAG, "bitmap: " + bitmap);
			if (bitmap != null) 
				image.setImageBitmap(bitmap);
			
			if (bitmap.isRecycled()) 
				bitmap.recycle();
			return convertView;
		}
		
	}
	
	
	private Bitmap getBitmapFromDrawable(){
		BitmapDrawable drawable = (BitmapDrawable)getResources().getDrawable(R.drawable.panda);
		return drawable.getBitmap();
	}
	
	/**
	 * 图像圆角处理
	 */
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx) {

		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);

		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		final RectF rectF = new RectF(rect);

		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, rect, rect, paint);

		return output;
	}
	
	
	/**
	 * 图像黑白处理
	 */
	public static Bitmap toHeibai(Bitmap mBitmap) {
		int mBitmapWidth = 0;
		int mBitmapHeight = 0;

		mBitmapWidth = mBitmap.getWidth();
		mBitmapHeight = mBitmap.getHeight();
		Bitmap bmpReturn = Bitmap.createBitmap(mBitmapWidth, mBitmapHeight,
				Bitmap.Config.ARGB_8888);
		int iPixel = 0;
		for (int i = 0; i < mBitmapWidth; i++) {
			for (int j = 0; j < mBitmapHeight; j++) {
				int curr_color = mBitmap.getPixel(i, j);

				int avg = (Color.red(curr_color) + Color.green(curr_color) + Color
						.blue(curr_color)) / 3;
				if (avg >= 100) {
					iPixel = 255;
				} else {
					iPixel = 0;
				}
				int modif_color = Color.argb(255, iPixel, iPixel, iPixel);

				bmpReturn.setPixel(i, j, modif_color);
			}
		}
		return bmpReturn;
	}
	
	/*
	 * 图像灰白处理
	 */
	public static Bitmap toGrayscale(Bitmap bmpOriginal) {
		int width, height;
		height = bmpOriginal.getHeight();
		width = bmpOriginal.getWidth();

		Bitmap bmpGrayscale = Bitmap.createBitmap(width, height,
				Bitmap.Config.RGB_565);
		Canvas c = new Canvas(bmpGrayscale);
		Paint paint = new Paint();
		ColorMatrix cm = new ColorMatrix();
		cm.setSaturation(0);
		ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
		paint.setColorFilter(f);
		c.drawBitmap(bmpOriginal, 0, 0, paint);
		return bmpGrayscale;
	}
	
	/**
	 * 图像镜像处理
	 */
	public static Bitmap createReflectionImageWithOrigin(Bitmap bitmap) {
		final int reflectionGap = 4;
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();

		Matrix matrix = new Matrix();
		matrix.preScale(1, -1);

		Bitmap reflectionImage = Bitmap.createBitmap(bitmap, 0, height / 2,
				width, height / 2, matrix, false);

		Bitmap bitmapWithReflection = Bitmap.createBitmap(width,
				(height + height / 2), Config.ARGB_8888);

		Canvas canvas = new Canvas(bitmapWithReflection);
		canvas.drawBitmap(bitmap, 0, 0, null);
		Paint deafalutPaint = new Paint();
		canvas.drawRect(0, height, width, height + reflectionGap, deafalutPaint);

		canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);

		Paint paint = new Paint();
		LinearGradient shader = new LinearGradient(0, bitmap.getHeight(), 0,
				bitmapWithReflection.getHeight() + reflectionGap, 0x70ffffff,
				0x00ffffff, TileMode.CLAMP);
		paint.setShader(shader);
		// Set the Transfer mode to be porter duff and destination in
		paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
		// Draw a rectangle using the paint with our linear gradient
		canvas.drawRect(0, height, width, bitmapWithReflection.getHeight()
				+ reflectionGap, paint);

		return bitmapWithReflection;
	}
	
	/**
	 * 图像加旧处理
	 */
	public static Bitmap testBitmap(Bitmap bitmap) {
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
				bitmap.getHeight(), Config.RGB_565);

		Canvas canvas = new Canvas(output);

		Paint paint = new Paint();
		ColorMatrix cm = new ColorMatrix();
		float[] array = { 1, 0, 0, 0, 50, 0, 1, 0, 0, 50, 0, 0, 1, 0, 0, 0, 0,
				0, 1, 0 };
		cm.set(array);
		paint.setColorFilter(new ColorMatrixColorFilter(cm));

		canvas.drawBitmap(bitmap, 0, 0, paint);
		return output;
	}
	
	/**
	 * 图像浮雕处理
	 */
	public static Bitmap toFuDiao(Bitmap mBitmap) {

		int mBitmapWidth = 0;
		int mBitmapHeight = 0;

		mBitmapWidth = mBitmap.getWidth();
		mBitmapHeight = mBitmap.getHeight();
		Bitmap bmpReturn = Bitmap.createBitmap(mBitmapWidth, mBitmapHeight,
				Bitmap.Config.RGB_565);
		int preColor = 0;
		int prepreColor = 0;
		preColor = mBitmap.getPixel(0, 0);

		for (int i = 0; i < mBitmapWidth; i++) {
			for (int j = 0; j < mBitmapHeight; j++) {
				int curr_color = mBitmap.getPixel(i, j);
				int r = Color.red(curr_color) - Color.red(prepreColor) + 127;
				int g = Color.green(curr_color) - Color.red(prepreColor) + 127;
				int b = Color.green(curr_color) - Color.blue(prepreColor) + 127;
				int a = Color.alpha(curr_color);
				int modif_color = Color.argb(a, r, g, b);
				bmpReturn.setPixel(i, j, modif_color);
				prepreColor = preColor;
				preColor = curr_color;
			}
		}

		Canvas c = new Canvas(bmpReturn);
		Paint paint = new Paint();
		ColorMatrix cm = new ColorMatrix();
		cm.setSaturation(0);
		ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
		paint.setColorFilter(f);
		c.drawBitmap(bmpReturn, 0, 0, paint);

		return bmpReturn;
	}
	
	
	/**
	 * 图像哈哈镜处理
	 */
	/*
	jintArray Java_com_spore_meitu_jni_ImageUtilEngine_toHahajing
	  (JNIEnv* env,jobject thiz, jintArray buf, jint width, jint height,jint centerX, jint centerY, jint radius, jfloat multiple)
	{
	    jint * cbuf;
	        cbuf = (*env)->GetIntArrayElements(env, buf, 0);
	 
	        int newSize = width * height;
	        jint rbuf[newSize]; 
	 
	        float xishu = multiple;
	        int real_radius = (int)(radius / xishu);
	 
	        int i = 0, j = 0;
	        for (i = 0; i < width; i++)
	        {
	            for (j = 0; j < height; j++)
	            {
	                int curr_color = cbuf[j * width + i];
	 
	                int pixR = red(curr_color);
	                int pixG = green(curr_color);
	                int pixB = blue(curr_color);
	                int pixA = alpha(curr_color);
	 
	                int newR = pixR;
	                int newG = pixG;
	                int newB = pixB;
	                int newA = pixA;
	 
	                int distance = (int) ((centerX - i) * (centerX - i) + (centerY - j) * (centerY - j));
	                if (distance < radius * radius)
	                {
	                     
	                    int src_x = (int) ((float) (i - centerX) / xishu);
	                    int src_y = (int) ((float) (j - centerY) / xishu);
	                    src_x = (int)(src_x * (sqrt(distance) / real_radius));
	                    src_y = (int)(src_y * (sqrt(distance) / real_radius));
	                    src_x = src_x + centerX;
	                    src_y = src_y + centerY;
	 
	                    int src_color = cbuf[src_y * width + src_x];
	                    newR = red(src_color);
	                    newG = green(src_color);
	                    newB = blue(src_color);
	                    newA = alpha(src_color);
	                }
	 
	                newR = min(255, max(0, newR));
	                newG = min(255, max(0, newG));
	                newB = min(255, max(0, newB));
	                newA = min(255, max(0, newA));
	 
	                int modif_color = ARGB(newA, newR, newG, newB);
	                rbuf[j * width + i] = modif_color;
	            }
	        }
	 
	        jintArray result = (*env)->NewIntArray(env, newSize);
	        (*env)->SetIntArrayRegion(env, result, 0, newSize, rbuf);
	        (*env)->ReleaseIntArrayElements(env, buf, cbuf, 0);
	        return result;
	}
	*/
	
	/**
	 * 图像放大镜处理
	 * 
	 */
	/*
	jintArray Java_com_spore_meitu_jni_ImageUtilEngine_toFangdajing
	  (JNIEnv* env,jobject thiz, jintArray buf, jint width, jint height,jint centerX, jint centerY, jint radius, jfloat multiple)
	{
	    jint * cbuf;
	    cbuf = (*env)->GetIntArrayElements(env, buf, 0);
	 
	    int newSize = width * height;
	    jint rbuf[newSize]; // 鏂板浘鍍忓儚绱犲?
	 
	    float xishu = multiple;
	    int real_radius = (int)(radius / xishu);
	 
	    int i = 0, j = 0;
	    for (i = 0; i < width; i++)
	    {
	        for (j = 0; j < height; j++)
	        {
	            int curr_color = cbuf[j * width + i];
	 
	            int pixR = red(curr_color);
	            int pixG = green(curr_color);
	            int pixB = blue(curr_color);
	            int pixA = alpha(curr_color);
	 
	            int newR = pixR;
	            int newG = pixG;
	            int newB = pixB;
	            int newA = pixA;
	 
	            int distance = (int) ((centerX - i) * (centerX - i) + (centerY - j) * (centerY - j));
	            if (distance < radius * radius)
	            {
	                // 鍥惧儚鏀惧ぇ鏁堟灉
	                int src_x = (int)((float)(i - centerX) / xishu + centerX);
	                int src_y = (int)((float)(j - centerY) / xishu + centerY);
	 
	                int src_color = cbuf[src_y * width + src_x];
	                newR = red(src_color);
	                newG = green(src_color);
	                newB = blue(src_color);
	                newA = alpha(src_color);
	            }
	 
	            newR = min(255, max(0, newR));
	            newG = min(255, max(0, newG));
	            newB = min(255, max(0, newB));
	            newA = min(255, max(0, newA));
	 
	            int modif_color = ARGB(newA, newR, newG, newB);
	            rbuf[j * width + i] = modif_color;
	        }
	    }
	 
	    jintArray result = (*env)->NewIntArray(env, newSize);
	    (*env)->SetIntArrayRegion(env, result, 0, newSize, rbuf);
	    (*env)->ReleaseIntArrayElements(env, buf, cbuf, 0);
	    return result;
	}
	*/
	
	/**
	 * 图像底片处理
	 */
	/*
	jintArray Java_com_spore_meitu_jni_ImageUtilEngine_toDipian
	  (JNIEnv* env,jobject thiz, jintArray buf, jint width, jint height)
	{
	    jint * cbuf;
	    cbuf = (*env)->GetIntArrayElements(env, buf, 0);
	    LOGE(Bitmap Buffer %d %d,cbuf[0],cbuf[1]);
	 
	    int newSize = width * height;
	    jint rbuf[newSize];
	 
	    int count = 0;
	    int preColor = 0;
	    int prepreColor = 0;
	    int color = 0;
	    preColor = cbuf[0];
	 
	    int i = 0;
	    int j = 0;
	    int iPixel = 0;
	    for (i = 0; i < width; i++) {
	        for (j = 0; j < height; j++) {
	            int curr_color = cbuf[j * width + i];
	 
	            int r = 255 - red(curr_color);
	            int g = 255 - green(curr_color);
	            int b = 255 - blue(curr_color);
	            int a = alpha(curr_color);
	            int modif_color = ARGB(a, r, g, b);
	            rbuf[j * width + i] = modif_color;
	        }
	    }
	    jintArray result = (*env)->NewIntArray(env, newSize); 
	    (*env)->SetIntArrayRegion(env, result, 0, newSize, rbuf); 
	    (*env)->ReleaseIntArrayElements(env, buf, cbuf, 0); 
	    return result;
	}
	*/
	
	
	/**
	 * 图像油画处理
	 */
	public static Bitmap toYouHua(Bitmap bmpSource) {
		Bitmap bmpReturn = Bitmap.createBitmap(bmpSource.getWidth(),
				bmpSource.getHeight(), Bitmap.Config.RGB_565);
		int color = 0;
		int Radio = 0;
		int width = bmpSource.getWidth();
		int height = bmpSource.getHeight();

		Random rnd = new Random();
		int iModel = 10;
		int i = width - iModel;
		while (i > 1) {
			int j = height - iModel;
			while (j > 1) {
				int iPos = rnd.nextInt(100000) % iModel;
				color = bmpSource.getPixel(i + iPos, j + iPos);
				bmpReturn.setPixel(i, j, color);
				j = j - 1;
			}
			i = i - 1;
		}
		return bmpReturn;
	}
	
	/**
	 * 图像模糊处理
	 */
	public static Bitmap toMohu(Bitmap bmpSource, int Blur) {
		int mode = 5;
		Bitmap bmpReturn = Bitmap.createBitmap(bmpSource.getWidth(),
				bmpSource.getHeight(), Bitmap.Config.ARGB_8888);
		int pixels[] = new int[bmpSource.getWidth() * bmpSource.getHeight()];
		int pixelsRawSource[] = new int[bmpSource.getWidth()
				* bmpSource.getHeight() * 3];
		int pixelsRawNew[] = new int[bmpSource.getWidth()
				* bmpSource.getHeight() * 3];

		bmpSource.getPixels(pixels, 0, bmpSource.getWidth(), 0, 0,
				bmpSource.getWidth(), bmpSource.getHeight());

		for (int k = 1; k <= Blur; k++) {

			for (int i = 0; i < pixels.length; i++) {
				pixelsRawSource[i * 3 + 0] = Color.red(pixels[i]);
				pixelsRawSource[i * 3 + 1] = Color.green(pixels[i]);
				pixelsRawSource[i * 3 + 2] = Color.blue(pixels[i]);
			}

			int CurrentPixel = bmpSource.getWidth() * 3 + 3;

			for (int i = 0; i < bmpSource.getHeight() - 3; i++) {
				for (int j = 0; j < bmpSource.getWidth() * 3; j++) {
					CurrentPixel += 1;
					int sumColor = 0;
					sumColor = pixelsRawSource[CurrentPixel
							- bmpSource.getWidth() * 3];
					sumColor = sumColor + pixelsRawSource[CurrentPixel - 3];
					sumColor = sumColor + pixelsRawSource[CurrentPixel + 3];
					sumColor = sumColor
							+ pixelsRawSource[CurrentPixel
									+ bmpSource.getWidth() * 3];
					pixelsRawNew[CurrentPixel] = Math.round(sumColor / 4);
				}
			}

			for (int i = 0; i < pixels.length; i++) {
				pixels[i] = Color.rgb(pixelsRawNew[i * 3 + 0],
						pixelsRawNew[i * 3 + 1], pixelsRawNew[i * 3 + 2]);
			}
		}

		bmpReturn.setPixels(pixels, 0, bmpSource.getWidth(), 0, 0,
				bmpSource.getWidth(), bmpSource.getHeight());
		return bmpReturn;
	}

}
