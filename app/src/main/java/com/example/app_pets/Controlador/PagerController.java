package com.example.app_pets.Controlador;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.app_pets.alarma_fragment;
import com.example.app_pets.profile_fragment;
import com.example.app_pets.vista_medFragment;

public class PagerController extends FragmentPagerAdapter {
    int numofTabs;

    public PagerController(@NonNull FragmentManager fm,int behavior) {
        super(fm,behavior);
        this.numofTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new profile_fragment();
            case 1:
                return new vista_medFragment();
            case 2:
                return new alarma_fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numofTabs;
    }
}
