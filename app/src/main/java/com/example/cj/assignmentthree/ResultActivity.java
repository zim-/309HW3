package com.example.cj.assignmentthree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;


public class ResultActivity extends Activity {
    Button replayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        replayBtn = (Button) findViewById(R.id.resetGame);

        TextView resultScore = (TextView) findViewById(R.id.resultScore);
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        resultScore.setText("Final Score: " + score + "/3");

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAgain();
            }
        });
    }

    public void playAgain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}