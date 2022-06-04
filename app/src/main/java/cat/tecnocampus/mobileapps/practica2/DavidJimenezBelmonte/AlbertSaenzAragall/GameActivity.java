package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class GameActivity extends AppCompatActivity {

    TextView textView;
    RequestQueue requestQueue;
    private static final String url = "https://palabras-aleatorias-public-api.herokuapp.com/random";
    private String word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textView = findViewById(R.id.Test);

        requestQueue = Volley.newRequestQueue(this);

        getApiWord();
    }

    private void getApiWord(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    word = response.getJSONObject("body").getString("Word");
                    textView.setText(word);
                } catch (Exception ex) {
                    Log.d("SwA", "Error parsing json array");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("SwA", "Error in request");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.ranking_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void checkRanking(MenuItem item){
        Intent intent = new Intent(this, RankingActivity.class);
        startActivity(intent);

    }
}