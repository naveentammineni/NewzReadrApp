package com.newzreadrapp.newzreadr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.newzreadrapp.newzreadr.Utils.LoadJSONFromAssets;

import android.R.string;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class CustomDialog implements OnClickListener{
	
	private String PAPER="";
	Context context;
	
	public CustomDialog(Context context){
		this.context = context;
	}	
	
	@Override
	public void onClick(View v) {
		JSONObject paperjson;
		
		String[] subcategories = null;
		ImageButton button = (ImageButton)v;
		final Dialog dialog = new Dialog(context);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.customdialog);
		ListView categoryList = (ListView)dialog.findViewById(R.id.categorylist);
	
		//Reading the button source and modifying the Custom Dialog for it.
		if(button.getId() == R.id.eenaduButton){
		
			//Recieving the json file from the server to read the subcategories for this paper
			/*
			 * Server connection and json request goes here. 
			 */
			PAPER = "eenadu";
			try{
				LoadJSONFromAssets loadjson = new LoadJSONFromAssets(context);
				paperjson = loadjson.loadJSONFromAsset("eenadu.json");
				final ArrayList<String> list = new ArrayList<String>();
				//eenadujson.
				JSONObject jsonObject = paperjson.getJSONObject("eenadu");
				Iterator iterator = jsonObject.keys();
				while(iterator.hasNext()){
					 list.add(jsonObject.getString(iterator.next().toString()));
				}
				 final StableArrayAdapter adapter = new StableArrayAdapter(this.context,
					        android.R.layout.simple_list_item_1, list);
				 categoryList.setAdapter(adapter);
			}
			catch(JSONException e){
				e.printStackTrace();
			}
		}
		else if(button.getId() == R.id.toiButton){
			
			//Recieving the json file from the server to read the subcategories for this paper
			/*
			 * Server connection and json request goes here. 
			 */
			PAPER = "toi";
			try{
				LoadJSONFromAssets loadjson = new LoadJSONFromAssets(context);
				paperjson = loadjson.loadJSONFromAsset("toi.json");
				final ArrayList<String> list = new ArrayList<String>();
				//eenadujson.
				JSONObject jsonObject = paperjson.getJSONObject("toi");
				Iterator iterator = jsonObject.keys();
				while(iterator.hasNext()){
					 list.add(jsonObject.getString(iterator.next().toString()));
				}
				 final StableArrayAdapter adapter = new StableArrayAdapter(this.context,
					        android.R.layout.simple_list_item_1, list);
				 categoryList.setAdapter(adapter);
				 
			}
			catch(JSONException e){
				e.printStackTrace();
			}
		}
		else if(button.getId() == R.id.andhrajyothiButton){
			
			//Recieving the json file from the server to read the subcategories for this paper
			/*
			 * Server connection and json request goes here. 
			 */
			PAPER = "andhrajyothi";
			try{
				LoadJSONFromAssets loadjson = new LoadJSONFromAssets(context);
				paperjson = loadjson.loadJSONFromAsset("andhrajyothi.json");
				final ArrayList<String> list = new ArrayList<String>();
				//eenadujson.
				JSONObject jsonObject = paperjson.getJSONObject("andhrajyothi");
				Iterator iterator = jsonObject.keys();
				while(iterator.hasNext()){
					 list.add(jsonObject.getString(iterator.next().toString()));
				}
				 final StableArrayAdapter adapter = new StableArrayAdapter(this.context,
					        android.R.layout.simple_list_item_1, list);
				 categoryList.setAdapter(adapter);
			}
			catch(JSONException e){
				e.printStackTrace();
			}
		}
		categoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		      @Override
		      public void onItemClick(AdapterView parent, final View view,
		          int position, long id) {
		        final String item = (String) parent.getItemAtPosition(position);
		        view.animate().setDuration(200).alpha(0)
		            .withEndAction(new Runnable() {
		              @Override
		              public void run() {
		            	Intent readPaperIntent = new Intent(dialog.getContext(), PaperViewActivity.class);
		            	readPaperIntent.putExtra("mypaper.SubCatSelection", item);
		            	readPaperIntent.putExtra("mypaper", PAPER);
		            	dialog.getContext().startActivity(readPaperIntent);
		            	dialog.dismiss();
		              }
		            });
		      }
		 });
		
		dialog.show();
		dialog.getWindow().setLayout(600, 400);
	}
	
	private class StableArrayAdapter extends ArrayAdapter<String> {

	    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

	    public StableArrayAdapter(Context context, int textViewResourceId,
	        List<String> objects) {
	      super(context, textViewResourceId, objects);
	      for (int i = 0; i < objects.size(); ++i) {
	        mIdMap.put(objects.get(i), i);
	      }
	    }

	    @Override
	    public long getItemId(int position) {
	      String item = getItem(position);
	      return mIdMap.get(item);
	    }

	    @Override
	    public boolean hasStableIds() {
	      return true;
	    }

	  }
	
}
