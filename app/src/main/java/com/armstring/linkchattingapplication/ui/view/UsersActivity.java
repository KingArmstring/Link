package com.armstring.linkchattingapplication.ui.view;

import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.armstring.linkchattingapplication.R;
import com.armstring.linkchattingapplication.ui.view.main_view.MainActivity;
import com.armstring.linkchattingapplication.ui.view.register_view.RegisterActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class UsersActivity extends AppCompatActivity {
    private final String TAG = "Armstring";
    private RecyclerView usersList;
    private Toolbar toolbar;
    private DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        toolbar = (Toolbar)findViewById(R.id.usersToolbarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("All Users");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reference = FirebaseDatabase.getInstance().getReference().child("Users");

        usersList = (RecyclerView)findViewById(R.id.usersListId);
        usersList.setHasFixedSize(true);
        usersList.setLayoutManager(new LinearLayoutManager(UsersActivity.this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Users")
                .limitToLast(50);
        FirebaseRecyclerOptions<User> options =
                new FirebaseRecyclerOptions.Builder<User>()
                        .setQuery(query, User.class)
                        .build();


        FirebaseRecyclerAdapter<User, UsersViewHolder> adapter = new FirebaseRecyclerAdapter<User, UsersViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull UsersViewHolder holder, int position, @NonNull User user) {
                holder.setName(user.getName());
                holder.setUserStatus(user.getStatus());
                holder.setProfileImage(user.getImage());
            }

            @Override
            public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                Log.d(SettingsActivity.TAG, "onCreateViewHolder: 4");
                View mView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.user_layout, parent, false);
                Log.d(SettingsActivity.TAG, "onCreateViewHolder: 5");
                return new UsersViewHolder(mView);
            }
        };
        usersList.setAdapter(adapter);
        adapter.startListening();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder{


        private View mView;

        public UsersViewHolder(View itemView) {
            super(itemView);
            this.mView = itemView;
        }

        public void setName(String name){
            Log.d(TAG, "setName: 1");
            TextView txtUserName = (TextView)mView.findViewById(R.id.txtUserNameId);
            txtUserName.setText(name);
            Log.d(TAG, "setName: 2");
        }

        public void setUserStatus(String status){
            Log.d(TAG, "setUserStatus: 1");
            TextView txtUserStatus = (TextView)mView.findViewById(R.id.txtUserStatusIdInUsersActivity);
            txtUserStatus.setText(status);
            Log.d(TAG, "setUserStatus: 2");
        }

        public void setProfileImage(String imgUrl){
            ImageView imgUserProfile = (ImageView)mView.findViewById(R.id.imgUserIdInUsersActivity);
            Picasso.with(UsersActivity.this).load(imgUrl).into(imgUserProfile);
        }
    }
}
