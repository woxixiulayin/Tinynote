package com.ganker.tinynote.helper;

import android.content.Context;

import com.ganker.tinynote.model.Note;

import java.util.ArrayList;
/**
 * Created by Jackson on 3/13/16.
 */
public class NoteLab {
    private static NoteLab sNoteLab;
    private ArrayList<Note> notes;

    private NoteLab(Context context){
        notes = new ArrayList<Note>();

        for(int i=0; i< 200; i++) {
            Note note = new Note();
            note.setTitle("title " + i);
            note.setContent("test " + "i " + "this nothing here\n");
            notes.add(note);
        }
    }

    public static NoteLab getsNoteLab(Context context){
        if(sNoteLab == null) {
            sNoteLab = new NoteLab(context);
        }

        return sNoteLab;
    }

    public ArrayList<Note> getNotes(){
        return notes;
    }
}
