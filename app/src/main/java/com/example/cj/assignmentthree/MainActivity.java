// Charles Highley
// CSC 309 - Assignment 3
package com.example.cj.assignmentthree;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.List;
import android.content.Intent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score = 0;
    public int qid = 0;                                        // Current question, we need this to increment so we can switch questions.

    public String currentQID;                                   // Debug QID value only
    private List<Question> qList;                               // List of questions
    private Question currentQuestion;                           // Current Question
    public String DebugAnswer;                                  // Debug, delete this

    // Default Answers
    public String stringAnswer;
    public int intAnswer = -1;

    private TextView txtQuestion, scored;                       // Textview for Question, and Score
    //public Button btn_true, btn_false;                         // True/False Buttons
    public Button submitAnswerBtn;

    FrameLayout frmLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Target the FrameLayout so we can dynamically insert views.
        frmLayout = (FrameLayout)findViewById(R.id.innerContentLayout);
        frmLayout.setFocusable(true);

        // The questions are hard-coded in the QuestionGenerator object.
        QuestionGenerator qGen = new QuestionGenerator();
        qList = qGen.getAllQuestions();                     // Add all the questions from qGen object to a list.
        currentQuestion = qList.get(qid);                   // Get question ID for current QID value
        String questionType = currentQuestion.getQuestionType();
        currentQID = currentQuestion.getQID() + "";         // Debug QID value only

        txtQuestion = (TextView) findViewById(R.id.question_text);
        scored = (TextView) findViewById(R.id.score);

        submitAnswerBtn = (Button) findViewById(R.id.submitAnswerBtn);

        final EditText EditTextAnswer = new EditText(this);
        final NumberPicker numberPickerAnswer = new NumberPicker(this);

        // Start the quiz.
        setQuestionView();

        // Switch case here for type of question
        switch (questionType){
            case "stringAnswer":
                //EditText EditTextAnswer = new EditText(this);
                frmLayout.addView(EditTextAnswer, 100, 200);
                EditTextAnswer.setWidth(300);
                //stringAnswer = EditTextAnswer.getText().toString();
                break;
            case "intAnswer":
                //NumberPicker numberPickerAnswer = new NumberPicker(this);
                numberPickerAnswer.setMaxValue(9);
                numberPickerAnswer.setMinValue(0);
                frmLayout.addView(numberPickerAnswer, 100, 100);
                //intAnswer = numberPickerAnswer.getValue();
                break;
            default: questionType = "N/A";
                break;
        }

        // Check Answer with Submit Button
        submitAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(numberPickerAnswer.getValue(), EditTextAnswer.getText().toString());
            }
        });

        Toast.makeText(getApplicationContext(), stringAnswer, Toast.LENGTH_LONG).show();

    }

    // Test user choice for correct answer
    public void getAnswer(int intAnswer, String stringAnswer) {
        if (intAnswer > -1) {
            if(currentQuestion.getIntAnswer() == intAnswer){
                score++;                                        // Increment Score
                scored.setText("Score: " + score + "/3");       // Update score text displayed to user
                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "STRING NULL", Toast.LENGTH_LONG).show();
        }

        if (stringAnswer != null && !stringAnswer.isEmpty()) {
            if((currentQuestion.getStrAnswer()).equals(stringAnswer)){
                score++;                                        // Increment Score
                scored.setText("Score: " + score + "/3");       // Update score text displayed to user
                Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "STRING NULL", Toast.LENGTH_LONG).show();
        }

        // Remove previous question view to make room for the next.
//        frmLayout.removeAllViews();

        //If current Question ID is less than 3, keep incrementing, otherwise, end game and go to Results layout.
        if (qid < 3) {
            Toast.makeText(getApplicationContext(), "QID++", Toast.LENGTH_LONG).show();
            qid++; // Increase Question ID to switch to the next question.
            currentQuestion = qList.get(qid);
            setQuestionView();
        } else {
            endGame();
        }
    }

    // Call when we've run out of questions to give the user.
    private void endGame() {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        Bundle b = new Bundle();
        b.putInt("score", score); // End Score
        intent.putExtras(b);
        startActivity(intent);
        finish();
    }

    // Start the quiz by setting the question text to the first question in our list.
    private void setQuestionView() {
        txtQuestion.setText("" + currentQuestion.getQuestionStr());



    }

}
