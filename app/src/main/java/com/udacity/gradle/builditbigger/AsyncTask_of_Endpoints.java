package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;


import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;


class AsyncTask_of_Endpoints extends AsyncTask<Void, Void, String> {


    private static MyApi myApi = null;

    private OnCompleteListener completeListener;

    public AsyncTask_of_Endpoints(OnCompleteListener onCompleteListener) {
        this.completeListener = onCompleteListener;
    }

    public AsyncTask_of_Endpoints() {

    }

    @Override
    protected String doInBackground(Void... voids) {
        if (myApi == null) {

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });


            myApi = builder.build();
        }

        try {
            return myApi.getTheJoke().execute().getData();
        } catch (IOException e) {
            Log.i("Error Retrieving Jokes", e.getMessage());
            return null;        }
    }

    @Override
    protected void onPostExecute(String result) {

        completeListener.onComplete(result);
    }


    public void setOnCompleteListener(OnCompleteListener mOnCompleteListener) {

        this.completeListener = mOnCompleteListener;
    }

    public interface OnCompleteListener {

        void onComplete(String joke);
    }
}
