package com.twoc15.traity.musicfeelings.helpers;

import android.os.Environment;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SongBrowserHelperImp implements SongBrowserHelper {

    final String MEDIA_PATH = Environment.getExternalStorageDirectory().getPath() + "/";

    private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    private String mp3Pattern = ".mp3";

    @Override
    public ArrayList<HashMap<String, String>> getPlayList(String tag) {
        if (MEDIA_PATH != null) {
            File home = new File(MEDIA_PATH);
            File[] listFiles = home.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        scanDirectory(file, tag);
                    } else {
                        addSongToList(file, tag);
                    }
                }
            }
        }
        // return songs list array
        return songsList;
    }

    @Override
    public void setPlayList(String tag, List<String> songsList) {

        try {
            for(String songSingle : songsList){
                Mp3File mp3file = new Mp3File(songSingle);
                ID3v1 id3v1Tag =  mp3file.getId3v1Tag();

                id3v1Tag.setAlbum(tag);

                mp3file.save(Environment.getExternalStorageDirectory().getPath() + "/" + mp3file.getFilename());
            }

        } catch (IOException e) {

        } catch (UnsupportedTagException e) {

        } catch (InvalidDataException e) {

        } catch (NotSupportedException e) {

        }

    }

    private void scanDirectory(File directory, String tag) {
        if (directory != null) {
            File[] listFiles = directory.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        scanDirectory(file, tag);
                    } else {
                        addSongToList(file, tag);
                    }

                }
            }
        }
    }

    private void addSongToList(File song, String tag) {
        if (song.getName().endsWith(mp3Pattern)) {
            try {
                Mp3File mp3file = new Mp3File(song.getAbsolutePath());
                if (mp3file.hasId3v1Tag()) {
                    ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                    if(id3v1Tag.getAlbum()!=null && id3v1Tag.getAlbum().equalsIgnoreCase(tag)){
                        HashMap<String, String> songMap = new HashMap<String, String>();

                        songMap.put("songTitle", song.getName().substring(0, (song.getName().length() - 4)));
                        songMap.put("songPath", song.getPath());

                        // Adding each song to SongList
                        songsList.add(songMap);
                    }
                }
            } catch (IOException e) {

            } catch (UnsupportedTagException e) {

            } catch (InvalidDataException e) {

            }
        }
    }
    /**
     * Class to filter files which are having .mp3 extension
     * */
    class FileExtensionFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            return (name.endsWith(".mp3") || name.endsWith(".MP3"));
        }
    }


}
