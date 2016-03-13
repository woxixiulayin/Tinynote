package com.ganker.tinynote.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ganker.tinynote.R;
import com.ganker.tinynote.model.Note;

/**
 * Created by Jackson on 3/13/16.
 */
public class NoteHolder extends RecyclerView.ViewHolder {
    private TextView noteTitle;
    private TextView noteContent;

    public NoteHolder(View root){
        super(root);
        noteTitle = (TextView) root.findViewById(R.id.list_item_note_title);
        noteContent = (TextView) root.findViewById(R.id.list_item_note_content);
    }

    public void bindview(Note note) {
        noteTitle.setText(note.getTitle());
        noteContent.setText(note.getContent());
    }
}
