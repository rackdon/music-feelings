package com.twoc15.traity.musicfeelings.helpers;

import java.lang.ref.WeakReference;
import android.os.AsyncTask;

public abstract class AsyncTaskMW<I, O, T> extends AsyncTask<Void, Void, O> {
	protected final WeakReference<T> targetRef;
	protected I input;
 
	public AsyncTaskMW(I input, T target) {
		this.input = input;
		targetRef = new WeakReference<T>(target);
	}
 
	@Override
	protected O doInBackground(Void... args) {
		return process(input);
	}
 
	protected abstract O process(I input);
 
	@Override
	protected void onPostExecute(O output) {
		final T target = targetRef.get();
		if (target != null)
			applyOutputToTarget(output, target);
	}
 
	protected abstract void applyOutputToTarget(O output, T target);
}
