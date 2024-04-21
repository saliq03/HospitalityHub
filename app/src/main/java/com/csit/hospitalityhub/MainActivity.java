package com.csit.hospitalityhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String ROOT_FRAGMENT_TAG = "RootFragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadFragment(new LoginFragment(),true);
    }
    public void LoadFragment(Fragment fragment,boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.loginframelayout, fragment);
//        if (flag) {
//
//        }
//        else {
//            fragmentTransaction.replace(R.id.loginframelayout, fragment);
//        }
        fragmentTransaction.commit();
    }
}