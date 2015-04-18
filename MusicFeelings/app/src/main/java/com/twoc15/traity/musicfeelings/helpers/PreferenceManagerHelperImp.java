/**
 * 
 */
package com.twoc15.traity.musicfeelings.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * @author omanrique
 *
 */
public class PreferenceManagerHelperImp implements PreferenceManagerHelper {
	private static PreferenceManagerHelperImp instance = null;
	private static SharedPreferences preferences = null;
	
	private PreferenceManagerHelperImp(){
	}

	private PreferenceManagerHelperImp(Context context){
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
	}

	public static synchronized PreferenceManagerHelperImp getInstance(Context context) {
		if (instance==null){
			instance = new PreferenceManagerHelperImp(context);
		}
		return instance;
	}

	/* (non-Javadoc)
	 * @see com.manriqueweb.android.cxc.services.PreferenceManagerServices#getPreferenceValue(android.content.Context, java.lang.String)
	 */
	public String getPreferenceValue(String theKey) {
		return preferences.getString(theKey, Constants.STRING_NOTAVAILABLE);
	}

	public float getPreferenceValueFloat(String theKey) {
		return preferences.getFloat(theKey, Float.MIN_VALUE);
	}

	public long getPreferenceValueLong(String theKey) {
		return preferences.getLong(theKey, Long.MIN_VALUE);
	}
	
	public int getPreferenceValueInt(String theKey) {
		return preferences.getInt(theKey, Integer.MIN_VALUE);
	}

	/* (non-Javadoc)
	 * @see com.manriqueweb.android.cxc.services.PreferenceManagerServices#updatePreferenceValue(android.content.Context, java.lang.String, java.lang.String)
	 */
	public void updatePreferenceValue(String theKey, String theValue) {
		Editor edit = preferences.edit();
		edit.putString(theKey, theValue);
		edit.commit();
	}

	public void updatePreferenceValueFloat(String theKey, float theValue) {
		Editor edit = preferences.edit();
		edit.putFloat(theKey, theValue);
		edit.commit();
	}

	public void updatePreferenceValueLong(String theKey, long theValue) {
		Editor edit = preferences.edit();
		edit.putLong(theKey, theValue);
		edit.commit();
	}
	
	public void updatePreferenceValueInt(String theKey, int theValue) {
		Editor edit = preferences.edit();
		edit.putInt(theKey, theValue);
		edit.commit();
	}
}
