package net.in.lapshop.lapshop.SpecificLaptop;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Nikunj Ramani on 03/13/18.
 */

class TabPagerAdapter extends FragmentStatePagerAdapter {

    int num;

    public TabPagerAdapter(FragmentManager fm, int num) {
        super(fm);
        this.num = num;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentSpecification fragmentSpecification = new FragmentSpecification();
                return fragmentSpecification;
            case 1:
                FragmentMoreDetails fragmentMoreDetails = new FragmentMoreDetails();
                return fragmentMoreDetails;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return num;
    }
}

