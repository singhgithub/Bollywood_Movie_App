package com.example.dummy1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements
		AdapterView.OnItemClickListener, OnItemSelectedListener, OnClickListener {

	//below are the declarations for the entire project 
	ListView listview_obj;
	Spinner spinner_obj;
	ArrayAdapter<String> spinner_arrayadapter_obj;
	String[] spinner_months_array;
	int[] listview_april_image_array;
	int[] listview_may_image_array;
	int[] listview_june_image_array;
	int[] listview_july_image_array;
	int[] listview_august_image_array;
	int[] listview_september_image_array;
	int[] listview_october_image_array;
	int[] listview_november_image_array;
	int[] listview_december_image_array;
	String[] dummy_array;
	listview_adapter_class listview_adapter_obj_for_april;
	listview_adapter_class listview_adapter_obj_for_may;
	listview_adapter_class listview_adapter_obj_for_june;
	listview_adapter_class listview_adapter_obj_for_july;
	listview_adapter_class listview_adapter_obj_for_august;
	listview_adapter_class listview_adapter_obj_for_september;
	listview_adapter_class listview_adapter_obj_for_october;
	listview_adapter_class listview_adapter_obj_for_november;
	listview_adapter_class listview_adapter_obj_for_december;
	String[] april_title_array;
	String[] april_opening_array;
	String[] april_genre_array;
	String[] april_director_array;
	String[] april_cast_array;
	//String mysql_db_table_april_url = "http://10.0.3.2/Example/Android/movie_project/upcoming_movies.php";
	//String mysql_db_table_april_url = "http://*******/Example/Android/movie_project/upcoming_movies.php";
	String mysql_db_table_april_url = "http://*******/movie_project/upcoming_movies.php";
	String[] may_title_array;
	String[] may_opening_array;
	String[] may_genre_array;
	String[] may_director_array;
	String[] may_cast_array;
	//String mysql_db_table_may_url = "http://10.0.3.2/Example/Android/movie_project/may.php";
	//String mysql_db_table_may_url = "http://*******/Example/Android/movie_project/may.php";
	String mysql_db_table_may_url = "http://*******/movie_project/may.php";
	String[] june_title_array;
	String[] june_opening_array;
	String[] june_genre_array;
	String[] june_director_array;
	String[] june_cast_array;
	//String mysql_db_table_june_url = "http://10.0.3.2/Example/Android/movie_project/june.php";
	String mysql_db_table_june_url = "http://*******/movie_project/june.php";
	String[] july_title_array;
	String[] july_opening_array;
	String[] july_genre_array;
	String[] july_director_array;
	String[] july_cast_array;
	//String mysql_db_table_july_url = "http://10.0.3.2/Example/Android/movie_project/july.php";
	//String mysql_db_table_july_url = "http://*******/Example/Android/movie_project/july.php";
	String mysql_db_table_july_url = "http://*******/movie_project/july.php";
	String[] august_title_array;
	String[] august_opening_array;
	String[] august_genre_array;
	String[] august_director_array;
	String[] august_cast_array;
	//String mysql_db_table_august_url = "http://10.0.3.2/Example/Android/movie_project/august.php";
	//String mysql_db_table_august_url = "http://*******/Example/Android/movie_project/august.php";
	String mysql_db_table_august_url = "http://*******/movie_project/august.php";
	String[] september_title_array;
	String[] september_opening_array;
	String[] september_genre_array;
	String[] september_director_array;
	String[] september_cast_array;
	//String mysql_db_table_september_url = "http://10.0.3.2/Example/Android/movie_project/september.php";
	//String mysql_db_table_september_url = "http://*******/Example/Android/movie_project/september.php";
	String mysql_db_table_september_url = "http://*******/movie_project/september.php";
	
	String[] october_title_array;
	String[] october_opening_array;
	String[] october_genre_array;
	String[] october_director_array;
	String[] october_cast_array;
	//String mysql_db_table_october_url = "http://10.0.3.2/Example/Android/movie_project/october.php";
	//String mysql_db_table_october_url = "http://*******/Example/Android/movie_project/october.php";
	String mysql_db_table_october_url = "http://*******/movie_project/october.php";
	String[] november_title_array;
	String[] november_opening_array;
	String[] november_genre_array;
	String[] november_director_array;
	String[] november_cast_array;
	//String mysql_db_table_november_url = "http://10.0.3.2/Example/Android/movie_project/november.php";
	//String mysql_db_table_november_url = "http://*******/Example/Android/movie_project/november.php";
	String mysql_db_table_november_url = "http://*******/movie_project/november.php";
	String[] december_title_array;
	String[] december_opening_array;
	String[] december_genre_array;
	String[] december_director_array;
	String[] december_cast_array;
	//String mysql_db_table_december_url = "http://10.0.3.2/Example/Android/movie_project/december.php";
	//String mysql_db_table_december_url = "http://*******/Example/Android/movie_project/december.php";
	String mysql_db_table_december_url = "http://*******/movie_project/december.php";
	//Drawable drawable_obj;
	LinearLayout linear_layout_obj;
	TextView textview_status_obj;
	Button about_button_obj;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		System.out.println("onCreate() called");
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);


		//intialize the asynclas
		new asynctask_class().execute(mysql_db_table_april_url);
		System.out.println("asynctask_class() called");
		
		new asynctask_class().execute(mysql_db_table_may_url);
		System.out.println("asynctask_class() called (for may)");
		
		new asynctask_class().execute(mysql_db_table_june_url);
		System.out.println("asynctask_class() called (for june)");
		
		new asynctask_class().execute(mysql_db_table_july_url);
		System.out.println("asynctask_class() called (for july)");
		
		new asynctask_class().execute(mysql_db_table_august_url);
		System.out.println("asynctask_class() called (for may)");
		
		new asynctask_class().execute(mysql_db_table_september_url);
		System.out.println("asynctask_class() called (for september)");
		
		new asynctask_class().execute(mysql_db_table_october_url);
		System.out.println("asynctask_class() called (for october)");
		
		new asynctask_class().execute(mysql_db_table_november_url);
		System.out.println("asynctask_class() called (for november)");
		
		new asynctask_class().execute(mysql_db_table_december_url);
		System.out.println("asynctask_class() called (for november)");
		
	}

