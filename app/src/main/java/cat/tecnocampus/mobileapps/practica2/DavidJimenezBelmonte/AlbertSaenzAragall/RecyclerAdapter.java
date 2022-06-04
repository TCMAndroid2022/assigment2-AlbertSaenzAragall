package cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cat.tecnocampus.mobileapps.practica2.DavidJimenezBelmonte.AlbertSaenzAragall.RoomDDBB.Entities.User;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nickname;
        private TextView points;
        private TextView games;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nickname = itemView.findViewById(R.id.nickname);
            points = itemView.findViewById(R.id.points);
            games = itemView.findViewById(R.id.games);
        }
    }

    private List<User> users = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User currentUser = users.get(position);
        holder.nickname.setText(currentUser.getNickname());
        holder.points.setText(String.valueOf(currentUser.getPoints()));
        holder.games.setText(String.valueOf(currentUser.getGames()));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }
}
