package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUserName = findViewById(R.id.inputUserName);

        //If quiz restarted
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        inputUserName.setText(username);
    }

    public void quizInteract(View view)
    {
        String userName = inputUserName.getText().toString();

        //Online tutorial usage of name input
        if (userName.matches(""))
        {
            Toast.makeText(this, "Enter User Name", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra("username", inputUserName.getText().toString());
            startActivity(intent);
            finish();   // Closes the main activity
        }
    }
}