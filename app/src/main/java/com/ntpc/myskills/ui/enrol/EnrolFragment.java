package com.ntpc.myskills.ui.enrol;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ntpc.myskills.R;
import com.ntpc.myskills.databinding.FragmentEnrolBinding;

public class EnrolFragment extends Fragment {

    private FragmentEnrolBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EnrolViewModel enrolViewModel =
                new ViewModelProvider(this).get(EnrolViewModel.class);

        binding = FragmentEnrolBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        WebView webView = root.findViewById(R.id.web_view);
        webView.loadUrl("https://crm-student.fnu.ac.fj/RecruitNewWFE/Account/Create");

//        final TextView textView = binding.textNotifications;
//        enrolViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}