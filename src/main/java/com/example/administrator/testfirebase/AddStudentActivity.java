package com.example.administrator.testfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddStudentActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private EditText etName, etFatherName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        etName = (EditText) findViewById(R.id.etName);
        etFatherName = (EditText) findViewById(R.id.etFatherName);

    }

    public void addStudent(View view){
        DatabaseReference ref = database.getReference("Users");

        DatabaseReference usersRef = ref.child("User");

        Map<String, User> users = new HashMap<>();
        users.put("UserInfo", new User(etName.getText().toString(), etFatherName.getText().toString()));

        usersRef.setValue(users);
    }
}
