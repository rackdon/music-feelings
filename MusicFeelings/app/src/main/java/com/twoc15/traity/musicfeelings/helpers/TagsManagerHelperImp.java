package com.twoc15.traity.musicfeelings.helpers;

import android.content.Context;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omar on 19/04/15.
 */
public class TagsManagerHelperImp implements TagsManagerHelper {
    private static TagsManagerHelperImp instance = null;

    private TagsManagerHelperImp(){
    }

    public static synchronized TagsManagerHelperImp getInstance() {
        if (instance==null){
            instance = new TagsManagerHelperImp();
        }
        return instance;
    }

    @Override
    public List<String> retrieveTags(Context context) {
        List<String> lista = new ArrayList<String>();
        StringBuffer stringTags = new StringBuffer(PreferenceManagerHelperImp.getInstance(context).getPreferenceValue(Constants.STR_PREF_TAGS));

        if(stringTags==null)
            return null;
        if(stringTags.toString() == null || stringTags.toString().split(",").length==0)
            return lista;

        String[] strArray = stringTags.toString().split(",");
        int largo = strArray.length;
        for(int i=0;i<largo;i++){
            lista.add(strArray[i]);
        }
        return lista;
    }

    @Override
    public void savedTags(Context context, List<String> tags) {
        StringBuffer strTags = new StringBuffer();

        for(String strTag : tags){
            strTags.append(strTag);
        }

        PreferenceManagerHelperImp.getInstance(context).updatePreferenceValue(Constants.STR_PREF_TAGS, strTags.toString());
    }
}
