package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class ResultActivity extends AppCompatActivity {

    // Declaring variables
    String userName, score;
    TextView mainText, scoreText;
    Button restartQuiz, finishQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Getting the intent
        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        score = intent.getStringExtra("score");

        mainText = findViewById(R.id.mainTextView);
        scoreText = findViewById(R.id.scoreTextView);
        restartQuiz = findViewById(R.id.restartQuizButton);
        finishQuiz = findViewById(R.id.finishQuizButton);

        mainText.setText("Well done " + userName + "!" );
        scoreText.setText(score + "/5");
    }


    // Public Methods
    public void restartQuiz(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("userName", userName);
        startActivity(intent);
        finish();
    }

    public void finishQuiz(View view)
    {
        finish();
    }
}