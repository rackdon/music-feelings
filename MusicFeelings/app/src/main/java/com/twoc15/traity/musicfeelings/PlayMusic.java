package com.twoc15.traity.musicfeelings;

import android.app.SearchManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.twoc15.traity.musicfeelings.adapters.TagsAdapter;
import com.twoc15.traity.musicfeelings.helpers.Constants;
import com.twoc15.traity.musicfeelings.helpers.TagsManagerHelperImp;

import java.util.List;


public class PlayMusic extends ActionBarActivity {
    private TagsAdapter adapter = null;
    private ListView lista;
    private MediaPlayer mMediaPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        Log.d(Constants.STR_LOG_TAG, "start new");

        lista = (ListView) findViewById(R.id.listView);

        List<String> listaTag = TagsManagerHelperImp.getInstance().retrieveTags(getApplicationContext());

        adapter = new TagsAdapter(getApplicationContext(), R.layout.tag_item, listaTag, false);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textViewItem = (TextView) view.findViewById(R.id.textTag);
                StringBuffer tagText = new StringBuffer(textViewItem.getText());

                Log.d(Constants.STR_LOG_TAG, new StringBuffer("Item is: ").append(position).append(" - ").append(textViewItem.getText()).toString());

                Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS, MediaStore.Audio.Albums.ENTRY_CONTENT_TYPE);
                intent.putExtra(SearchManager.QUERY, tagText.toString());

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        /**
         *
         Intent intent = new Intent();
         intent.setAction(android.content.Intent.ACTION_VIEW);
         File file = new File("/sdcard/test.mp3");
         intent.setDataAndType(Uri.fromFile(file), "audio/*");
         startActivity(intent);
         *
         */

        /**
         *
         String tagsStr = PreferenceManagerHelperImp.getInstance(this).getPreferenceValue(Constants.STR_PREF_TAGS);

         new AsyncTaskMW<String, ArrayAdapter<String>, ListView>("pepe, luis, ian", lista) {

        @Override
        protected ArrayAdapter<String> process(String path) {
        Log.d(Constants.STR_LOG_TAG, "start task");
        adapter1 = new ArrayAdapter<String>(getApplicationContext(), R.layout.tag_item, path.split(","));
        adapter1.setNotifyOnChange(true);
        return adapter1;
        }

        @Override
        protected void applyOutputToTarget(ArrayAdapter<String> result, ListView target) {
        Log.d(Constants.STR_LOG_TAG, "end task");
        target.setAdapter(result);
        }
        }.execute();
         */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play_music, menu);
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

