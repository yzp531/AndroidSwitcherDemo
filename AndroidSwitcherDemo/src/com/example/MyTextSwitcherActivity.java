package com.example;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import android.app.Activity;
import android.graphics.Color;

public class MyTextSwitcherActivity extends Activity {

	private TextSwitcher textSwitcher;
	private Button b;

	String myContent[]={"A","B","C","D"};

	//used to keep track of text index
	int currentIndex=-1; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_switcher);

		textSwitcher = (TextSwitcher)findViewById(R.id.textSwitcher);
		b= (Button)findViewById(R.id.btn1);

		//set ViewFactory of TextSwitcher to dynamically create TextView
		textSwitcher.setFactory(new ViewFactory() {

			public View makeView() {
				// TODO Auto-generated method stub
				// create new textView 
				TextView myText = new TextView(MyTextSwitcherActivity.this);
				myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
				myText.setTextSize(42);
				myText.setTextColor(Color.RED);
				return myText;
			}
		});

		// Declare the in and out animations
		Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
		Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);

		// set the animation of textSwitcher
		textSwitcher.setInAnimation(in);
		textSwitcher.setOutAnimation(out);

		//button click
		b.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				currentIndex++;
				// If index reaches maximum reset it
				if(currentIndex==myContent.length)
					currentIndex=0;
				textSwitcher.setText(myContent[currentIndex]);
			}
		});

	}


}
