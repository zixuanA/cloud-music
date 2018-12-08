package com.example;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SongSheetAdapter extends RecyclerView.Adapter {
    private List<Song> mSong;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView sheetImage = null;
        TextView songName = null;
        TextView soneNumber = null;

        public ViewHolder(View view){
            super(view);
            sheetImage=(ImageView) view.findViewById(R.id.img_song_sheet);
            songName=(TextView) view.findViewById(R.id.tex_song_sheet);
            soneNumber=(TextView) view.findViewById(R.id.tex_song_number);
        }
    }
    public SongSheetAdapter(List<Song> songList){
        mSong = songList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.song_sheet_item,viewGroup,false);
        ViewHolder holder = new ViewHolder((view));
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Song song = mSong.get(i);
        ((ViewHolder)viewHolder).sheetImage.setImageResource(song.getImageId());
        ((ViewHolder)viewHolder).songName.setText(song.getName());
        ((ViewHolder)viewHolder).soneNumber.setText(song.getNumber());
    }

    @Override
    public int getItemCount() {
        return mSong.size();
    }
}
