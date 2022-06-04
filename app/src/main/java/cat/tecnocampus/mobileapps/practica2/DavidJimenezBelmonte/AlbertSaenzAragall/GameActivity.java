package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.text.Collator;

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.AppViewModel;
import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.User;

public class GameActivity extends AppCompatActivity {


    private TextView secretWord;
    private String[] secretWordArray;

    private TextView wordHolder;
    private TextView letter;
    private TextView letterBtn;
    private TextView solve;
    private TextView solveBtn;

    private String word;
    private String[] wordArray;

    private AppViewModel appViewModel;

    private String nickname;
    private int tries = 0;
    private boolean cont = false;

    RequestQueue requestQueue;
    private static final String url = "https://palabras-aleatorias-public-api.herokuapp.com/random";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        nickname = getIntent().getStringExtra("nickname");

        secretWord = findViewById(R.id.secret_word);
        letter = findViewById(R.id.Letter);
        letterBtn = findViewById(R.id.Letter_btn);
        solve = findViewById(R.id.Solve);
        solveBtn = findViewById(R.id.Solve_btn);
        wordHolder = findViewById(R.id.wordHolder);
        word = "";

        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);

        requestQueue = Volley.newRequestQueue(this);

        getApiWord();
    }

    private void getApiWord(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    word = response.getJSONObject("body").getString("Word");
                    initializeSecretWord();
                    wordToArray();
                    secretWord.setText(secretToString());
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

    private void initializeSecretWord(){
        secretWordArray = new String[word.length()];
        for(int i = 0; i < word.length(); i++){
            if(String.valueOf(word.charAt(i)).equals(" ")){
                secretWordArray[i] = "  ";
            }
            secretWordArray[i] = "_ ";
        }
    }

    private String secretToString(){
        String fin = "";

        for(int i = 0; i < secretWordArray.length; i++){
            fin = fin + secretWordArray[i];
        }
        return fin;
    }

    private void wordToArray(){
        wordArray = new String[word.length()];
        for(int i = 0; i < word.length(); i++){
            wordArray[i] = String.valueOf(word.charAt(i));
        }
    }

    public void checkLetter(View view) {
        System.out.println(word);
        tries++;
        String letter = this.letter.getText().toString();
        if(letter.length() == 1){
            changeWord(letter);
            secretWord.setText(secretToString());
            this.letter.setText("");
            if(isWin(secretToString())){
               double punctuation = calculatePoints();
                Toast.makeText(this, "CONGRATULATIONS, YOU WON!!", Toast.LENGTH_LONG).show();
               saveData(punctuation);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }else{
            Toast.makeText(this, "Please enter a valid parameter (only one letter)", Toast.LENGTH_SHORT).show();
        }
    }

    private void changeWord(String letter) {
        final Collator collator = Collator.getInstance();
        collator.setStrength(Collator.NO_DECOMPOSITION);
        for(int i = 0; i < wordArray.length; i++){
            if(collator.compare(wordArray[i], letter) == 0){
                secretWordArray[i] = letter;
            }
        }
    }

    public void checkSolution(View view) {
        tries++;
        String sol = solve.getText().toString();
        if(isWin(sol)){
            secretWord.setText(word);
            solve.setText("");
            double punctuation = calculatePoints();
            Toast.makeText(this, "CONGRATULATIONS, YOU WON!!", Toast.LENGTH_LONG).show();
            saveData(punctuation);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            saveData(0.0);
        }
    }
    public boolean isWin(String compare){
        if(word.equals(compare)) return true;
        return false;
    }
    private double calculatePoints(){
        return (double)(((double)word.length() - (double) tries) / (double) word.length()) * 10;
    }
    private void saveData(double punctuation){
        cont = false;
            LiveData<User> userLiveData = appViewModel.findByNickName(nickname);
            userLiveData.observe(this, new Observer<User>() {
                @Override
                public void onChanged(User user) {
                    if(!cont){
                        if(user == null){
                            appViewModel.addUser(nickname, punctuation, 1);
                            appViewModel.addGame(nickname, punctuation);
                        }else{
                            appViewModel.addUser(nickname, user.getPoints() + punctuation, user.getGames() + 1);
                            appViewModel.addGame(nickname, punctuation);
                        }
                        cont = true;
                    }
                }
            });
        }
        /*if(userLiveData == null){
            appViewModel.addUser(nickname, punctuation, 1);
            appViewModel.addGame(nickname, punctuation);
        }else{
            appViewModel.addUser(nickname, userLiveData.getPoints() + punctuation, userLiveData.getGames() + 1);
            appViewModel.addGame(nickname, punctuation);
        }*/
}