package com.example.cj.assignmentthree;


import java.util.ArrayList;
import java.util.List;

public class QuestionGenerator {
    // Create our questions and store them in a list that we'll loop through later.
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();

        quesList.add(new Question(0, "intAnswer", "How many planets are in our Solar System?", 8));
        quesList.add(new Question(1, "stringAnswer", "Often called the 'Red Planet'", "Mars"));
//        quesList.add(new Question(2, "Boolean", "The capital of Slovakia is Bratislava.", true));

        // return quest list
        return quesList;
    }
}


