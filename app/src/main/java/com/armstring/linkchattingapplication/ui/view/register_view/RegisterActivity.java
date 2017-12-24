package com.armstring.linkchattingapplication.ui.view.register_view;

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

import com.armstring.linkchattingapplication.R;
import com.armstring.linkchattingapplication.ui.view.main_view.MainActivity;
import com.armstring.linkchattingapplication.ui.view.mvp_contracts.RegisterContract;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.RegisterView{
    private TextInputLayout name;
    private TextInputLayout email;
    private TextInputLayout password;
    private Button btnRegister;
    private FirebaseAuth mAuth;
    private Toolbar toolbar;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar)findViewById(R.id.toolbarRegisterId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAuth = FirebaseAuth.getInstance();name = (TextInputLayout)findViewById(R.id.reg_display_name);
        email = (TextInputLayout)findViewById(R.id.reg_email);
        password = (TextInputLayout)findViewById(R.id.reg_password);
        btnRegister = (Button)findViewById(R.id.btnCreateAccount);

        progressDialog = new ProgressDialog(this);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!name.getEditText().getText().toString().isEmpty()
                        && !email.getEditText().getText().toString().isEmpty()
                        && !password.getEditText().getText().toString().isEmpty()){
                    String strName = name.getEditText().getText().toString();
                    String strEmail = email.getEditText().getText().toString();
                    String strPassword = password.getEditText().getText().toString();
                    progressDialog.setTitle("Registering User");
                    progressDialog.setMessage("Please wait while we create your account!");
                    progressDialog.setCanceledOnTouchOutside(false);

                    progressDialog.show();//this will show up the progress dialog
                    registerUser(strName, strEmail, strPassword);
                }else{
                    Toast.makeText(RegisterActivity.this, "Fill all fields", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void registerUser(String strName, String strEmail, String strPassword){
        mAuth.createUserWithEmailAndPassword(strEmail, strPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "User Added :)", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            progressDialog.dismiss();
                            startActivity(intent);
                            finish();
                        }else{
                            progressDialog.hide();
                            Toast.makeText(RegisterActivity.this, "Authentication Error", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}
