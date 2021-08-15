package net.in.lapshop.lapshop.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.compare.SelectBrand;

public class compare extends Fragment {

    private ImageView addLaptop1,addLaptop2;
    private View rootView;
    private Button compare;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.fragment_compare, container, false);
        addLaptop1=rootView.findViewById(R.id.imageView_addLaptop);
        addLaptop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SelectBrand.class));
            }
        });
        addLaptop2=rootView.findViewById(R.id.imageView_addLaptop2);
        addLaptop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SelectBrand.class));
            }
        });
        compare=rootView.findViewById(R.id.compare);
        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return rootView;
    }
}
