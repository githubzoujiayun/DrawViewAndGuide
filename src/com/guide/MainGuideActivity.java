package com.guide;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainGuideActivity extends Activity{
	private boolean first;
	private SharedPreferences spn;
	private Intent intent;
	public static final String PREFS_NAME ="prefs";
	public static final String FIRST_START = "first";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		firstStart();
	}
	//判断程序是不是第一次启动
	private void firstStart(){
    	intent = new Intent();
    	spn = getSharedPreferences(PREFS_NAME, 0);
    	first = spn.getBoolean(FIRST_START, true);
    	SharedPreferences.Editor editor = spn.edit();
//    	if(first){
    		intent.setClass(MainGuideActivity.this, GuideActivity.class);
    		startActivity(intent);
    		editor.putBoolean(FIRST_START, false);
    		editor.commit();
    		finish();
//    	}else{
//    		intent.setClass(MainGuideActivity.this, TestActivity.class);
//    		startActivity(intent);
//    		finish();
//    	}
    }
}
