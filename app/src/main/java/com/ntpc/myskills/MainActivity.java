package com.ntpc.myskills;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ntpc.myskills.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;
    private final static String TAG = "Main: ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.fnuheaderhd));
        actionBar.setDisplayShowTitleEnabled(false); // Removes all text from Action Bar
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.action_bar_logo, null);
        actionBar.setCustomView(v);


        Button courses = findViewById(R.id.view_courses_btn);
        Button enrol = findViewById(R.id.enrol_btn);
        Button calendar = findViewById(R.id.view_calendar_btn);
        Button contact = findViewById(R.id.contact_btn);

        courses.setText("View Courses");
        enrol.setText("Enrol");
        calendar.setText("View Calendar");
        contact.setText("Contact Us");


        // set function for view courses button
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Moves to courses page
                View coursesView = navView.findViewById(R.id.navigation_dashboard);
                coursesView.performClick();
            }
        });

        // set function for enrol button
        enrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View enrolView = navView.findViewById(R.id.navigation_notifications);
                enrolView.performClick();
            }
        });


        // set function for contact us button
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String[] to={"prity.ram@fnu.ac.fj"};
                intent.putExtra(Intent.EXTRA_EMAIL,to);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Course Enquiry");
                intent.putExtra(Intent.EXTRA_TEXT,"");
                intent.setType("message/rfc822");
                Intent chooser = Intent.createChooser(intent, "Send Email");
                startActivity(chooser);
            }
        });

    }

}