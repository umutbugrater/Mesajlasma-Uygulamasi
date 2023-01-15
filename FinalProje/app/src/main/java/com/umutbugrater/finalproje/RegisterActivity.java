package com.umutbugrater.finalproje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.umutbugrater.finalproje.model.UserModel;

public class RegisterActivity extends AppCompatActivity {
    EditText email , password;
    Button login , signup;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.editTextTextEmailRegister);
        password = findViewById(R.id.editTextTextPasswordRegister);
        login = findViewById(R.id.buttonLoginRegister);
        signup = findViewById(R.id.buttonSignupRegister);
        firebaseAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(userEmail,userPassword).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                UserModel user = new UserModel(userEmail, userPassword);
                                String uid = task.getResult().getUser().getUid();
                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference reference = database.getReference("users").child(uid);
                                reference.setValue(user);

                                startActivity(new Intent(RegisterActivity.this,SplashActivity.class));
                            }
                        });
            }
        });
    }
}