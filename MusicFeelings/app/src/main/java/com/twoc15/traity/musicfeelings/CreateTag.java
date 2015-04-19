package com.twoc15.traity.musicfeelings;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.twoc15.traity.musicfeelings.dialogs.DirectoryChooserDialog;


public class CreateTag extends ActionBarActivity
        implements DirectoryChooserDialog.ChosenDirectoryListener  {
    private EditText edTag;
    private DirectoryChooserDialog directoryChooserDialog;
    private String filePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tag);
        edTag = (EditText) findViewById(R.id.edTag);
        directoryChooserDialog = new DirectoryChooserDialog(this,this);
    }

    public void addSongElement (View view) {
        String tag = getTagName();
        directoryChooserDialog.chooseDirectory();

    }


    private String getTagName() {
        return edTag.getText().toString();
    }


    public void onChosenDir(String path) {
        filePath = path;
        Log.wtf("Create Path", filePath);
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
