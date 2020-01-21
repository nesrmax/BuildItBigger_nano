package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.view_of_joke.Activity_of_the_joke;


public class MainActivity extends AppCompatActivity {

    AsyncTask_of_Endpoints AsyncTask_Of_Endpoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tell_me_a_Joke(View view) {
        AsyncTask_Of_Endpoints = new AsyncTask_of_Endpoints();

        AsyncTask_Of_Endpoints.setOnCompleteListener(new AsyncTask_of_Endpoints.OnCompleteListener() {
            @Override
            public void onComplete(String joke) {

                Intent intent = new Intent(MainActivity.this, Activity_of_the_joke.class);

                intent.putExtra(Activity_of_the_joke.JOKE, joke);

                startActivity(intent);
            }
        });

        AsyncTask_Of_Endpoints.execute();
    }


}
