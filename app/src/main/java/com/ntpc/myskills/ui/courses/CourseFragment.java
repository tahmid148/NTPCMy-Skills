package com.ntpc.myskills.ui.courses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;

import com.ntpc.myskills.R;
import com.ntpc.myskills.SharedViewModel;
import com.ntpc.myskills.databinding.FragmentCoursesBinding;
import com.ntpc.myskills.ui.courses.subcourses.ApprenticeshipAndTradeTestActivity;
import com.ntpc.myskills.ui.courses.subcourses.AutomotiveAndMechanicalActivity;
import com.ntpc.myskills.ui.courses.subcourses.CommunityBasedNonFormalEducationActivity;
import com.ntpc.myskills.ui.courses.subcourses.ConstructionAndMarineActivity;
import com.ntpc.myskills.ui.courses.subcourses.ElectronicsandElectricalActivity;
import com.ntpc.myskills.ui.courses.subcourses.ExecutiveManagementActivity;
import com.ntpc.myskills.ui.courses.subcourses.InformationTechnologyActivity;
import com.ntpc.myskills.ui.courses.subcourses.NTPCEventsActivity;
import com.ntpc.myskills.ui.courses.subcourses.NationalProductivityAndIndustryInnovationActivity;
import com.ntpc.myskills.ui.courses.subcourses.QualityAwardsActivity;
import com.ntpc.myskills.ui.courses.subcourses.TourismHospitalityFashionAndTravelActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseFragment extends Fragment {

    private FragmentCoursesBinding binding;
    ListView listView;
    List<String> headerList;
    ArrayAdapter<String> adapter;
    private SharedViewModel model;
    private static final String TAG = "Button Pressed: ";

    public CourseFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CourseViewModel courseViewModel =
                new ViewModelProvider(this).get(CourseViewModel.class);

        binding = FragmentCoursesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listView = root.findViewById(R.id.list_view);
        prepareMenuData();
        adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, headerList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapter.getItem(i);
                Log.i(TAG, item);

                switch (i) {
                    case 0: // Information Technology
                        startActivity(new Intent(root.getContext(), InformationTechnologyActivity.class));
                        Log.i(TAG, "IT");
                        break;
                    case 1: // Executive Management
                        startActivity(new Intent(root.getContext(), ExecutiveManagementActivity.class));
                        Log.i(TAG, "EM");
                        break;
                    case 2: // Tourism, Hospitality, Fashion, and Travel
                        startActivity(new Intent(root.getContext(), TourismHospitalityFashionAndTravelActivity.class));
                        Log.i(TAG, "THFT");
                        break;
                    case 3: // Automotive and Mechanical
                        startActivity(new Intent(root.getContext(), AutomotiveAndMechanicalActivity.class));
                        Log.i(TAG, "AM");
                        break;
                    case 4: // Electronics and Electrical
                        startActivity(new Intent(root.getContext(), ElectronicsandElectricalActivity.class));
                        Log.i(TAG, "EE");
                        break;
                    case 5: // Construction and Marine
                        startActivity(new Intent(root.getContext(), ConstructionAndMarineActivity.class));
                        Log.i(TAG, "CM");
                        break;
                    case 6: // National Productivity and Industry Innovation
                        startActivity(new Intent(root.getContext(), NationalProductivityAndIndustryInnovationActivity.class));
                        Log.i(TAG, "NPII");
                        break;
                    case 7: // Community Based Non-Formal Education
                        startActivity(new Intent(root.getContext(), CommunityBasedNonFormalEducationActivity.class));
                        Log.i(TAG, "CBNFE");
                        break;
                    case 8: // Apprenticeship and Trade Test
                        startActivity(new Intent(root.getContext(), ApprenticeshipAndTradeTestActivity.class));
                        Log.i(TAG, "ATT");
                        break;
                    case 9: // NTPC Events
                        startActivity(new Intent(root.getContext(), NTPCEventsActivity.class));
                        Log.i(TAG, "NTPCE");
                        break;
                    case 10: // Quality Awards
                        startActivity(new Intent(root.getContext(), QualityAwardsActivity.class));
                        Log.i(TAG, "QA");
                        break;
                }
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void prepareMenuData() {
        headerList = new ArrayList<>(Arrays.asList(
                "Information Technology", "Executive Management",
                "Tourism, Hospitality, Fashion, and Travel", "Automotive and Mechanical",
                "Electronics and Electrical", "Construction and Marine",
                "National Productivity and Industry Innovation",
                "Community Based Non-Formal Education",
                "Apprenticeship and Trade Test", "NTPC Events", "Quality Awards"
                ));
        headerList.add("Quality Awards");
        }

}