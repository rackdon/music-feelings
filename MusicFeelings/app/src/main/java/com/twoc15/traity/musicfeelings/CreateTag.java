package com.twoc15.traity.musicfeelings;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.twoc15.traity.musicfeelings.adapters.TagsAdapter;
import com.twoc15.traity.musicfeelings.dialogs.DirectoryChooserDialog;
import com.twoc15.traity.musicfeelings.helpers.SongBrowserHelperImp;
import com.twoc15.traity.musicfeelings.helpers.TagsManagerHelperImp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CreateTag extends ActionBarActivity
        implements DirectoryChooserDialog.ChosenDirectoryListener {
    private EditText edTag;
    private DirectoryChooserDialog directoryChooserDialog;
    private String filePath = "";
    private ListView listSongs = null;
    private TagsAdapter adapter = null;
    private File selectedSong = null;
    private List<String> songNames = new ArrayList<String>();
    private List<String> songPaths = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tag);
        edTag = (EditText) findViewById(R.id.edTag);
        directoryChooserDialog = new DirectoryChooserDialog(this,this);
        listSongs = (ListView) findViewById(R.id.listView);
        adapter = new  TagsAdapter(getApplicationContext() , R.layout.tag_item, songNames, true);
    }

    public void addSongElement (View view) {
        directoryChooserDialog.chooseDirectory();
    }


    public void confirm (View view) {
        String tag = getTagName();
        new SongBrowserHelperImp().setPlayList(tag, songPaths);
        Log.wtf("Path", String.valueOf(songPaths.size() ));
        List<String> tagsL = new ArrayList<String>();
        tagsL.add(tag);
        TagsManagerHelperImp.getInstance().savedTags(getApplicationContext(), tagsL);
        finish();
    }

    private String getTagName() {
        return edTag.getText().toString();
    }


    public void onChosenDir(String path, File selectedFile) {
        songPaths.add(path);
        selectedSong = selectedFile;
        songNames.add(selectedSong.getName());
        listSongs.setAdapter(adapter);
        adapter.setNotifyOnChange(true);
        Log.wtf("Path", path);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_tag, menu);
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
