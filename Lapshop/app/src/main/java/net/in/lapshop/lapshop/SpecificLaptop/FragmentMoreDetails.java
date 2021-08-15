package net.in.lapshop.lapshop.SpecificLaptop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.in.lapshop.lapshop.R;

public class FragmentMoreDetails extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_more_details, container, false);

        return rootView; }

    public FragmentMoreDetails() {
    }
}
