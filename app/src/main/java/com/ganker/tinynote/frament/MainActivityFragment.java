package com.ganker.tinynote.frament;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ganker.tinynote.R;
import com.ganker.tinynote.adapter.Noteadapter;
import com.ganker.tinynote.helper.NoteLab;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private RecyclerView noteRecycler;
    private Noteadapter noteAdapter;

    public MainActivityFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        root.findViewById(R.id.fab_edit_note).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 mListener.onFragmentInteraction(null);
            }
        });

        noteRecycler = (RecyclerView) root.findViewById(R.id.note_recycler_view);
        noteRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        NoteLab notelab = NoteLab.getsNoteLab(getActivity());
        noteAdapter = new Noteadapter(notelab.getNotes());
        noteRecycler.setAdapter(noteAdapter);
        return root;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
}
