package com.newzreadrapp.newzreadr.Utils;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class LoadJSONFromAssets {

	Context context;
	public LoadJSONFromAssets(Context context ){
		this.context= context;
	}
	public JSONObject loadJSONFromAsset(String filename) throws JSONException {
        String json = null;
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return new JSONObject(json);

    }
}
