package com.ababqq.motov_test_android.feature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ababqq.motov_test_android.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}