package org.imdragon.lookup;

import android.graphics.Movie;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Place> places;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.cardsList);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        setup();
        setAdapter();

    }

    private void setup() {
        places = new ArrayList<>();
        places.add(new Place("Santa Barbara Beach", "beach, awesome, romantic", R.drawable.sbbeach));
        places.add(new Place("SB Courthouse", "downtown, historic, tourist", R.drawable.courthouse));
        places.add(new Place("Tunnel Trail", "hiking, healthy, photos", R.drawable.tunneltrail));
    }

    public void getResponse(View v){
        new getResponse().execute(null,null,null);
    }

    private void setAdapter() {
        RAdapter mAdapter = new RAdapter(this, places);
        mRecyclerView.setAdapter(mAdapter);
    }
}

class getResponse extends AsyncTask<Void, Void, Void> {
    StringBuilder total = new StringBuilder();
    JSONObject response;

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected Void doInBackground(Void... params) {

        try {
            URL url = new URL("http://128.111.84.234/users/sign_in");
//            URL url = new URL("http://www.edhat.com");

            // making url request and sending it to be read
            Log.e("my url is", String.valueOf(url));
            HttpURLConnection connection = null;

            connection = (HttpURLConnection) url.openConnection();

            // preparing a reader to go through the response
            BufferedReader r = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // below allows for controlled reading of potentially large text
            String line;

            while ((line = r.readLine()) != null) {

                total.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("response", total.toString());
        return null;
    }


}

