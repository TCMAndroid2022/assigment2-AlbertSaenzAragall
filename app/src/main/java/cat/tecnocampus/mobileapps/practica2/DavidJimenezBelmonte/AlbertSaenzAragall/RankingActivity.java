package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.AppViewModel;
import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.User;

public class RankingActivity extends AppCompatActivity {

    private AppViewModel appViewModel;
    private RecyclerAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.Ranking);

        RecyclerView recyclerView = findViewById(R.id.ranking);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        setOnClickListener();
        RecyclerAdapter adapter = new RecyclerAdapter(listener);
        recyclerView.setAdapter(adapter);

        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);
        appViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapter.setUsers(users);
            }
        });
    }

    private void setOnClickListener() {
        listener = new RecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), AllGamesActivity.class);
                //intent.putExtra("nickname", aqui el nickname);
                startActivity(intent);
            }
        };
    }
}