package com.csit.hospitalityhub;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import logindb.LoginDbHelper;
import logindb.login;


public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        LoginDbHelper dbh=new LoginDbHelper();
        TextView Lregister=view.findViewById(R.id.login_register_button);

        Lregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((com.csit.hospitalityhub.MainActivity)getActivity()).LoadFragment(new com.csit.hospitalityhub.RegisterFragment(),false);
            }
        });

        EditText Email=view.findViewById(R.id.loginemail);
        EditText Password =view.findViewById(R.id.loginPassword);

        Button login=view.findViewById(R.id.loginbutton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(dbh.getPasswordByEmail(Email.getText().toString())!=null){
                        if(dbh.getPasswordByEmail(Email.getText().toString())==Password.getText().toString()){
                            Intent intent = new Intent((com.csit.hospitalityhub.MainActivity) getActivity(), com.csit.hospitalityhub.HandilingActivity.class);
                            startActivity(intent);
                        }
                    }
                }

        });
        return view;
    }
}