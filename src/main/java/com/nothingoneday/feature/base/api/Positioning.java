package com.nothingoneday.feature.base.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.log.Logger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Positioning extends Activity implements OnCheckedChangeListener {

	private static final String TAG = Positioning.class.getSimpleName();

	private static final String MAP_API = "http://api.map.baidu.com/geocoder?output=json";

	TextView mGPSTextView, mGoogleTextView, mBaiduTextView;
	Switch mGPSSwitch, mGoogleSwitch, mBaiduSwitch;

	private boolean isRunningLocation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.position);

		mGPSSwitch = (Switch) findViewById(R.id.gps_switch);
		mGPSSwitch.setOnCheckedChangeListener(this);
		mGoogleSwitch = (Switch) findViewById(R.id.google_switch);
		mGoogleSwitch.setOnCheckedChangeListener(this);
		mBaiduSwitch = (Switch) findViewById(R.id.baidu_switch);
		mBaiduSwitch.setOnCheckedChangeListener(this);

	}

	public void onCheckedChanged(CompoundButton button, boolean b) {
		switch (button.getId()) {
		case R.id.gps_switch:
			Logger.getInstance().d(TAG, "gps switch.....");
			if (b && !isRunningLocation) {
				enableGPSSetting();
				doWork();
			}
			break;
		case R.id.google_switch:
			Logger.getInstance().d(TAG, "google switch");
			getLocationByNetwork();
			break;
		case R.id.baidu_switch:
			Logger.getInstance().d(TAG, "baidu switch");
			break;
		default:
			break;
		}

	}

	/**
	 * GPS position GPS定位是通过卫星的通道，在没有网络的情况下也能用 缺点：1.比较耗时 2.用户默认不开启GPS模块
	 * 3.获取位置时间长 4.室内几乎无法使用
	 * 
	 */
	private void enableGPSSetting() {
		Logger.getInstance().d(TAG, "enter to enableGPSSetting()");
		LocationManager alm = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);
		if (alm.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)) {
			Logger.getInstance().d(TAG, "enter to enableGPSSetting() 1");
			Toast.makeText(this, "GPS模块正常", Toast.LENGTH_SHORT).show();
			doWork();
			return;
		} else {
			Logger.getInstance().d(TAG, "enter to enableGPSSetting() 2");
			Toast.makeText(this, "请开启GPS！", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
			startActivityForResult(intent, 0); // 此为设置完成后返回到获取界面
		}

	}

	private void doWork() {

		String msg = "";

		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		Criteria criteria = new Criteria();
		// 获得最好的定位效果
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		criteria.setCostAllowed(false);
		// 使用省电模式
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		// 获得当前的位置提供者
		String provider = locationManager.getBestProvider(criteria, true);
		// 获得当前的位置
		Location location = locationManager.getLastKnownLocation(provider);

		double latitude = location.getLatitude();
		double longitude = location.getLongitude();

		String locationString = "&location=" + latitude + "," + longitude;
		String keyString = "&key=您的key";

		String questURL = new StringBuffer().append(MAP_API)
				.append(locationString).append(keyString).toString();

		new ReadJSONFeedTask().execute(questURL);
	}

	private class ReadJSONFeedTask extends AsyncTask<String, Void, String> {

		StringBuilder stringBuilder = new StringBuilder();

		@Override
		protected String doInBackground(String... urls) {
			return readJSONFeed(urls[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			String strItem;

			try {

				JSONObject jsonObject = new JSONObject(result);
				JSONObject resultObject = jsonObject.getJSONObject("result");
				JSONObject addressComponentObject = resultObject
						.getJSONObject("addressComponent");
				String city = addressComponentObject.getString("city");
				String district = addressComponentObject.getString("district");

				city = "城市：" + city;
				district = "    区：" + district;
				stringBuilder.append(city + district);
				// textView.setText(stringBuilder.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * 请求json数据
	 * 
	 * @param url
	 * @author caizhiming
	 */
	public String readJSONFeed(String url) {
		StringBuilder stringBuilder = new StringBuilder();
		HttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response;
		try {
			response = client.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					stringBuilder.append(line);
				}
			} else {
				Log.e("JSON", "Failed to download file");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	/**
	 * Google positon
	 */
	private void getLocationByNetwork() {
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		LocationListener locationListener = new LocationListener() {

			// 当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
			public void onLocationChanged(Location arg0) {

			}

			// Provider被disable时触发此函数，比如GPS被关闭
			public void onProviderDisabled(String arg0) {

			}

			// Provider被enable时触发此函数，比如GPS被打开
			public void onProviderEnabled(String arg0) {

			}

			// Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
			public void onStatusChanged(String arg0, int arg1, Bundle arg2) {

			}

		};
		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, 1000, 0, locationListener);
		Location location = locationManager
				.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		double latitude = 0;
		double longitude = 0;
		if (location != null) {
			latitude = location.getLatitude(); // 经度
			longitude = location.getLongitude(); // 纬度
		}

		String locationString = "&location=" + latitude + "," + longitude;
		String keyString = "&key=你的key";
		String questURL = new StringBuffer().append(MAP_API)
				.append(locationString).append(keyString).toString();
		Toast.makeText(this, locationString, Toast.LENGTH_LONG).show();
		new ReadJSONFeedTask().execute(questURL);
	}
	
	
	
/*	LocationClient mLocationClient;
	MyLocationListener myListener;

	*//**
	 * Baidu positon
	 *//*
	private void InitLocation() {
		Log.v("LocationActivity", "InitLocation");

		mLocationClient = new LocationClient(this.getApplicationContext()); // 声明LocationClient类
		myListener = new MyLocationListener();
		mLocationClient.registerLocationListener(myListener); // 注册监听函数

		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(tempMode);// 设置定位模式
		option.setCoorType(tempcoor);// 返回的定位结果是百度经纬度，默认值gcj02
		int span = 3000;

		option.setScanSpan(span);// 设置发起定位请求的间隔时间为5000ms
		option.setIsNeedAddress(false);
		mLocationClient.setLocOption(option);
	}

	private void getLocationByBaiduLBS() {

		Log.v("LocationActivity", "getLocationByBaiduLBS");
		mLocationClient.start();
	}

	*//**
	 * baidu lbs location
	 * 
	 * @author caizhiming
	 *//*
	public class MyLocationListener implements BDLocationListener {
		@Override
		public void onReceiveLocation(BDLocation location) {
			Log.v("LocationActivity", "MyLocationListener-onReceiveLocation");
			if (location == null)
				return;
			StringBuffer sb = new StringBuffer(256);
			sb.append("time : ");
			sb.append(location.getTime());
			sb.append("\nerror code : ");
			sb.append(location.getLocType());
			sb.append("\nlatitude : ");
			sb.append(location.getLatitude());
			sb.append("\nlontitude : ");
			sb.append(location.getLongitude());
			sb.append("\nradius : ");
			sb.append(location.getRadius());
			if (location.getLocType() == BDLocation.TypeGpsLocation) {
				sb.append("\nspeed : ");
				sb.append(location.getSpeed());
				sb.append("\nsatellite : ");
				sb.append(location.getSatelliteNumber());
			} else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
				sb.append("\naddr : ");
				sb.append(location.getAddrStr());
			}
			logMsg(sb.toString());

			locationString = "&location=" + location.getLatitude() + ","
					+ location.getLongitude();
			keyString = "&key=你的key";
			questURL = questURL + locationString + keyString;
			new ReadJSONFeedTask().execute(questURL);

		}
	}*/

}
