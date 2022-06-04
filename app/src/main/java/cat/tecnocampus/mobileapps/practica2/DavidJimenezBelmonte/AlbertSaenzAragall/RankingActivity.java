package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import java.util.List;

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.AppViewModel;
import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.User;

public class RankingActivity extends AppCompatActivity {

    //private LiveData<List<User>> usersList;
    private AppViewModel appViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.Ranking);

        RecyclerView recyclerView = findViewById(R.id.ranking);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        RecyclerAdapter adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        appViewModel = ViewModelProviders.of(this).get(AppViewModel.class);
        appViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapter.setUsers(users);
            }
        });

        //usersList = appViewModel.getAllUsers();
    }

}