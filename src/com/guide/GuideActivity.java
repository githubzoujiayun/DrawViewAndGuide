package com.guide;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class GuideActivity extends Activity implements OnPageChangeListener, OnClickListener {
	private ViewPager viewPager;
	private GuideAdapter adapter;
	private List<View> views;
	private Button button;
	private View viewpager_view1, viewpager_view2, viewpager_view3;

	//底部小点
	private ImageView[] dots;
	//记住当前位置
	private int current;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.guide);
        views = new ArrayList<View>();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
        		                                                         LinearLayout.LayoutParams.WRAP_CONTENT);
		LayoutInflater mInflater = getLayoutInflater();
		viewpager_view1 = mInflater.inflate(R.layout.first_viewpager1, null);
		viewpager_view2 = mInflater.inflate(R.layout.first_viewpager2, null);
		viewpager_view3 = mInflater.inflate(R.layout.first_viewpager3, null);
		 
		views.add(viewpager_view1);
		views.add(viewpager_view2);
		views.add(viewpager_view3);
        
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        Log.i("life", ""+viewPager);
        adapter = new GuideAdapter(views);
        viewPager.setAdapter(adapter);
        //绑定回调
        viewPager.setOnPageChangeListener(this);
        init();
    }
    private void init(){
    	button = (Button) viewpager_view3.findViewById(R.id.button11);
    	button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Intent intent =new Intent(GuideActivity.this , TestActivity.class);
//	    		startActivity(intent);
//	    		finish();
				Toast.makeText(getApplicationContext(), "11", 0).show();
			}
		});
    	LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
    	dots = new ImageView[views.size()];
    	for(int i = 0 ;i<views.size(); i++){
    		dots[i] =(ImageView) ll.getChildAt(i);//索引
    		dots[i].setEnabled(true);  //都设置灰色
    		dots[i].setOnClickListener(this);
    		dots[i].setTag(i); //设置标签
    	}
    	current = 0;
    	dots[current].setEnabled(false);//设置白色，选中状态
    }
    //设置当前的引导页
    private void setViews(int position){
    	if(position < 0 || position >= views.size()){
    		return;
    	}
    	viewPager.setCurrentItem(position);
    }
    //设置当前小点
    private void setDots(int position){
    	if(position < 0 || position >views.size()-1 || current == position){
    		return;
    	}
    	dots[position].setEnabled(false);
    	dots[current].setEnabled(true);
    	current = position;
    }
    //当页面滑动状态改变调用
	@Override
	public void onPageScrollStateChanged(int arg0) {
		
		
	}
	//当页面滑动的时候调用
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}
	//当页面选中的时候调用
	@Override
	public void onPageSelected(int arg0) {
		setDots(arg0);
		
	}
	@Override
	public void onClick(View v) {
		int position = (Integer) v.getTag();
		setViews(position);
		setDots(position);
	}
}






