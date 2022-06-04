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

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.AppDatabase;
import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.AppViewModel;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.Login);

        editText = findViewById(R.id.enter_nickname);

    }

    public void enterNickname(View view) {
        String nickname = editText.getText().toString();

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("nickname", nickname);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}