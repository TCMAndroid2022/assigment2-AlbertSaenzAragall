package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RequestQueue requestQueue;
    private static final String url = "https://palabras-aleatorias-public-api.herokuapp.com/random";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.Test);

        requestQueue = Volley.newRequestQueue(this);

        jsonRequest();
    }

    private void stringRequest() {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("SwA", "Error in request");
            }
        });
        requestQueue.add(request);
    }

    private void jsonRequest(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject body = response;
                    textView.setText(body.getString("body"));
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
        //ONDestroy reventarse la bbdd tmbn
}