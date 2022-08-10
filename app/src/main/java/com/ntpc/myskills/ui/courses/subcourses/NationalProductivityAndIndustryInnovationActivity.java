package com.ntpc.myskills.ui.courses.subcourses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.ntpc.myskills.R;

import java.util.Objects;

public class NationalProductivityAndIndustryInnovationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national_productivity_and_indsutry_innovation);
        // Sets the Title for the Action Bar
        Objects.requireNonNull(getSupportActionBar()).setTitle("National Productivity and Industry Innovation");

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