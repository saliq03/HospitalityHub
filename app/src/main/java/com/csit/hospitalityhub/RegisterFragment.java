package com.csit.hospitalityhub;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import logindb.LoginDbHelper;
import logindb.login;


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


        EditText name =view.findViewById(R.id.name);
        EditText username =view.findViewById(R.id.User_name);
        EditText Email=view.findViewById(R.id.register_Email);
        EditText Dob=view.findViewById(R.id.user_dob);
        EditText password=view.findViewById(R.id.register_password);
        LoginDbHelperr dbh=new LoginDbHelper();

        login lg=new login(name.getText().toString(),username.getText().toString(),Email.getText().toString(),
                Dob.getText().toString(),password.getText().toString());
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText() != null && Email.getText() != null && password.getText() != null) {
                    dbh.insertUser(name.getText().toString(), username.getText().toString(), Email.getText().toString(),
                            Dob.getText().toString(), password.getText().toString());
                    ((MainActivity) getActivity()).LoadFragment(new LoginFragment(), false);
                    Toast.makeText((MainActivity) getActivity(), "Registration sucessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}