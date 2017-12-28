package com.armstring.linkchattingapplication.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.armstring.linkchattingapplication.R;

public class ProfileActivity extends AppCompatActivity {

    private TextView txtUserClickedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String userClickedId = getIntent().getStringExtra("USER_CLICKED_ID");
        txtUserClickedId = (TextView)findViewById(R.id.txtUserClickedId);
    }
}
