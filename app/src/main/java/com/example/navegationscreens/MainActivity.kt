package com.example.navegationscreens;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        supportFragmentManager!!.beginTransaction()
            .add(R.id.fragmentContainer, PrincipalFragment(), "PrincipalFragment").commit();
    }
}