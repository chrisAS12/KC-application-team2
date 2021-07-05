package com.example.KCbootcampapplication.domain;
import lombok.Data;

@Data
public class Result {
    private String userAnswer;
    private String correctAnswer;
    private KnowledgeCheck kc;

    private Double calculateResult(){
        double correctAnswerCounter = 0d;
        int questions = kc.getQuestion().size();
        if (userAnswer.equalsIgnoreCase(correctAnswer)){
            correctAnswerCounter++;
        }
        return correctAnswerCounter/questions;
    }

    private void showEndMessage(){
        int correctAnswerCounter = kc.getQuestion().size();
        if (!userAnswer.equalsIgnoreCase(correctAnswer)){
            correctAnswerCounter--;
        }
        System.out.println("You answered correct to " + correctAnswerCounter
        + " questions out of "+ kc.getQuestion().size());
    }
}
