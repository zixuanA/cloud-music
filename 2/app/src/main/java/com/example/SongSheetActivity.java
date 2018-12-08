package com.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SongSheetActivity extends AppCompatActivity {
    private List<Song> songList =new ArrayList<>();
    private ArrayList<String> letters = new ArrayList<>();
    private ArrayList<TreeMap> map = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_sheet);
        InputStream in = null;
        try {
            in = getResources().openRawResource(R.raw.json);
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while(true){
                String flag = null;
                flag = bufferedReader.readLine();
                if(flag!=null)
                    letters.add(flag);
                if(flag==null)
                    break;
                }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JsonReader jsonReader = new JsonReader();
            if(songList.isEmpty()) {
                map = jsonReader.toMap(letters);
               // Toast.makeText(SongSheetActivity.this,map+"",Toast.LENGTH_SHORT).show();
                for (int n = 1; n < map.size(); n++) {
                    String tip = (String) map.get(n).get("name");
                    String num = (String) map.get(n).get("num");
                    //String tip ="love song";
                    //String num ="10";
                    if (n % 2 != 0)
                        songList.add(new Song(tip, num, R.mipmap.pic_lana_del_ray));
                    if (n % 2 == 0)
                        songList.add(new Song(tip, num, R.mipmap.pic_shijie_huang));
                }
            }
            RecyclerView recyclerView = findViewById(R.id.rec_sheet);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);
            SongSheetAdapter adapter = new SongSheetAdapter(songList);
            recyclerView.setAdapter(adapter);

        }

    @Override
    protected void onPause() {
        super.onPause();
        super.onDestroy();
    }
}
