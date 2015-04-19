package com.twoc15.traity.musicfeelings;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.twoc15.traity.musicfeelings.dialogs.DirectoryChooserDialog;


public class ModifyTag extends ActionBarActivity
        implements DirectoryChooserDialog.ChosenDirectoryListener{

    private DirectoryChooserDialog directoryChooserDialog;
    private String filePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_tag);
    }

    public void addSongElement (View view) {
        String tag = "";
        directoryChooserDialog.chooseDirectory();

    }

    public void onChosenDir(String path) {
        filePath = path;
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
