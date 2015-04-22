package com.twoc15.traity.musicfeelings;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.twoc15.traity.musicfeelings.adapters.TagsAdapter;
import com.twoc15.traity.musicfeelings.dialogs.DirectoryChooserDialog;
import com.twoc15.traity.musicfeelings.helpers.SongBrowserHelperImp;
import com.twoc15.traity.musicfeelings.helpers.TagsManagerHelperImp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ModifyTag extends ActionBarActivity
        implements DirectoryChooserDialog.ChosenDirectoryListener{

    private DirectoryChooserDialog directoryChooserDialog;
    private String filePath = "";
    private TagsAdapter songsAdapter = null;
    private ListView listSongs = null;
    private ArrayList<HashMap<String, String>> thePlayList;
    private List<String> songNames = new ArrayList<String>();
    private List<String> songPaths = new ArrayList<String>();
    private String listTag = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_tag);
        final List listTags = TagsManagerHelperImp.getInstance().retrieveTags(getApplicationContext());
        TagsAdapter tags = new TagsAdapter(getApplicationContext(), R.layout.tag_item, listTags, false);
        listSongs = (ListView) findViewById(R.id.listView);
        Spinner tagsSpinner = (Spinner) findViewById(R.id.tagsSpinner);
        tagsSpinner.setAdapter(tags);
        tagsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                listTag = (String) listTags.get(position);
                thePlayList = new SongBrowserHelperImp().getPlayList(listTag);
                for (HashMap<String,String> name : thePlayList) {
                    songNames.add(name.get("songTitle"));
                    songPaths.add(name.get("songPath"));
                }
                songsAdapter = new  TagsAdapter(getApplicationContext() , R.layout.tag_item,
                        songNames, true);
                listSongs.setAdapter(songsAdapter);
                directoryChooserDialog =
                        new DirectoryChooserDialog(getApplicationContext(),ModifyTag.this);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void addSongElement (View view) {
        directoryChooserDialog.chooseDirectory();

    }

    public void confirm (View view) {
        new SongBrowserHelperImp().setPlayList(listTag, songPaths);
        finish();
    }

    public void onChosenDir(String path, File selectedFile) {
        songPaths.add(path);
        File selectedSong = selectedFile;
        songNames.add(selectedSong.getName());
        listSongs.setAdapter(songsAdapter);
        songsAdapter.setNotifyOnChange(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modify_tag, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
