package com.armstring.linkchattingapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextInputLayout loginUserName;
    private TextInputLayout loginPassword;
    private Button btnLogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar)findViewById(R.id.toolBarLoginActivityId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loginUserName = (TextInputLayout)findViewById(R.id.edtLoginUserName);
        loginPassword = (TextInputLayout)findViewById(R.id.edtLoginPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginUserName.getEditText().getText().toString();
                String password = loginPassword.getEditText().getText().toString();
                if(!email.isEmpty() && !password.isEmpty()){
                    progressDialog.setTitle("Logging In Please Wait!");
                    progressDialog.setMessage("Please Wait While we check for your account");
                    progressDialog.setCanceledOnTouchOutside(false);
                    loginUser(email, password);
                }
            }
        });
    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, "Logged In", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    progressDialog.hide();
                    Toast.makeText(LoginActivity.this, "Login Failed\nmake sure Email and Password are correct", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
