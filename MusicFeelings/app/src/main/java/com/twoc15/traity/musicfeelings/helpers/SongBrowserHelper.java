package com.twoc15.traity.musicfeelings.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface SongBrowserHelper {

    public abstract ArrayList<HashMap<String, String>> getPlayList(String tag);

    public abstract void setPlayList(String tag, List<String> songsList);

}
