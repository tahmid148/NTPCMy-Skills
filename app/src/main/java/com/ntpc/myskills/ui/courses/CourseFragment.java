package com.ntpc.myskills.ui.courses;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void prepareMenuData() {
        headerList = new ArrayList<>(Arrays.asList(
                "Home", "Information Technology", "Executive Management",
                "Tourism, Hospitality, Fashion, and Travel", "Automotive and Mechanical",
                "Electronics and Electrical", "Construction and Marine",
                "National Productivity and Indsutry Innovation",
                "Community Based Non-Formal Education",
                "Apprenticeship and Trade Test", "Quality Awards",
                "NTPC Events"));
        }
    }