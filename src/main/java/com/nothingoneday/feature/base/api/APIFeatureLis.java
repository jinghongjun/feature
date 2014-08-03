package com.nothingoneday.feature.base.api;

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.BaseActivity;

import android.view.MenuItem;

public class APIFeatureLis extends BaseActivity {

	@Override
	public int getMenuRes() {
		return 0;
	}

	@Override
	public boolean handleOptionsItemSelectedBySubclasses(MenuItem item) {
		return false;
	}

	@Override
	public int getCreateItemRes() {
		return R.xml.api_main;
	}

}
