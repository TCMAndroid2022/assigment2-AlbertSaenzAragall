package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.AppViewModel;

public class MainActivity extends AppCompatActivity {

    /*TextView textView;
    RequestQueue requestQueue;
    private static final String url = "https://palabras-aleatorias-public-api.herokuapp.com/random";
    private String word;*/

    private EditText editText;
    private Button playButton;
    private AppViewModel appViewModel;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.Login);

        editText = findViewById(R.id.enter_nickname);
        playButton = findViewById(R.id.play_button);

    }

    public void enterNickname(View view) {
        String nickname = editText.getText().toString();

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("nickname", nickname);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.Test);

        requestQueue = Volley.newRequestQueue(this);

        getApiWord();
    }

    private void getApiWord(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String word = response.getJSONObject("body").getString("Word");
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
        //ONDestroy reventarse la bbdd tmbn*/
}