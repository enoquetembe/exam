package com.enoque.enoqueexamenormal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CandidateAdapter extends BaseAdapter {

    ArrayList<Candidate> candidates = new ArrayList<>();
    Context context;
    LayoutInflater inflater;

    public CandidateAdapter(ArrayList<Candidate> candidates, Context context) {
        this.candidates = candidates;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return candidates.size();
    }

    @Override
    public Object getItem(int position) {
        return candidates.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.candidate_item, null);
        TextView textView_name = convertView.findViewById(R.id.textView_name);

        textView_name.setText(candidates.get(position).getName());


        return convertView;
    }



}
