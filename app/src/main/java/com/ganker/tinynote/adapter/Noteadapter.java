package com.ganker.tinynote.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ganker.tinynote.R;
import com.ganker.tinynote.model.Note;

import java.util.List;

/**
 * Created by Jackson on 3/13/16.
 */
public class Noteadapter extends RecyclerView.Adapter<NoteHolder> {
    private List<Note> notes;

    public Noteadapter(List<Note> notes){
        this.notes = notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes =  notes;
    }

    @Override
    public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.note_item, parent,false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteHolder holder, int position){
        Note note = notes.get(position);
        holder.bindview(note);
    }

    @Override
    public int getItemCount(){
        return notes.size();
    }
}
