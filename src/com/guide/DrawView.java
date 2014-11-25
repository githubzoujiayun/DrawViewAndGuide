package com.guide;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
public class DrawView extends View {
 private final Paint paint;
 private final Context context; 
 public DrawView(Context context, AttributeSet attrs) {
  super(context, attrs);
  // TODO Auto-generated constructor stub
  this.context = context;
  this.paint = new Paint();
  this.paint.setAntiAlias(true); //消除锯齿 
                this.paint.setStyle(Style.STROKE);  //绘制空心圆或 空心矩形 
              } 
        @Override
 protected void onDraw(Canvas canvas) {
  // TODO Auto-generated method stub
  int center = getWidth()/2;
  int innerCircle = dip2px(context, 50); //内圆半径
  int ringWidth = dip2px(context, 10);   //圆环宽度

  // 第一种方法绘制圆环
  //绘制内圆 
                this.paint.setARGB(127, 138, 43, 226);
  this.paint.setStrokeWidth(30);
  canvas.drawCircle(center, center, center-15, this.paint);   

//                //绘制圆环 
//               this.paint.setARGB(255, 138, 43, 226);
//  this.paint.setStrokeWidth(ringWidth);
//  canvas.drawCircle(center, center, innerCircle + 1 +ringWidth/2, this.paint);   
//
//               //绘制外圆 
//  this.paint.setARGB(255, 138, 43, 226);
//  this.paint.setStrokeWidth(2);
//  canvas.drawCircle(center, center, innerCircle + ringWidth, this.paint);    

                super.onDraw(canvas);

 }
 /* 根据手机的分辨率从 dp 的单位 转成为 px(像素) */  
 public static int dip2px(Context context, float dpValue) {  
  final float scale = context.getResources().getDisplayMetrics().density;  
  return (int) (dpValue * scale + 0.5f);  
 }  
}