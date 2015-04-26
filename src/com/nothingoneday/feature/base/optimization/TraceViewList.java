package com.nothingoneday.feature.base.optimization;

import android.view.MenuItem;

import com.nothingoneday.feature.R;
import com.nothingoneday.feature.base.BaseActivity;

public class TraceViewList extends BaseActivity {

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
		return R.xml.traceview_main;
	}

}
