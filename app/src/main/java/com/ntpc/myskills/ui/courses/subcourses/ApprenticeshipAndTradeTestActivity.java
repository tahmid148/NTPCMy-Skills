package com.ntpc.myskills.ui.courses.subcourses;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.ntpc.myskills.R;

import java.util.Objects;

public class ApprenticeshipAndTradeTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apprenticeship_and_trade_test);

        // Sets the Title for the Action Bar
        Objects.requireNonNull(getSupportActionBar()).setTitle("Apprenticeship and Trade Test");

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