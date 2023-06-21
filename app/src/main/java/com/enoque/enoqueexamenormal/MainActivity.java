package com.enoque.enoqueexamenormal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

import com.enoque.enoqueexamenormal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);


        binding.btnSave.setOnClickListener(v -> {
            save();
        });

        binding.btnList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListCandidates.class);
            startActivity(intent);
        });
    }

    private void save() {

        String name = binding.txtName.getText().toString();
        int age = Integer.parseInt(binding.txtAge.getText().toString());
        int contact = Integer.parseInt(binding.txtContact.getText().toString());
        String address = binding.txtAdress.getText().toString();
        String bi = binding.txtBI.getText().toString();


        int radioButtonTypeCategoryId = binding.radioGroupTypeCategory.getCheckedRadioButtonId();
        int radioButtonTypeId = binding.radioGroupType.getCheckedRadioButtonId();

        RadioButton radioButtonTypeCategory = findViewById(radioButtonTypeCategoryId);
        RadioButton radioButtonType = findViewById(radioButtonTypeId);

        String typeCategory = radioButtonTypeCategory.getText().toString();
        String type = radioButtonType.getText().toString();

        databaseHelper.save(name, typeCategory, type, bi, age, address, contact);

        Toast.makeText(this, "Candidato salvo com sucesso salvo com sucesso!", Toast.LENGTH_SHORT).show();
    }

    public void clearFields() {

    }
}


