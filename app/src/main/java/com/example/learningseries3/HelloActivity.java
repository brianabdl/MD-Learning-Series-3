package com.example.learningseries3;

import static com.example.learningseries3.LoginFragment.ARG_USERNAME;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("HelloActivity", "onCreate");
        setContentView(R.layout.activity_hello);

        if (getIntent().hasExtra(ARG_USERNAME)) {
            String username = getIntent().getStringExtra(ARG_USERNAME);
            HelloFragment helloFragment = HelloFragment.newInstance(username);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFragment2, helloFragment)
                    .commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("HelloActivity", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("HelloActivity", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("HelloActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("HelloActivity", "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("HelloActivity", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("HelloActivity", "onStop");
    }
}