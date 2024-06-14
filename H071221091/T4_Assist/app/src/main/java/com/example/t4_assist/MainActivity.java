package com.example.t4_assist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.t4_assist.fragment.HomeFragment;
import com.example.t4_assist.fragment.PostinganFragment;
import com.example.t4_assist.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView iv_Home = findViewById(R.id.IV_Home);
        ImageView iv_Postingan = findViewById(R.id.IV_Post);
        ImageView iv_Profile = findViewById(R.id.IV_Profile);


        FragmentManager fragmentManager = getSupportFragmentManager();

        HomeFragment homeFragment = new HomeFragment();

        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());


        if (!(fragment instanceof HomeFragment)){
            iv_Home.setImageResource(R.drawable.homeberubahwarna);
            iv_Profile.setImageResource(R.drawable.baseline_account_circle_24);
            iv_Postingan.setImageResource(R.drawable.baseline_camera_alt_24);
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, homeFragment)
                    .commit();
        }

        iv_Postingan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_Postingan.setImageResource(R.drawable.postingberubahwarna);
                iv_Profile.setImageResource(R.drawable.baseline_account_circle_24);
                iv_Home.setImageResource(R.drawable.baseline_home_24);

                PostinganFragment postinganFragment = new PostinganFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, postinganFragment)
                        .commit();
            }
        });

        iv_Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_Profile.setImageResource(R.drawable.profileberubahwarna);
                iv_Home.setImageResource(R.drawable.baseline_home_24);
                iv_Postingan.setImageResource(R.drawable.baseline_camera_alt_24);
                ProfileFragment profileFragment = new ProfileFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, profileFragment)
                        .commit();
            }
        });

        iv_Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iv_Home.setImageResource(R.drawable.homeberubahwarna);
                iv_Profile.setImageResource(R.drawable.baseline_account_circle_24);
                iv_Postingan.setImageResource(R.drawable.baseline_camera_alt_24);

                HomeFragment homeFragment = new HomeFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, homeFragment)
                        .commit();
            }
        });


    }


}