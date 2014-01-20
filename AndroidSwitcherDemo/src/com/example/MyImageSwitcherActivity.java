package com.example;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;
import android.app.Activity;
import android.view.ViewGroup.LayoutParams;

public class MyImageSwitcherActivity extends Activity {

	private ImageSwitcher imageSwitcher;
	private Button b;

	int myContent[]={R.drawable.android_pic1,R.drawable.android_pic2,R.drawable.android_pic3,R.drawable.android_pic4};

	//used to keep track of image index
	int currentIndex=-1; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_switcher);

		imageSwitcher = (ImageSwitcher)findViewById(R.id.imageSwitcher);
		b= (Button)findViewById(R.id.btn1);

		//set ViewFactory of imageSwitcher to dynamically create imageView
		imageSwitcher.setFactory(new ViewFactory() {

			public View makeView() {
				// TODO Auto-generated method stub
				// create new imageView 
				ImageView myImage = new ImageView(MyImageSwitcherActivity.this);
				myImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
				LayoutParams params = new ImageSwitcher.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
				myImage.setLayoutParams(params);
				return myImage;
			}
		});

		// Declare the in and out animations
		Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
		Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);

		// set the animation of imageSwitcher
		imageSwitcher.setInAnimation(in);
		imageSwitcher.setOutAnimation(out);

		//button click
		b.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (currentIndex == myContent.length - 1) {
					currentIndex = 0;
					imageSwitcher.setImageResource(myContent[currentIndex]);
				} else {
					imageSwitcher.setImageResource(myContent[++currentIndex]);
				}
			}
		});

	}


}
