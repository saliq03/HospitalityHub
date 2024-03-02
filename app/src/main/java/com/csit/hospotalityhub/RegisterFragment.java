package com.csit.hospotalityhub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_register, container, false);
        Button registerbutton=view.findViewById(R.id.register_button);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).LoadFragment(new LoginFragment(),false);
                Toast.makeText((MainActivity)getActivity(), "Registration sucessful", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}