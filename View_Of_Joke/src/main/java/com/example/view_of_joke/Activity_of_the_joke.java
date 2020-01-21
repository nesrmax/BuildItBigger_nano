package com.example.view_of_joke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity_of_the_joke extends AppCompatActivity {

    public static final String JOKE = "joke";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String this_joke = getIntent().getExtras().getString(JOKE);

        ((TextView) findViewById(R.id.jokeTextView)).setText(this_joke);
    }
}
