package com.newzreadrapp.newzreadr;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

public class SettingsPage extends PreferenceActivity{
	 private static final String TAG = SettingsPage.class.getSimpleName();
	 
	public void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
		PreferenceManager.setDefaultValues(this, R.layout.settings, false);
        addPreferencesFromResource(R.layout.settings);
        findPreference("notificationsKey").setOnPreferenceClickListener(mOnPreferenceClickListener);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
	}
	protected void onStart() {
        super.onStart();
        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(mOnSharedPreferenceChangeListener);
    }

    @Override
    protected void onStop() {
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(mOnSharedPreferenceChangeListener);
        super.onStop();
    }

    private OnSharedPreferenceChangeListener mOnSharedPreferenceChangeListener = new OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            Toast.makeText(SettingsPage.this, String.valueOf(sharedPreferences.getBoolean(key, false)), Toast.LENGTH_SHORT).show();
        }
    };

    private OnPreferenceClickListener mOnPreferenceClickListener = new OnPreferenceClickListener() {
        @Override
        public boolean onPreferenceClick(Preference preference) {
            Log.d(TAG, "onPreferenceClick");
            return true;
        }
    };
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        // Respond to the action bar's Up/Home button
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
	
