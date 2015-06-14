package com.example.dummy1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//this class is created becuase the getView() method run lots of time, so this stuff is 
//intialised and declared here, so that getView() don't run this every time it runs.......
public class getview_helper_class {
	
	ImageView refrence_xml_imageobj;
	TextView refrence_xml_textobj;
	
	public getview_helper_class(View v) {
	
		refrence_xml_imageobj = (ImageView) v
				.findViewById(R.id.refrence_layout_imageid);
		refrence_xml_textobj = (TextView) v
				.findViewById(R.id.refrence_layout_textviewid);
	
	}
}
