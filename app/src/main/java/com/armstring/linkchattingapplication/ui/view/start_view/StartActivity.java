package com.armstring.linkchattingapplication.ui.view.start_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.armstring.linkchattingapplication.R;
import com.armstring.linkchattingapplication.ui.view.SettingsActivity;
import com.armstring.linkchattingapplication.ui.view.login_view.LoginActivity;
import com.armstring.linkchattingapplication.ui.view.mvp_contracts.StartContract;
import com.armstring.linkchattingapplication.ui.view.register_view.RegisterActivity;

public class StartActivity extends AppCompatActivity implements StartContract.StartView{

    private Button btnRegister;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnLogin = (Button)findViewById(R.id.btnSignIn);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