/*	public void aboutbutton_onclick_method(View v) {
			if (v==findViewById(R.id.about_button_id)){
			Dialog aboutbutton_dialog_obj = new Dialog(this);
			aboutbutton_dialog_obj.requestWindowFeature(Window.FEATURE_NO_TITLE);
			aboutbutton_dialog_obj.setContentView(R.layout.about_layout);
			TextView aboutlayout_textview_obj = (TextView) findViewById(R.id.about_textveiw_id);
			CharSequence about_string = "Hi,\n The main reason I build this app was, I wanted"
					+ "to learn how to make android apps, as this is my first app ever. Learning by "
					+ "doing is the best practise, when it comes to Maths or making apps. \n Even though "
					+ "my attentions were never to build the app and share with other. But I think since "
					+ "I made it, I think other moive buff like me would enjoy it. \n This is a beta or "
					+ "tester version and you can help me turn this into a proper app by giving me your "
					+ "feedback \n cheerssssssssssssss";
			aboutlayout_textview_obj.setText(about_string);
			aboutbutton_dialog_obj.show();
		}
	}*/

	// all the intializations happens here
	public void all_the_objs_intialized_here() {
		
		System.out.println("all_the_objs_intialized_here() called");
		
		listview_obj = (ListView) findViewById(R.id.listView_id);
		spinner_obj = (Spinner) findViewById(R.id.spinner_id);
		spinner_obj.setPrompt("Select the month");
		
		//"default" is add becuase by startup the spinner selects the first items 
		//so if arpil is selected in the begiening the listview will be created
		spinner_months_array = new String[] { "Home", "April", "May", "June", "July",
				"August", "September", "October", "November", "December" };
		spinner_arrayadapter_obj = new ArrayAdapter<>(this,
				android.R.layout.simple_dropdown_item_1line,
				spinner_months_array);

		listview_april_image_array = new int[] { R.drawable.ebnebatuta,
				R.drawable.honorkilling, R.drawable.jal,
				R.drawable.mainterahero, R.drawable.angryyoungman,
				R.drawable.bhoothnathreturns, R.drawable.twostates,
				R.drawable.dekhtamashadekh, R.drawable.luckykabootar,
				R.drawable.kaanchi, R.drawable.revolverrani,
				R.drawable.samratandco };
		listview_may_image_array = new int[] { R.drawable.puranijeans,
				R.drawable.kyadillikyalahore, R.drawable.hawwahawwaai,
				R.drawable.khwaabb, R.drawable.koyelaanchal,
				R.drawable.mastram, R.drawable.yehhaibakrapur,
				R.drawable.heropanti, R.drawable.xpose, R.drawable.citylights,
				R.drawable.kukumathurkijhandhogayi };
		listview_june_image_array = new int[] { R.drawable.filmistaan,
				R.drawable.holiday, R.drawable.fugly, R.drawable.humshakals,
				R.drawable.ekvillain, R.drawable.creature3d };
		listview_july_image_array = new int[] {
				R.drawable.humptysharmakidulhania, R.drawable.kick };
		listview_august_image_array = new int[] { R.drawable.bobbyjasoos,
				R.drawable.itsentertainment, R.drawable.singhamreturns,
				R.drawable.mardaani, R.drawable.rajanatwarlal };
		listview_september_image_array = new int[] {
				R.drawable.daawateishqposter, R.drawable.findingfannyfernades,
				R.drawable.nh10 };
		listview_october_image_array = new int[] { R.drawable.haider,
				R.drawable.bangbang, R.drawable.marykom,
				R.drawable.happynewyear };
		listview_november_image_array = new int[] { R.drawable.actionjackson,
				R.drawable.unglee, R.drawable.killdill, R.drawable.bombayvelvet };
		listview_december_image_array = new int[] { R.drawable.alliswell,
				R.drawable.tevar, R.drawable.pk, R.drawable.welcomeback };

		dummy_array = new String[] { "1", "2", "3", "4", "5", "6", "7", "8","9", "10", "11", "12" };
		
		//moved to onItemselected() 
		// first param(class),second stringarray, third imagearray
		/*listview_adapter_obj = new listview_adapter_class(this, april_title_array,
				listview_image_array);
		System.out.println("listview_adapter_class called");
		*/
		
		about_button_obj =(Button) findViewById(R.id.about_button_id);
		about_button_obj.setOnClickListener(this);
	}

	// setting the obj to its adapters happens here
	public void setting_up_the_adapter_happens_here() {
		
		System.out.println("setting_up_the_adapter_happens_here() called");
		
		//this is moved to spinner onItemselected()
/*		// set the adapter on listview
		listview_obj.setAdapter(listview_adapter_obj);
*/
		// set adpater on spinner
		spinner_obj.setAdapter(spinner_arrayadapter_obj);

	}

	//setting the listener on the objs
	public void setting_up_the_listeners_happens_here(){
		
		System.out.println("setting_up_the_listeners_happens_here() called");
		
		listview_obj.setOnItemClickListener(this);
		
		spinner_obj.setOnItemSelectedListener(this);
	}
	
	
	//This called is reused for each months to set the listview looks
	// class to make a custom arrayadapter for the listview, and use a new xml
	// layout instead of the predefined onces
	class listview_adapter_class extends ArrayAdapter<String> {
		
	
		// these objects are declared here so they can be access inside
		// getview() method
		Context context;
		int[] images_array1;
		String[] listview_array1;

		// the constructor is only used to set the main class objects to this
		// class objects
		public listview_adapter_class(Context c, String[] x, int y[]) {
			// override the default construtor ??????
			super(c, R.layout.arrayadapter_refrence_layout,
					R.id.refrence_layout_textviewid, x);
			this.context = c;
			this.images_array1 = y;
			this.listview_array1 = x;
		}

		// this method calls the listview_adapter and this methods gets called
		// for each list row
		// this method returns a refrence xml layout object
		// this method runs automatically
		//(view recycle)the first parameter is the row location, second is the old row object goes out of the screen
		//when used scroll down, the third is the listview obj
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View viewobj_refrence_to_refrence_xml= convertView;
			getview_helper_class getview_helper_class_obj = null;
			
			//only run this code when the user display the listview screen the first time
			//dont' have to run this peice of code every time the user scroll
			if (viewobj_refrence_to_refrence_xml == null) {
				LayoutInflater inflater = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				// create a refrence java obj for the refrence xml relative
				// layout
				// parent refers to listview obj for xml linking
				viewobj_refrence_to_refrence_xml = inflater.inflate(
						R.layout.arrayadapter_refrence_layout, parent, false);
				
				//intialize the getview_helper_class with a constructor parameter, view
				getview_helper_class_obj = new getview_helper_class(viewobj_refrence_to_refrence_xml);
				//not sure wat this means
				viewobj_refrence_to_refrence_xml.setTag(getview_helper_class_obj);
				
			}else{
				//not sure wat this means
				getview_helper_class_obj = (getview_helper_class) viewobj_refrence_to_refrence_xml.getTag();
				
			}
			
			//set the images and text via the getview_helper_class rather than image/text objects
			getview_helper_class_obj.refrence_xml_imageobj.setImageResource(images_array1[position]);
			getview_helper_class_obj.refrence_xml_textobj.setText(listview_array1[position]);

			/*			// this send the image and strings to xml refrence layout
			refrence_xml_imageobj.setImageResource(images_array1[position]);
			refrence_xml_textobj.setText(listview_array1[position]);
			 */
			
			//System.out.println("getView() called");
			//the return is the listview row object
			return viewobj_refrence_to_refrence_xml;
			
		}


	}

	//listerner for listview & this is where the dialog happens
	//don't kwow wat the parameters parent and view means for this method
	//creating dialogs depending up what month listview is click /also what row of the listview clicked
	//display dialog box depending on which listview is intialized and pass respective data for to the layout
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		//get aprils first movie in the list, and store it in a string
		String temp_for_april_first_movie_title = april_title_array[0];
		String temp_for_may_first_movie_title = may_title_array[0];
		String temp_for_june_first_movie_title = june_title_array[0];
		String temp_for_july_first_movie_title = july_title_array[0];
		String temp_for_august_first_movie_title = august_title_array[0];
		String temp_for_september_first_movie_title = september_title_array[0];
		String temp_for_october_first_movie_title = october_title_array[0];
		String temp_for_november_first_movie_title = november_title_array[0];
		String temp_for_december_first_movie_title = december_title_array[0];
		
		//get the string value or name of the movie in the first row depend up on which listview object is being called
		String selected_listview_first_row_item = (String) parent.getItemAtPosition(0);
		System.out.println("The present listview item row one is:" + selected_listview_first_row_item );
		
		//if the selected listview first row movie name == first movie of april, then run the code
		if (selected_listview_first_row_item.equals(temp_for_april_first_movie_title)) {
		
		System.out.println("onItemClick called");
		
		switch (position) {
		case 0:
			get_data_from_respective_arrays_and_send_it_to_dialog_layout(0, april_title_array, april_opening_array, april_genre_array, april_director_array, april_cast_array,listview_april_image_array);
			break;
		case 1:
			get_data_from_respective_arrays_and_send_it_to_dialog_layout(1, april_title_array, april_opening_array, april_genre_array, april_director_array, april_cast_array,listview_april_image_array);
			break;
		case 2:
			get_data_from_respective_arrays_and_send_it_to_dialog_layout(2, april_title_array, april_opening_array, april_genre_array, april_director_array, april_cast_array,listview_april_image_array);			
			break;
		case 3:
			get_data_from_respective_arrays_and_send_it_to_dialog_layout(3, april_title_array, april_opening_array, april_genre_array, april_director_array, april_cast_array,listview_april_image_array);			
			break;
		case 4:
			get_data_from_respective_arrays_and_send_it_to_dialog_layout(4, april_title_array, april_opening_array, april_genre_array, april_director_array, april_cast_array,listview_april_image_array);			
			break;
		case 5:
			get_data_from_respective_arrays_and_send_it_to_dialog_layout(5, april_title_array, april_opening_array, april_genre_array, april_director_array, april_cast_array,listview_april_image_array);			
			break;
		case 6:
			get_data_from_respective_arrays_and_send_it_to_dialog_layout(6, april_title_array, april_opening_array, april_genre_array, april_director_array, april_cast_array,listview_april_image_array);			
			break;
		case 7:
			get_data_from_respective_arrays_and_send_it_to_dialog_layout(7, april_title_array, april_opening_array, april_genre_array, april_director_array, april_cast_array,listview_april_image_array);			
			break;
		case 8:
			get_data_from_respective_arrays_and_send_it_to_dialog_layout(8, april_title_array, april_opening_array, april_genre_array, april_director_array, april_cast_array,listview_april_image_array);			
			break;
		case 9:
			get_data_from_respective_arrays_and_send_it_to_dialog_layout(9, april_title_array, april_opening_array, april_genre_array, april_director_array, april_cast_array,listview_april_image_array);			
			break;
		case 10:
			get_data_from_respective_arrays_and_send_it_to_dialog_layout(10, april_title_array, april_opening_array, april_genre_array, april_director_array, april_cast_array,listview_april_image_array);			
			break;
		case 11:
			get_data_from_respective_arrays_and_send_it_to_dialog_layout(11, april_title_array, april_opening_array, april_genre_array, april_director_array, april_cast_array,listview_april_image_array);			
			break;
		case 12:
			get_data_from_respective_arrays_and_send_it_to_dialog_layout(12, april_title_array, april_opening_array, april_genre_array, april_director_array, april_cast_array,listview_april_image_array);			
			break;
		
			}
		
		}
		
		else if (selected_listview_first_row_item.equals(temp_for_may_first_movie_title)) {
			System.out.println("onItemClick called");
			
			switch (position) {
			case 0:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(0, may_title_array, may_opening_array, may_genre_array, may_director_array, may_cast_array,listview_may_image_array);
				break;
			case 1:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(1, may_title_array, may_opening_array, may_genre_array, may_director_array, may_cast_array,listview_may_image_array);
				break;
			case 2:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(2, may_title_array, may_opening_array, may_genre_array, may_director_array, may_cast_array,listview_may_image_array);			
				break;
			case 3:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(3, may_title_array, may_opening_array, may_genre_array, may_director_array, may_cast_array,listview_may_image_array);			
				break;
			case 4:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(4, may_title_array, may_opening_array, may_genre_array, may_director_array, may_cast_array,listview_may_image_array);			
				break;
			case 5:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(5, may_title_array, may_opening_array, may_genre_array, may_director_array, may_cast_array,listview_may_image_array);			
				break;
			case 6:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(6, may_title_array, may_opening_array, may_genre_array, may_director_array, may_cast_array,listview_may_image_array);			
				break;
			case 7:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(7, may_title_array, may_opening_array, may_genre_array, may_director_array, may_cast_array,listview_may_image_array);			
				break;
			case 8:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(8, may_title_array, may_opening_array, may_genre_array, may_director_array, may_cast_array,listview_may_image_array);			
				break;
			case 9:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(9, may_title_array, may_opening_array, may_genre_array, may_director_array, may_cast_array,listview_may_image_array);			
				break;
			case 10:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(10, may_title_array, may_opening_array, may_genre_array, may_director_array, may_cast_array,listview_may_image_array);			
				break;
			case 11:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(11, may_title_array, may_opening_array, may_genre_array, may_director_array, may_cast_array,listview_may_image_array);			
				break;
			case 12:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(12, may_title_array, may_opening_array, may_genre_array, may_director_array, may_cast_array,listview_may_image_array);			
				break;
			}
			
		}
		else if (selected_listview_first_row_item.equals(temp_for_june_first_movie_title)) {
			switch (position) {
			case 0:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(0, june_title_array, june_opening_array, june_genre_array, june_director_array, june_cast_array,listview_june_image_array);
				break;
			case 1:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(1, june_title_array, june_opening_array, june_genre_array, june_director_array, june_cast_array,listview_june_image_array);
				break;
			case 2:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(2, june_title_array, june_opening_array, june_genre_array, june_director_array, june_cast_array,listview_june_image_array);			
				break;
			case 3:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(3, june_title_array, june_opening_array, june_genre_array, june_director_array, june_cast_array,listview_june_image_array);			
				break;
			case 4:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(4, june_title_array, june_opening_array, june_genre_array, june_director_array, june_cast_array,listview_june_image_array);			
				break;
			case 5:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(5, june_title_array, june_opening_array, june_genre_array, june_director_array, june_cast_array,listview_june_image_array);			
				break;
			case 6:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(6, june_title_array, june_opening_array, june_genre_array, june_director_array, june_cast_array,listview_june_image_array);			
				break;
			case 7:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(7, june_title_array, june_opening_array, june_genre_array, june_director_array, june_cast_array,listview_june_image_array);			
				break;
			case 8:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(8, june_title_array, june_opening_array, june_genre_array, june_director_array, june_cast_array,listview_june_image_array);			
				break;
			case 9:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(9, june_title_array, june_opening_array, june_genre_array, june_director_array, june_cast_array,listview_june_image_array);			
				break;
			case 10:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(10, june_title_array, june_opening_array, june_genre_array, june_director_array, june_cast_array,listview_june_image_array);			
				break;
			case 11:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(11, june_title_array, june_opening_array, june_genre_array, june_director_array, june_cast_array,listview_june_image_array);			
				break;
			case 12:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(12, june_title_array, june_opening_array, june_genre_array, june_director_array, june_cast_array,listview_june_image_array);			
				break;
			}
		}
		else if (selected_listview_first_row_item.equals(temp_for_july_first_movie_title)) {
		
			switch (position) {
			case 0:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(0, july_title_array, july_opening_array, july_genre_array, july_director_array, july_cast_array,listview_july_image_array);
				break;
			case 1:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(1, july_title_array, july_opening_array, july_genre_array, july_director_array, july_cast_array,listview_july_image_array);
				break;
			case 2:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(2, july_title_array, july_opening_array, july_genre_array, july_director_array, july_cast_array,listview_july_image_array);			
				break;
			case 3:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(3, july_title_array, july_opening_array, july_genre_array, july_director_array, july_cast_array,listview_july_image_array);			
				break;
			case 4:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(4, july_title_array, july_opening_array, july_genre_array, july_director_array, july_cast_array,listview_july_image_array);			
				break;
			case 5:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(5, july_title_array, july_opening_array, july_genre_array, july_director_array, july_cast_array,listview_july_image_array);			
				break;
			case 6:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(6, july_title_array, july_opening_array, july_genre_array, july_director_array, july_cast_array,listview_july_image_array);			
				break;
			case 7:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(7, july_title_array, july_opening_array, july_genre_array, july_director_array, july_cast_array,listview_july_image_array);			
				break;
			case 8:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(8, july_title_array, july_opening_array, july_genre_array, july_director_array, july_cast_array,listview_july_image_array);			
				break;
			case 9:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(9, july_title_array, july_opening_array, july_genre_array, july_director_array, july_cast_array,listview_july_image_array);			
				break;
			case 10:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(10, july_title_array, july_opening_array, july_genre_array, july_director_array, july_cast_array,listview_july_image_array);			
				break;
			case 11:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(11, july_title_array, july_opening_array, july_genre_array, july_director_array, july_cast_array,listview_july_image_array);			
				break;
			case 12:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(12, july_title_array, july_opening_array, july_genre_array, july_director_array, july_cast_array,listview_july_image_array);			
				break;
			}
			
			
		}
		else if (selected_listview_first_row_item.equals(temp_for_august_first_movie_title)) {
			
			switch (position) {
			case 0:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(0, august_title_array, august_opening_array, august_genre_array, august_director_array, august_cast_array,listview_august_image_array);
				break;
			case 1:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(1, august_title_array, august_opening_array, august_genre_array, august_director_array, august_cast_array,listview_august_image_array);
				break;
			case 2:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(2, august_title_array, august_opening_array, august_genre_array, august_director_array, august_cast_array,listview_august_image_array);			
				break;
			case 3:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(3, august_title_array, august_opening_array, august_genre_array, august_director_array, august_cast_array,listview_august_image_array);			
				break;
			case 4:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(4, august_title_array, august_opening_array, august_genre_array, august_director_array, august_cast_array,listview_august_image_array);			
				break;
			case 5:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(5, august_title_array, august_opening_array, august_genre_array, august_director_array, august_cast_array,listview_august_image_array);			
				break;
			case 6:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(6, august_title_array, august_opening_array, august_genre_array, august_director_array, august_cast_array,listview_august_image_array);			
				break;
			case 7:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(7, august_title_array, august_opening_array, august_genre_array, august_director_array, august_cast_array,listview_august_image_array);			
				break;
			case 8:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(8, august_title_array, august_opening_array, august_genre_array, august_director_array, august_cast_array,listview_august_image_array);			
				break;
			case 9:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(9, august_title_array, august_opening_array, august_genre_array, august_director_array, august_cast_array,listview_august_image_array);			
				break;
			case 10:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(10, august_title_array, august_opening_array, august_genre_array, august_director_array, august_cast_array,listview_august_image_array);			
				break;
			case 11:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(11, august_title_array, august_opening_array, august_genre_array, august_director_array, august_cast_array,listview_august_image_array);			
				break;
			case 12:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(12, august_title_array, august_opening_array, august_genre_array, august_director_array, august_cast_array,listview_august_image_array);			
				break;
			}
			
		}
		else if (selected_listview_first_row_item.equals(temp_for_september_first_movie_title)) {
			
			switch (position) {
			case 0:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(0, september_title_array, september_opening_array, september_genre_array, september_director_array, september_cast_array,listview_september_image_array);
				break;
			case 1:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(1, september_title_array, september_opening_array, september_genre_array, september_director_array, september_cast_array,listview_september_image_array);
				break;
			case 2:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(2, september_title_array, september_opening_array, september_genre_array, september_director_array, september_cast_array,listview_september_image_array);			
				break;
			case 3:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(3, september_title_array, september_opening_array, september_genre_array, september_director_array, september_cast_array,listview_september_image_array);			
				break;
			case 4:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(4, september_title_array, september_opening_array, september_genre_array, september_director_array, september_cast_array,listview_september_image_array);			
				break;
			case 5:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(5, september_title_array, september_opening_array, september_genre_array, september_director_array, september_cast_array,listview_september_image_array);			
				break;
			case 6:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(6, september_title_array, september_opening_array, september_genre_array, september_director_array, september_cast_array,listview_september_image_array);			
				break;
			case 7:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(7, september_title_array, september_opening_array, september_genre_array, september_director_array, september_cast_array,listview_september_image_array);			
				break;
			case 8:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(8, september_title_array, september_opening_array, september_genre_array, september_director_array, september_cast_array,listview_september_image_array);			
				break;
			case 9:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(9, september_title_array, september_opening_array, september_genre_array, september_director_array, september_cast_array,listview_september_image_array);			
				break;
			case 10:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(10, september_title_array, september_opening_array, september_genre_array, september_director_array, september_cast_array,listview_september_image_array);			
				break;
			case 11:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(11, september_title_array, september_opening_array, september_genre_array, september_director_array, september_cast_array,listview_september_image_array);			
				break;
			case 12:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(12, september_title_array, september_opening_array, september_genre_array, september_director_array, september_cast_array,listview_september_image_array);			
				break;
			}
			
		}
		else if (selected_listview_first_row_item.equals(temp_for_october_first_movie_title)) {
			
			switch (position) {
			case 0:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(0, october_title_array, october_opening_array, october_genre_array, october_director_array, october_cast_array,listview_october_image_array);
				break;
			case 1:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(1, october_title_array, october_opening_array, october_genre_array, october_director_array, october_cast_array,listview_october_image_array);
				break;
			case 2:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(2, october_title_array, october_opening_array, october_genre_array, october_director_array, october_cast_array,listview_october_image_array);			
				break;
			case 3:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(3, october_title_array, october_opening_array, october_genre_array, october_director_array, october_cast_array,listview_october_image_array);			
				break;
			case 4:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(4, october_title_array, october_opening_array, october_genre_array, october_director_array, october_cast_array,listview_october_image_array);			
				break;
			case 5:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(5, october_title_array, october_opening_array, october_genre_array, october_director_array, october_cast_array,listview_october_image_array);			
				break;
			case 6:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(6, october_title_array, october_opening_array, october_genre_array, october_director_array, october_cast_array,listview_october_image_array);			
				break;
			case 7:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(7, october_title_array, october_opening_array, october_genre_array, october_director_array, october_cast_array,listview_october_image_array);			
				break;
			case 8:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(8, october_title_array, october_opening_array, october_genre_array, october_director_array, october_cast_array,listview_october_image_array);			
				break;
			case 9:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(9, october_title_array, october_opening_array, october_genre_array, october_director_array, october_cast_array,listview_october_image_array);			
				break;
			case 10:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(10, october_title_array, october_opening_array, october_genre_array, october_director_array, october_cast_array,listview_october_image_array);			
				break;
			case 11:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(11, october_title_array, october_opening_array, october_genre_array, october_director_array, october_cast_array,listview_october_image_array);			
				break;
			case 12:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(12, october_title_array, october_opening_array, october_genre_array, october_director_array, october_cast_array,listview_october_image_array);			
				break;
			}
			
		}
		else if (selected_listview_first_row_item.equals(temp_for_november_first_movie_title)) {
			
			switch (position) {
			case 0:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(0, november_title_array, november_opening_array, november_genre_array, november_director_array, november_cast_array,listview_november_image_array);
				break;
			case 1:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(1, november_title_array, november_opening_array, november_genre_array, november_director_array, november_cast_array,listview_november_image_array);
				break;
			case 2:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(2, november_title_array, november_opening_array, november_genre_array, november_director_array, november_cast_array,listview_november_image_array);			
				break;
			case 3:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(3, november_title_array, november_opening_array, november_genre_array, november_director_array, november_cast_array,listview_november_image_array);			
				break;
			case 4:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(4, november_title_array, november_opening_array, november_genre_array, november_director_array, november_cast_array,listview_november_image_array);			
				break;
			case 5:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(5, november_title_array, november_opening_array, november_genre_array, november_director_array, november_cast_array,listview_november_image_array);			
				break;
			case 6:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(6, november_title_array, november_opening_array, november_genre_array, november_director_array, november_cast_array,listview_november_image_array);			
				break;
			case 7:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(7, november_title_array, november_opening_array, november_genre_array, november_director_array, november_cast_array,listview_november_image_array);			
				break;
			case 8:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(8, november_title_array, november_opening_array, november_genre_array, november_director_array, november_cast_array,listview_november_image_array);			
				break;
			case 9:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(9, november_title_array, november_opening_array, november_genre_array, november_director_array, november_cast_array,listview_november_image_array);			
				break;
			case 10:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(10, november_title_array, november_opening_array, november_genre_array, november_director_array, november_cast_array,listview_november_image_array);			
				break;
			case 11:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(11, november_title_array, november_opening_array, november_genre_array, november_director_array, november_cast_array,listview_november_image_array);			
				break;
			case 12:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(12, november_title_array, november_opening_array, november_genre_array, november_director_array, november_cast_array,listview_november_image_array);			
				break;
			}
			
		}
		else if (selected_listview_first_row_item.equals(temp_for_december_first_movie_title)) {
			
			switch (position) {
			case 0:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(0, december_title_array, december_opening_array, december_genre_array, december_director_array, december_cast_array,listview_december_image_array);
				break;
			case 1:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(1, december_title_array, december_opening_array, december_genre_array, december_director_array, december_cast_array,listview_december_image_array);
				break;
			case 2:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(2, december_title_array, december_opening_array, december_genre_array, december_director_array, december_cast_array,listview_december_image_array);			
				break;
			case 3:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(3, december_title_array, december_opening_array, december_genre_array, december_director_array, december_cast_array,listview_december_image_array);			
				break;
			case 4:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(4, december_title_array, december_opening_array, december_genre_array, december_director_array, december_cast_array,listview_december_image_array);			
				break;
			case 5:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(5, december_title_array, december_opening_array, december_genre_array, december_director_array, december_cast_array,listview_december_image_array);			
				break;
			case 6:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(6, december_title_array, december_opening_array, december_genre_array, december_director_array, december_cast_array,listview_december_image_array);			
				break;
			case 7:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(7, december_title_array, december_opening_array, december_genre_array, december_director_array, december_cast_array,listview_december_image_array);			
				break;
			case 8:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(8, december_title_array, december_opening_array, december_genre_array, december_director_array, december_cast_array,listview_december_image_array);			
				break;
			case 9:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(9, december_title_array, december_opening_array, december_genre_array, december_director_array, december_cast_array,listview_december_image_array);			
				break;
			case 10:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(10, december_title_array, december_opening_array, december_genre_array, december_director_array, december_cast_array,listview_december_image_array);			
				break;
			case 11:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(11, december_title_array, december_opening_array, december_genre_array, december_director_array, december_cast_array,listview_december_image_array);			
				break;
			case 12:
				get_data_from_respective_arrays_and_send_it_to_dialog_layout(12, december_title_array, december_opening_array, december_genre_array, december_director_array, december_cast_array, listview_december_image_array);			
				break;
			}
			
		}
	}
	
	
	//this method fetches the data from the arrays and send them to the respective dialog layout widgets(textbox etc....)
	public void get_data_from_respective_arrays_and_send_it_to_dialog_layout(int index, String[] a, String[] b, String[] c, String[]d, String[] e, int[] f ){
		final Dialog dialog_obj = new Dialog(this);

		dialog_obj.requestWindowFeature(Window.FEATURE_NO_TITLE);

		dialog_obj.setContentView(R.layout.dialog_layout);
		// dialog.setTitle("Title...");

		// set the custom dialog components - text, image and button
		
		ImageView dialog_layout_imageview_id_obj = (ImageView) dialog_obj.findViewById(R.id.dialog_layout_image_id);
		dialog_layout_imageview_id_obj.setImageDrawable(getResources().getDrawable(f[index]));
		
		TextView dialog_layout_textview_id_title_obj = (TextView) dialog_obj
				.findViewById(R.id.dialog_layout_textview_id_title);
		dialog_layout_textview_id_title_obj.setText(a[index]);

		TextView dialog_layout_textview_id_opening_obj = (TextView) dialog_obj
				.findViewById(R.id.dialog_layout_textview_id_opening);
		dialog_layout_textview_id_opening_obj.setText(b[index]
				+ "th");

		TextView dialog_layout_textview_id_genre_obj = (TextView) dialog_obj
				.findViewById(R.id.dialog_layout_textview_id_genre);
		dialog_layout_textview_id_genre_obj.setText(c[index]);

		TextView dialog_layout_textview_id_director_obj = (TextView) dialog_obj
				.findViewById(R.id.dialog_layout_textview_id_director);
		dialog_layout_textview_id_director_obj.setText(d[index]);

		TextView dialog_layout_textview_id_cast_obj = (TextView) dialog_obj
				.findViewById(R.id.dialog_layout_textview_id_cast);
		dialog_layout_textview_id_cast_obj.setText(e[index]);

		dialog_obj.show();

		
	}
	


	//the asyn class for all the networking stuff to be happened in the background
	class asynctask_class extends AsyncTask<String, String, String> {

		String params_String_parameter;

		@Override
		protected void onPreExecute() {
			textview_status_obj = (TextView) findViewById(R.id.textview_id_status);
			textview_status_obj.setText("Wait...");
			
		}

		// the first parameter of the asynctask_class is passed into the
		// doinbackground method
		@Override
		protected String doInBackground(String... params) {
			
			System.out.println("doInBackground called");
			
			HttpURLConnection con = null;
			URL url;
			InputStream is = null;
			StringBuilder sb = null;

			try {
				// setting up a httpurl connection (section)
				params_String_parameter = params[0];
				url = new URL(params_String_parameter);
				con = (HttpURLConnection) url.openConnection();
				// con.setReadTimeout(10000 /* milliseconds */);
				// con.setConnectTimeout(15000 /* milliseconds */);
				con.setRequestMethod("GET");
				con.setDoInput(true);
				// Start the query
				con.connect();

				// web data as a long string (section)
				is = con.getInputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is));
				sb = new StringBuilder();
				String line = null;

				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}

				is.close();
				// function ran proberly
				System.out.println("DownloadURL() did not throw a exception...");
			} catch (IOException e) {
				// handle the exception !
				e.printStackTrace();
				System.out.println("DownloadURL() throw a exception... can't connect to the server URL");
			}

			return sb.toString();
		}

		// the result parameter has the value the is being returned by the
		// doinbackground method
		@Override
		protected void onPostExecute(String result) {
			
			System.out.println("onPostExecute called");

			if (params_String_parameter.equals(mysql_db_table_april_url)) {

				try {

					// this is a bridge between the php json string and java
					JSONObject json_obj = new JSONObject(result);
					// json used the name/value pair, & pass in the name of the
					// json array in the getjsonarray parameter
					JSONArray json_array = json_obj.getJSONArray("april");

					//System.out.println("Verify the jsonarray: "
						//	+ json_array.toString());

					// can put these intialization in the intializer methods
					// cause there i would not have access to jsonarray.length
					// intialize the array array before setting it equal to
					// jsonarray
					april_title_array = new String[json_array.length()];
					april_opening_array = new String[json_array.length()];
					april_genre_array = new String[json_array.length()];
					april_director_array = new String[json_array.length()];
					april_cast_array = new String[json_array.length()];

					// convert json array into java array & (get the all the
					// values of name "title")
					for (int i = 0; i < json_array.length(); i++) {
						april_title_array[i] = json_array.getJSONObject(i)
								.getString("title").toString();

						//System.out.println("Verify the april_title_array: "
							//	+ april_title_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						april_opening_array[i] = json_array.getJSONObject(i)
								.getString("opening").toString();

						//System.out.println("Verify the april_opening_array: "
							//	+ april_opening_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						april_genre_array[i] = json_array.getJSONObject(i)
								.getString("genre").toString();

						//System.out.println("Verify the april_genre_array: "
							//	+ april_genre_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						april_director_array[i] = json_array.getJSONObject(i)
								.getString("director").toString();

						//System.out.println("Verify the april_director_array: "
							//	+ april_director_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						april_cast_array[i] = json_array.getJSONObject(i)
								.getString("cast").toString();

						//System.out.println("Verify the april_cast_array: "
							//	+ april_cast_array[i]);
					}

					// all these methods are called here because i can say
					// "listview_adapter_obj = new listview_adapter_class(this,
					// april_title_array,
					// listview_image_array);" when april_title_array is not
					// even intialized, so first the array get intialized then
					// the class gets
					// intialized

					// calling the intializer fucntion first
					all_the_objs_intialized_here();

					// setup the apapters on the objs
					setting_up_the_adapter_happens_here();

					// set the onclicklistener
					setting_up_the_listeners_happens_here();
					/*
					 * listview_adapter_obj = new
					 * listview_adapter_class(MainActivity.this, dummy_array,
					 * listview_image_array);
					 * listview_obj.setAdapter(listview_adapter_obj);
					 */
					

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (params_String_parameter.equals(mysql_db_table_may_url)) {

				try {

					// this is a bridge between the php json string and java
					JSONObject json_obj = new JSONObject(result);
					// json used the name/value pair, & pass in the name of the
					// json array in the getjsonarray parameter
					JSONArray json_array = json_obj.getJSONArray("may");

					//System.out.println("Verify the jsonarray: "
						//	+ json_array.toString());

					// can put these intialization in the intializer methods
					// cause there i would not have access to jsonarray.length
					// intialize the array array before setting it equal to
					// jsonarray
					may_title_array = new String[json_array.length()];
					may_opening_array = new String[json_array.length()];
					may_genre_array = new String[json_array.length()];
					may_director_array = new String[json_array.length()];
					may_cast_array = new String[json_array.length()];

					// convert json array into java array & (get the all the
					// values of name "title")
					for (int i = 0; i < json_array.length(); i++) {
						may_title_array[i] = json_array.getJSONObject(i)
								.getString("title").toString();

						//System.out.println("Verify the may_title_array: "
							//	+ may_title_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						may_opening_array[i] = json_array.getJSONObject(i)
								.getString("opening").toString();

						//System.out.println("Verify the may_opening_array: "
							//	+ may_opening_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						may_genre_array[i] = json_array.getJSONObject(i)
								.getString("genre").toString();

						//System.out.println("Verify the may_genre_array: "
							//	+ may_genre_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						may_director_array[i] = json_array.getJSONObject(i)
								.getString("director").toString();

						//System.out.println("Verify the may_director_array: "
							//	+ may_director_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						may_cast_array[i] = json_array.getJSONObject(i)
								.getString("cast").toString();

						//System.out.println("Verify the may_cast_array: "
							//	+ may_cast_array[i]);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (params_String_parameter.equals(mysql_db_table_june_url)) {

				try {

					// this is a bridge between the php json string and java
					JSONObject json_obj = new JSONObject(result);
					// json used the name/value pair, & pass in the name of the
					// json array in the getjsonarray parameter
					JSONArray json_array = json_obj.getJSONArray("june");

				//	System.out.println("Verify the jsonarray: "
					//		+ json_array.toString());

					// can put these intialization in the intializer methods
					// cause there i would not have access to jsonarray.length
					// intialize the array array before setting it equal to
					// jsonarray
					june_title_array = new String[json_array.length()];
					june_opening_array = new String[json_array.length()];
					june_genre_array = new String[json_array.length()];
					june_director_array = new String[json_array.length()];
					june_cast_array = new String[json_array.length()];

					// convert json array into java array & (get the all the
					// values of name "title")
					for (int i = 0; i < json_array.length(); i++) {
						june_title_array[i] = json_array.getJSONObject(i)
								.getString("title").toString();

						//System.out.println("Verify the june_title_array: "
							//	+ june_title_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						june_opening_array[i] = json_array.getJSONObject(i)
								.getString("opening").toString();

						//System.out.println("Verify the june_opening_array: "
							//	+ june_opening_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						june_genre_array[i] = json_array.getJSONObject(i)
								.getString("genre").toString();

						//System.out.println("Verify the june_genre_array: "
							//	+ june_genre_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						june_director_array[i] = json_array.getJSONObject(i)
								.getString("director").toString();

						//System.out.println("Verify the june_director_array: "
							//	+ june_director_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						june_cast_array[i] = json_array.getJSONObject(i)
								.getString("cast").toString();

						//System.out.println("Verify the june_cast_array: "
							//	+ june_cast_array[i]);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (params_String_parameter.equals(mysql_db_table_july_url)) {

				try {

					// this is a bridge between the php json string and java
					JSONObject json_obj = new JSONObject(result);
					// json used the name/value pair, & pass in the name of the
					// json array in the getjsonarray parameter
					JSONArray json_array = json_obj.getJSONArray("july");

					//System.out.println("Verify the jsonarray: "
						//	+ json_array.toString());

					// can put these intialization in the intializer methods
					// cause there i would not have access to jsonarray.length
					// intialize the array array before setting it equal to
					// jsonarray
					july_title_array = new String[json_array.length()];
					july_opening_array = new String[json_array.length()];
					july_genre_array = new String[json_array.length()];
					july_director_array = new String[json_array.length()];
					july_cast_array = new String[json_array.length()];

					// convert json array into java array & (get the all the
					// values of name "title")
					for (int i = 0; i < json_array.length(); i++) {
						july_title_array[i] = json_array.getJSONObject(i)
								.getString("title").toString();

						//System.out.println("Verify the july_title_array: "
							//	+ july_title_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						july_opening_array[i] = json_array.getJSONObject(i)
								.getString("opening").toString();

						//System.out.println("Verify the july_opening_array: "
							//	+ july_opening_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						july_genre_array[i] = json_array.getJSONObject(i)
								.getString("genre").toString();

						//System.out.println("Verify the may_genre_array: "
							//	+ may_genre_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						july_director_array[i] = json_array.getJSONObject(i)
								.getString("director").toString();

						//System.out.println("Verify the july_director_array: "
							//	+ july_director_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						july_cast_array[i] = json_array.getJSONObject(i)
								.getString("cast").toString();

						//System.out.println("Verify the july_cast_array: "
							//	+ july_cast_array[i]);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (params_String_parameter
					.equals(mysql_db_table_august_url)) {

				try {

					// this is a bridge between the php json string and java
					JSONObject json_obj = new JSONObject(result);
					// json used the name/value pair, & pass in the name of the
					// json array in the getjsonarray parameter
					JSONArray json_array = json_obj.getJSONArray("august");

					//System.out.println("Verify the jsonarray: "
						//	+ json_array.toString());

					// can put these intialization in the intializer methods
					// cause there i would not have access to jsonarray.length
					// intialize the array array before setting it equal to
					// jsonarray
					august_title_array = new String[json_array.length()];
					august_opening_array = new String[json_array.length()];
					august_genre_array = new String[json_array.length()];
					august_director_array = new String[json_array.length()];
					august_cast_array = new String[json_array.length()];

					// convert json array into java array & (get the all the
					// values of name "title")
					for (int i = 0; i < json_array.length(); i++) {
						august_title_array[i] = json_array.getJSONObject(i)
								.getString("title").toString();

						//System.out.println("Verify the august_title_array: "
							//	+ august_title_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						august_opening_array[i] = json_array.getJSONObject(i)
								.getString("opening").toString();

						//System.out.println("Verify the august_opening_array: "
							//	+ may_opening_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						august_genre_array[i] = json_array.getJSONObject(i)
								.getString("genre").toString();

						//System.out.println("Verify the august_genre_array: "
							//	+ august_genre_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						august_director_array[i] = json_array.getJSONObject(i)
								.getString("director").toString();

						//System.out.println("Verify the august_director_array: "
							//	+ august_director_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						august_cast_array[i] = json_array.getJSONObject(i)
								.getString("cast").toString();

						//System.out.println("Verify the august_cast_array: "
							//	+ august_cast_array[i]);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (params_String_parameter
					.equals(mysql_db_table_september_url)) {

				try {

					// this is a bridge between the php json string and java
					JSONObject json_obj = new JSONObject(result);
					// json used the name/value pair, & pass in the name of the
					// json array in the getjsonarray parameter
					JSONArray json_array = json_obj.getJSONArray("september");

					//System.out.println("Verify the jsonarray: "
						//	+ json_array.toString());

					// can put these intialization in the intializer methods
					// cause there i would not have access to jsonarray.length
					// intialize the array array before setting it equal to
					// jsonarray
					september_title_array = new String[json_array.length()];
					september_opening_array = new String[json_array.length()];
					september_genre_array = new String[json_array.length()];
					september_director_array = new String[json_array.length()];
					september_cast_array = new String[json_array.length()];

					// convert json array into java array & (get the all the
					// values of name "title")
					for (int i = 0; i < json_array.length(); i++) {
						september_title_array[i] = json_array.getJSONObject(i)
								.getString("title").toString();

						//System.out.println("Verify the september_title_array: "
							//	+ september_title_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						september_opening_array[i] = json_array.getJSONObject(i)
								.getString("opening").toString();

						//System.out.println("Verify the september_opening_array: "
							//	+ september_opening_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						september_genre_array[i] = json_array.getJSONObject(i)
								.getString("genre").toString();

						//System.out.println("Verify the september_genre_array: "
							//	+ september_genre_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						september_director_array[i] = json_array.getJSONObject(i)
								.getString("director").toString();

						//System.out.println("Verify the september_director_array: "
							//	+ september_director_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						september_cast_array[i] = json_array.getJSONObject(i)
								.getString("cast").toString();

						//System.out.println("Verify the september_cast_array: "
							//	+ september_cast_array[i]);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (params_String_parameter
					.equals(mysql_db_table_october_url)) {

				try {

					// this is a bridge between the php json string and java
					JSONObject json_obj = new JSONObject(result);
					// json used the name/value pair, & pass in the name of the
					// json array in the getjsonarray parameter
					JSONArray json_array = json_obj.getJSONArray("october");

					//System.out.println("Verify the jsonarray: "
						//	+ json_array.toString());

					// can put these intialization in the intializer methods
					// cause there i would not have access to jsonarray.length
					// intialize the array array before setting it equal to
					// jsonarray
					october_title_array = new String[json_array.length()];
					october_opening_array = new String[json_array.length()];
					october_genre_array = new String[json_array.length()];
					october_director_array = new String[json_array.length()];
					october_cast_array = new String[json_array.length()];

					// convert json array into java array & (get the all the
					// values of name "title")
					for (int i = 0; i < json_array.length(); i++) {
						october_title_array[i] = json_array.getJSONObject(i)
								.getString("title").toString();

						//System.out.println("Verify the october_title_array: "
							//	+ october_title_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						october_opening_array[i] = json_array.getJSONObject(i)
								.getString("opening").toString();

						//System.out.println("Verify the october_opening_array: "
							//	+ october_opening_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						october_genre_array[i] = json_array.getJSONObject(i)
								.getString("genre").toString();

						//System.out.println("Verify the october_genre_array: "
							//	+ october_genre_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						october_director_array[i] = json_array.getJSONObject(i)
								.getString("director").toString();

						//System.out.println("Verify the october_director_array: "
							//	+ october_director_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						october_cast_array[i] = json_array.getJSONObject(i)
								.getString("cast").toString();

						//System.out.println("Verify the october_cast_array: "
							//	+ october_cast_array[i]);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (params_String_parameter
					.equals(mysql_db_table_november_url)) {

				try {

					// this is a bridge between the php json string and java
					JSONObject json_obj = new JSONObject(result);
					// json used the name/value pair, & pass in the name of the
					// json array in the getjsonarray parameter
					JSONArray json_array = json_obj.getJSONArray("november");

					//System.out.println("Verify the jsonarray: "
						//	+ json_array.toString());

					// can put these intialization in the intializer methods
					// cause there i would not have access to jsonarray.length
					// intialize the array array before setting it equal to
					// jsonarray
					november_title_array = new String[json_array.length()];
					november_opening_array = new String[json_array.length()];
					november_genre_array = new String[json_array.length()];
					november_director_array = new String[json_array.length()];
					november_cast_array = new String[json_array.length()];

					// convert json array into java array & (get the all the
					// values of name "title")
					for (int i = 0; i < json_array.length(); i++) {
						november_title_array[i] = json_array.getJSONObject(i)
								.getString("title").toString();

						//System.out.println("Verify the november_title_array: "
							//	+ november_title_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						november_opening_array[i] = json_array.getJSONObject(i)
								.getString("opening").toString();

						//System.out.println("Verify the november_opening_array: "
							//	+ november_opening_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						november_genre_array[i] = json_array.getJSONObject(i)
								.getString("genre").toString();

						//System.out.println("Verify the may_genre_array: "
							//	+ november_genre_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						november_director_array[i] = json_array.getJSONObject(i)
								.getString("director").toString();

						//System.out.println("Verify the may_director_array: "
							//	+ november_director_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						november_cast_array[i] = json_array.getJSONObject(i)
								.getString("cast").toString();

						//System.out.println("Verify the november_cast_array: "
							//	+ november_cast_array[i]);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (params_String_parameter
					.equals(mysql_db_table_december_url)) {

				try {

					// this is a bridge between the php json string and java
					JSONObject json_obj = new JSONObject(result);
					// json used the name/value pair, & pass in the name of the
					// json array in the getjsonarray parameter
					JSONArray json_array = json_obj.getJSONArray("december");

					//System.out.println("Verify the jsonarray: "
						//	+ json_array.toString());

					// can put these intialization in the intializer methods
					// cause there i would not have access to jsonarray.length
					// intialize the array array before setting it equal to
					// jsonarray
					december_title_array = new String[json_array.length()];
					december_opening_array = new String[json_array.length()];
					december_genre_array = new String[json_array.length()];
					december_director_array = new String[json_array.length()];
					december_cast_array = new String[json_array.length()];

					// convert json array into java array & (get the all the
					// values of name "title")
					for (int i = 0; i < json_array.length(); i++) {
						december_title_array[i] = json_array.getJSONObject(i)
								.getString("title").toString();

						//System.out.println("Verify the december_title_array: "
							//	+ december_title_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						december_opening_array[i] = json_array.getJSONObject(i)
								.getString("opening").toString();

						//System.out.println("Verify the december_opening_array: "
							//	+ december_opening_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						december_genre_array[i] = json_array.getJSONObject(i)
								.getString("genre").toString();

						//System.out.println("Verify the december_genre_array: "
							//	+ december_genre_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						december_director_array[i] = json_array.getJSONObject(i)
								.getString("director").toString();

						//System.out.println("Verify the december_director_array: "
							//	+ december_director_array[i]);
					}
					for (int i = 0; i < json_array.length(); i++) {
						december_cast_array[i] = json_array.getJSONObject(i)
								.getString("cast").toString();

						//System.out.println("Verify the december_cast_array: "
							//	+ december_cast_array[i]);
					
					
						textview_status_obj.setVisibility(View.INVISIBLE);
					
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}

		}

	}

	//listener methods for the spinner
	//THis intialize a listview class obj and set the adapter when specific spinner item is selected
	@Override
	public void onItemSelected(AdapterView<?> parent, View view,
			int position, long id) {

		switch (position) {
		case 0:
			linear_layout_obj = (LinearLayout) findViewById(R.id.fragment_main_id);
			linear_layout_obj.setBackgroundColor(Color.rgb(243, 197, 165));
			System.out.println("First/default spinner row() called");
			listview_obj.setVisibility(view.INVISIBLE);
			about_button_obj.setVisibility(view.VISIBLE);
			
			
			
			break;
		case 1:
			listview_obj.setVisibility(view.VISIBLE);
			linear_layout_obj.setBackgroundColor(Color.rgb(32, 210, 196));
			about_button_obj.setVisibility(view.INVISIBLE);
			//this class obj intialized here cause a parameter array needed to be passed to fetch 
			//each months array
			//AND cause i only want to a listview to appear on the screen when spinner items is selected 
			listview_adapter_obj_for_april = new listview_adapter_class(this, april_title_array,
					listview_april_image_array);
			listview_obj.setAdapter(listview_adapter_obj_for_april);
			System.out.println("onItemSelected() called (april listview created)");
			break;
		case 2:
			linear_layout_obj.setBackgroundColor(Color.rgb(32, 210, 196));
			listview_obj.setVisibility(view.VISIBLE);
			about_button_obj.setVisibility(view.INVISIBLE);
			
			listview_adapter_obj_for_may = new listview_adapter_class(this, may_title_array,
					listview_may_image_array);
			listview_obj.setAdapter(listview_adapter_obj_for_may);
			System.out.println("onItemSelected() called (may listview created)");
			break;
		case 3:
			linear_layout_obj.setBackgroundColor(Color.rgb(32, 210, 196));
			listview_obj.setVisibility(view.VISIBLE);
			about_button_obj.setVisibility(view.INVISIBLE);
			
			listview_adapter_obj_for_june = new listview_adapter_class(this, june_title_array,
					listview_june_image_array);
			listview_obj.setAdapter(listview_adapter_obj_for_june);
			System.out.println("onItemSelected() called (june listview created)");
			break;
		case 4:
			linear_layout_obj.setBackgroundColor(Color.rgb(32, 210, 196));
			listview_obj.setVisibility(view.VISIBLE);
			about_button_obj.setVisibility(view.INVISIBLE);
			
			listview_adapter_obj_for_july = new listview_adapter_class(this, july_title_array,
					listview_july_image_array);
			listview_obj.setAdapter(listview_adapter_obj_for_july);
			System.out.println("onItemSelected() called (july listview created)");
			break;
		case 5:
			linear_layout_obj.setBackgroundColor(Color.rgb(32, 210, 196));
			listview_obj.setVisibility(view.VISIBLE);
			about_button_obj.setVisibility(view.INVISIBLE);
			
			listview_adapter_obj_for_august = new listview_adapter_class(this, august_title_array,
					listview_august_image_array);
			listview_obj.setAdapter(listview_adapter_obj_for_august);
			System.out.println("onItemSelected() called (august listview created)");
			break;
		case 6:
			linear_layout_obj.setBackgroundColor(Color.rgb(32, 210, 196));
			listview_obj.setVisibility(view.VISIBLE);
			about_button_obj.setVisibility(view.INVISIBLE);
			
			listview_adapter_obj_for_september = new listview_adapter_class(this, september_title_array,
					listview_september_image_array);
			listview_obj.setAdapter(listview_adapter_obj_for_september);
			System.out.println("onItemSelected() called (september listview created)");
			break;
		case 7:
			linear_layout_obj.setBackgroundColor(Color.rgb(32, 210, 196));
			listview_obj.setVisibility(view.VISIBLE);
			about_button_obj.setVisibility(view.INVISIBLE);
			
			listview_adapter_obj_for_october = new listview_adapter_class(this, october_title_array,
					listview_october_image_array);
			listview_obj.setAdapter(listview_adapter_obj_for_october);
			System.out.println("onItemSelected() called (october listview created)");
			break;
		case 8:
			linear_layout_obj.setBackgroundColor(Color.rgb(32, 210, 196));
			listview_obj.setVisibility(view.VISIBLE);
			about_button_obj.setVisibility(view.INVISIBLE);
			
			listview_adapter_obj_for_november = new listview_adapter_class(this, november_title_array,
					listview_november_image_array);
			listview_obj.setAdapter(listview_adapter_obj_for_november);
			System.out.println("onItemSelected() called (november listview created)");
			break;
		case 9:
			linear_layout_obj.setBackgroundColor(Color.rgb(32, 210, 196));
			listview_obj.setVisibility(view.VISIBLE);
			about_button_obj.setVisibility(view.INVISIBLE);
			
			listview_adapter_obj_for_december = new listview_adapter_class(this, december_title_array,
					listview_december_image_array);
			listview_obj.setAdapter(listview_adapter_obj_for_december);
			System.out.println("onItemSelected() called (december listview created)");
			break;
			
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		System.out.println("onNothingSelected() called");
		
		
	}

	@Override
	public void onClick(View v) {
		if (v == about_button_obj) {
			Dialog aboutbutton_dialog_obj = new Dialog(this);
			aboutbutton_dialog_obj
					.requestWindowFeature(Window.FEATURE_NO_TITLE);
			aboutbutton_dialog_obj.setContentView(R.layout.about_layout);
			
			TextView aboutlayout_textview_obj = (TextView) aboutbutton_dialog_obj.findViewById(R.id.about_textveiw_id);
			String about_string = "Hi,\n \n The main reason I build this app was, I wanted "
					+ "to learn how to make android apps, as this is my first app ever. Learning by "
					+ "doing is the best practise, when it comes to Maths or making apps. \n \n So making "
					+ "it short, I have the app now all done, so why not share it with other movie buff out there,who would enjoy it. \n \n This is a beta or "
					+ "tester version and you can help me turn this into a proper app by giving me your "
					+ "feedback \n \n cheerssssssssssssss";
			aboutlayout_textview_obj.setText(about_string);
			aboutbutton_dialog_obj.show();

		}

	}

	
	//below this all acitivity cycle methdos
	// All the method below this, are for debugging purposes
		/** Called when the activity is about to become visible. */
		@Override
		protected void onStart() {
			super.onStart();
			System.out.println("The onStart() called");
		}

		/** Called when the activity has become visible. */
		@Override
		protected void onResume() {
			super.onResume();
			System.out.println("The onResume() called");
		}

		/** Called when another activity is taking focus. */
		@Override
		protected void onPause() {
			super.onPause();
			System.out.println("The onPause() called");
		}

		/** Called when the activity is no longer visible. */
		@Override
		protected void onStop() {
			super.onStop();
			System.out.println("The onStop() called");
		}

		/** Called just before the activity is destroyed. */
		@Override
		public void onDestroy() {
			super.onDestroy();
			System.out.println("The onDestroy() called");
		}

	

}
