package com.ntpc.myskills.ui.courses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.ntpc.myskills.R;
import com.ntpc.myskills.databinding.ActivityInformationTechnologyBinding;
import com.ntpc.myskills.databinding.ActivityMainBinding;

import java.util.Objects;

public class InformationTechnology extends AppCompatActivity {

    private ActivityInformationTechnologyBinding binding;
    private static final String TAG = "InformationTechnology: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_technology);

        binding = ActivityInformationTechnologyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Sets the Title for the Action Bar
        Objects.requireNonNull(getSupportActionBar()).setTitle("Information Technology");

        // Shows the back button in the Action Bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /* This event will ensure that when the back button is pressed, it returns the user to the
    courses page */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}