package com.udacity.gradle.builditbigger;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import androidx.test.runner.AndroidJUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


@RunWith(AndroidJUnit4.class)

public class Test_Of_AsyncTask {

    @Test
    public void verifyAsyncTaskResult() {

        AsyncTask_of_Endpoints asyncTaskOfEndpoints = new AsyncTask_of_Endpoints(new AsyncTask_of_Endpoints.OnCompleteListener() {
            @Override
            public void onComplete(String joke) {

            }
        });
        String joke = null;
        try {

            joke = asyncTaskOfEndpoints.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Assert.fail();

        } catch (ExecutionException e) {
            e.printStackTrace();
            Assert.fail();
        }

        assertNotNull(joke);
        assertFalse(joke.isEmpty());

    }
}
