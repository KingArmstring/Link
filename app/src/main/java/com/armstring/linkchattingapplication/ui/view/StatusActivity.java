package com.armstring.linkchattingapplication.ui.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.armstring.linkchattingapplication.R;
import com.armstring.linkchattingapplication.ui.view.main_view.MainActivity;
import com.armstring.linkchattingapplication.ui.view.register_view.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class StatusActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextInputLayout edtStatus;
    private Button btnSave;
    private DatabaseReference reference;
    private FirebaseUser currentUser;
    private ProgressDialog progressDialog;
    public static final String TAG = "Armstring";
    private String oldStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String currentUId = currentUser.getUid();
        reference = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUId);

        Toolbar toolbar= (Toolbar) findViewById(R.id.statusActivityToolbarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Account Status");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Saving Changes");
        progressDialog.setMessage("Please wait while changes are saved");
        progressDialog.show();
        edtStatus = (TextInputLayout)findViewById(R.id.edtStatusInput);
        btnSave = (Button)findViewById(R.id.btnSaveNewStatus);


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                HashMap<String, String> userMap = new HashMap<>();
                userMap = (HashMap<String, String>) dataSnapshot.getValue();
                oldStatus = userMap.get("status");
                progressDialog.hide();
                edtStatus.getEditText().setText(oldStatus);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                String status = edtStatus.getEditText().getText().toString();
                reference.child("status").setValue(status).addOnCompleteListener(new OnCompleteListener<Void>() {//task will be successful if setting the value went well.
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            progressDialog.dismiss();
                            Intent intent = new Intent(StatusActivity.this, SettingsActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(StatusActivity.this, "Unexpected Error Occurred, Please Try again.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
