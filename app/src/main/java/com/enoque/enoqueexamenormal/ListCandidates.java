package com.enoque.enoqueexamenormal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.enoque.enoqueexamenormal.databinding.ActivityListCandidatesBinding;

import java.util.ArrayList;

public class ListCandidates extends AppCompatActivity {

    ActivityListCandidatesBinding binding;
    DatabaseHelper databaseHelper;

    ArrayList<Candidate> candidates;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(this);
        binding = ActivityListCandidatesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        candidates = databaseHelper.getTheoreticalHeavyVehicleCandidates();


        CandidateAdapter adapter = new CandidateAdapter(candidates, this);
        binding.lvCandiates.setAdapter(adapter);

        binding.lvCandiates.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                databaseHelper.delete(candidates.get(i).getId());
                Toast.makeText(ListCandidates.this, "Deletado com sucesso", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}