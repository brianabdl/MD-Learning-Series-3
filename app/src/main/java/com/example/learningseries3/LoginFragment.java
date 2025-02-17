package com.example.learningseries3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    public static final String ARG_USERNAME = "username";
    public static final String ARG_PASSWORD = "password";

    private String mUsername;
    private String mPassword;

    public LoginFragment() {}

    public static LoginFragment newInstance(String username, String password) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USERNAME, username);
        args.putString(ARG_PASSWORD, password);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUsername = getArguments().getString(ARG_USERNAME);
            mPassword = getArguments().getString(ARG_PASSWORD);
        }
    }

    boolean isLoginValid(@NonNull String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set the username and password to the TextView
        TextView username = view.findViewById(R.id.username);
        TextView password = view.findViewById(R.id.password);

        if (mUsername != null) {
            username.setText(mUsername);
        }

        if (mPassword != null) {
            password.setText(mPassword);
        }

        view.findViewById(R.id.btnLogin).setOnClickListener(v -> {
            mUsername = username.getText().toString();
            mPassword = password.getText().toString();

            if (isLoginValid(mUsername, mPassword)) {
                HelloFragment helloFragment = HelloFragment.newInstance(mUsername);
                ((MainActivity) requireActivity()).replaceFragment(helloFragment);
            } else {
                Toast.makeText(getContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

}