package com.ntpc.myskills.ui.courses;

import static androidx.fragment.app.FragmentManager.TAG;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ntpc.myskills.MainActivity;
import com.ntpc.myskills.R;
import com.ntpc.myskills.databinding.FragmentCoursesBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CourseFragment extends Fragment {

    private FragmentCoursesBinding binding;
    ListView listView;
    List<String> headerList;
    ArrayAdapter<String> adapter;
    private static final String TAG = "Button Pressed: ";

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

                if (i == 0) {
                    // Clicked Information Technology
                    Log.i(TAG, "YO!  " + root.getContext().toString());
                    startActivity(new Intent(root.getContext(), InformationTechnology.class));

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
                "National Productivity and Indsutry Innovation",
                "Community Based Non-Formal Education",
                "Apprenticeship and Trade Test", "Quality Awards",
                "NTPC Events"));
        }
    }