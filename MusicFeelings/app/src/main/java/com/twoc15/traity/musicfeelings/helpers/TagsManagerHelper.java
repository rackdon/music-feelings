package com.twoc15.traity.musicfeelings.helpers;

import android.content.Context;

import java.util.List;

/**
 * Created by omar on 19/04/15.
 */
public interface TagsManagerHelper {
    public abstract List<String> retrieveTags(Context context);

    public abstract void savedTags(Context context, List<String> tags);

}
