package com.example.cj.assignmentthree;

import android.app.Activity;

public class Question extends Activity{
    private int qid;                // Question ID
    private String questionStr;     // Question String
    private String questionType;    // Type of question
    private boolean booleanAnswer;  // Boolean answer
    private String stringAnswer, textAnswerOne, textAnswerTwo, textAnswerThree; // String answer options and final answer
    private int intAnswer; // Integer answer

    // We'd never really use this, it would be an empty question.
    public Question(){
        qid = 0;
        questionType = "N/A";
        questionStr = "N/A";
        booleanAnswer = false;
    }

    // CAN'T USE THIS, KEPT FOR REFERENCE
    // True or False Question
    public Question(int qid, String questionType, String questionStr, boolean booleanAnswer){
        this.qid = qid;
        this.questionType = questionType;
        this.questionStr = questionStr;
        this.booleanAnswer = booleanAnswer;
    }

    // EditText Question
    public Question(int qid, String questionType, String questionStr, String stringAnswer){
        this.qid = qid;
        this.questionType = questionType;
        this.questionStr = questionStr;
        this.stringAnswer = stringAnswer;
    }

    // NumberPicker Question
    public Question(int qid, String questionType, String questionStr, int intAnswer){
        this.qid = qid;
        this.questionType = questionType;
        this.questionStr = questionStr;
        this.intAnswer = intAnswer;
    }

    public int getQID(){
        return this.qid;
    }

    public String getQuestionType(){
        return this.questionType;
    }

    public String getQuestionStr(){
        return this.questionStr;
    }

    public boolean getAnswer(){
        return this.booleanAnswer;
    }

    public String getStrAnswer(){
        return this.stringAnswer;
    }

    public int getIntAnswer(){
        return this.intAnswer;
    }
}
