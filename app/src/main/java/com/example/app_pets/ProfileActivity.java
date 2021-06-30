package com.example.app_pets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.app_pets.Controlador.PagerController;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1,tab2,tab3;
    PagerController pagerAdapter;
    FloatingActionMenu actionMenu;
    FloatingActionButton subMenu1;
    FloatingActionButton subMenu2;

    private Button mButtonSignOut;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);

        tab1= findViewById(R.id.tabProfile);
        tab2=findViewById(R.id.tabMed);
        tab3=findViewById(R.id.tabAlarm);

        mAuth=FirebaseAuth.getInstance();
        mButtonSignOut=(Button)findViewById(R.id.btnSignout);

        actionMenu = findViewById(R.id.floatingActionMenu);
        subMenu1 = findViewById(R.id.subMenu1);
        //subMenu2 = findViewById(R.id.subMenu2);
        actionMenu.setClosedOnTouchOutside(true);

        pagerAdapter= new PagerController(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0){
                    pagerAdapter.notifyDataSetChanged();
                }
                if (tab.getPosition()==1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if (tab.getPosition()==2){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        mButtonSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
                finish();
            }
        });

        subMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,RegistroMedActivity.class));
                finish();
            }
        });

        /*subMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,AddReminderActivity.class));
                finish();
            }
        });*/
    }
}