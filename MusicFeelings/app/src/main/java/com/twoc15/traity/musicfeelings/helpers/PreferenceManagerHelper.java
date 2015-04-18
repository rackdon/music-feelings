/**
 * 
 */
package com.twoc15.traity.musicfeelings.helpers;


/**
 * @author omanrique
 *
 */
public interface PreferenceManagerHelper {

	/**
	 * This method return the value of preference
	 * 
	 * @param  theKey
	 * @return String value
	 * 
	 */
	public abstract String getPreferenceValue(String theKey);

	/**
	 * This method update the value of preference
	 * 
	 * @param  theKey
	 * @param theValue
	 * 
	 * 
	 */
	public abstract void updatePreferenceValue(String theKey, String theValue);

	/**
	 * This method update the value of preference on float format
	 * 
	 * @param theKey
	 * @param theValue
	 * 
	 * 
	 */
	public abstract void updatePreferenceValueFloat(String theKey, float theValue);

	/**
	 * This method update the value of preference on float format
	 *
	 * @param theKey
	 * @param theValue
	 *
	 * 
	 */
	public abstract void updatePreferenceValueLong(String theKey, long theValue);

	/**
	 * This method update the value of preference on float format
	 *
	 * @param theKey
	 * @param theValue
	 * 
	 * 
	 */
	public abstract void updatePreferenceValueInt(String theKey, int theValue);

	/**
	 * This method return the value of preference
	 *
	 * @param theKey
	 * @return float value
	 * 
	 */
	public abstract float getPreferenceValueFloat(String theKey);

	/**
	 * This method return the value of preference
	 * 
	 * @param  theKey
	 * @return long value
	 * 
	 */
	public abstract long getPreferenceValueLong(String theKey);
	
	/**
	 * This method return the value of preference
	 * 
	 * @param  theKey
	 * @return Integer value
	 * 
	 */
	public abstract int getPreferenceValueInt(String theKey);
	
}
