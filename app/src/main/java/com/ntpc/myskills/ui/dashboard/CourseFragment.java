package com.ntpc.myskills.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ntpc.myskills.R;
import com.ntpc.myskills.databinding.FragmentCoursesBinding;

import java.util.ArrayList;
import java.util.List;

public class CourseFragment extends Fragment {

    private FragmentCoursesBinding binding;
    ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CourseViewModel courseViewModel =
                new ViewModelProvider(this).get(CourseViewModel.class);

        binding = FragmentCoursesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        listView = root.findViewById(R.id.list_view);

        ArrayList<String> testData = new ArrayList<>();
        testData.add("1");
        testData.add("2");
        testData.add("3");
        testData.add("4");
        testData.add("5");
        testData.add("6");
        testData.add("7");
        testData.add("8");
        testData.add("9");
        testData.add("10");
        testData.add("11");
        testData.add("12");
        testData.add("13");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, testData);
        listView.setAdapter(adapter);



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}