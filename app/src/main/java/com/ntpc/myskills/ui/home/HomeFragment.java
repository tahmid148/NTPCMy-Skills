package com.ntpc.myskills.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ntpc.myskills.MainActivity;
import com.ntpc.myskills.R;
import com.ntpc.myskills.SharedViewModel;
import com.ntpc.myskills.databinding.FragmentHomeBinding;
import com.ntpc.myskills.ui.courses.CourseFragment;


public class HomeFragment extends Fragment {

    private static final String TAG = "Home Fragment: ";
    private SharedViewModel model;
    Button courses;
    Button enrol;
    Button calendar;
    Button contact;
    private FragmentHomeBinding binding;

    public HomeFragment() {

    }

    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView desc = root.findViewById(R.id.description);
        desc.setText("Whether you are looking for a great career, to enhance\n" +
                     " your current skills to be competitive in our local,\n" +
                     " regional, or global society, I am certain that you will \n" +
                     "find enrolling at National Training and Productivity\n" +
                     " Centre to be one of your best decisions. NTPC offers \n" +
                     "a wide range of programs including market-relevant \n" +
                     "stackable certificates, diplomas and QuickJob \n" +
                     "programs designed to help you rapidly meet your \n" +
                     "career and personal goals. You will find that NTPC \n" +
                     "offers specific training programs that translate into \n" +
                     "lifelong opportunities.");
        desc.setTextColor(Color.BLACK);

        courses = root.findViewById(R.id.view_courses_btn);
        enrol = root.findViewById(R.id.enrol_btn);
        calendar = root.findViewById(R.id.view_calendar_btn);
        contact = root.findViewById(R.id.contact_btn);

        courses.setText("View Courses");
        enrol.setText("Enrol");
        calendar.setText("View Calendar");
        contact.setText("Contact Us");

        // Set function for courses button - takes user to courses page
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "View Courses has been clicked");
//                Fragment coursePage = new CourseFragment();
//                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, coursePage);
//                fragmentTransaction.commit();
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
        
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}