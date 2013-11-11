package com.newzreadrapp.newzreadr;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SettingsPage extends PreferenceActivity{

	public void onCreate(Bundle savedInstanceState)	{
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.settings);
	}
}
